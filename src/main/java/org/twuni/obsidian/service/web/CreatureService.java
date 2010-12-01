package org.twuni.obsidian.service.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.twuni.obsidian.client.ObsidianClient;
import org.twuni.obsidian.model.Campaign;
import org.twuni.obsidian.model.Creature;
import org.twuni.obsidian.util.JSONBuilder;
import org.twuni.obsidian.util.Properties;

class CreatureService extends Service<Creature> implements org.twuni.obsidian.service.CreatureService {

	protected CreatureService( ObsidianClient client ) {
		super( client );
	}

	@Override
	public Creature create( Creature creature ) {
		return post( String.format( "/campaigns/%s/characters", creature.getCampaign().getId() ), creature );
	}

	@Override
	public void delete( Creature creature ) {
		delete( String.format( "/campaigns/%s/characters/%s", creature.getCampaign().getId(), creature.getId() ) );
	}

	@Override
	public Creature getById( Campaign campaign, String id ) {
		return get( String.format( "/campaigns/%s/characters/%s", campaign.getId(), id ) );
	}

	@Override
	public Creature getBySlug( Campaign campaign, String slug ) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put( "use_slug", "true" );
		return get( String.format( "/campaigns/%s/characters/%s", campaign.getId(), slug ), parameters );
	}

	@Override
	public Set<Creature> list( Campaign campaign ) {
		return list( String.format( "/campaigns/%s/characters", campaign.getId() ) );
	}

	@Override
	public Creature update( Creature creature ) {
		return put( String.format( "/campaigns/%s/characters/%s", creature.getCampaign().getId(), creature.getId() ), creature );
	}

	@Override
	protected Creature adapt( Properties properties ) {

		Creature creature = new Creature();

		creature.setAuthor( properties.getUser( "author_id" ) );
		creature.setAvatarUrl( properties.getString( "avatar_url" ) );
		creature.setBiographyAsHtml( properties.getString( "bio_html" ) );
		creature.setBiographyAsText( properties.getString( "bio" ) );
		creature.getCampaign().setId( properties.getString( "campaign_id" ) );
		creature.setId( properties.getString( "id" ) );
		creature.setName( properties.getString( "name" ) );
		creature.setSlug( properties.getString( "slug" ) );
		creature.setUrl( properties.getString( "character_url" ) );
		creature.setTagline( properties.getString( "tagline" ) );
		creature.setPlayer( properties.getBoolean( "is_player_character" ) );
		creature.setDescriptionAsText( properties.getString( "description" ) );
		creature.setDescriptionAsHtml( properties.getString( "description_html" ) );
		creature.getTags().addAll( properties.getList( "tags", String.class ) );
		creature.setGameMasterInfoAsText( properties.getString( "game_master_info" ) );
		creature.setGameMasterInfoAsHtml( properties.getString( "game_master_info_html" ) );
		creature.setVisibleToGameMasterOnly( properties.getBoolean( "is_game_master_only" ) );
		creature.setDateCreated( properties.getDate( "created_at" ) );
		creature.setDateUpdated( properties.getDate( "updated_at" ) );

		return creature;

	}

	@Override
	protected String adapt( Creature model ) {
		JSONBuilder json = new JSONBuilder();
		return json.toString();
	}

}
