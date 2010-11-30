package org.twuni.obsidian.service.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.twuni.obsidian.client.ObsidianClient;
import org.twuni.obsidian.model.Campaign;
import org.twuni.obsidian.model.Character;
import org.twuni.obsidian.util.JSONBuilder;
import org.twuni.obsidian.util.Properties;

public class CharacterService extends Service<Character> implements org.twuni.obsidian.service.CharacterService {

	protected CharacterService( ObsidianClient client ) {
		super( client );
	}

	@Override
	public Character create( Character character ) {
		return post( String.format( "/campaigns/%s/characters", character.getCampaign().getId() ), character );
	}

	@Override
	public void delete( Character character ) {
		delete( String.format( "/campaigns/%s/characters/%s", character.getCampaign().getId(), character.getId() ) );
	}

	@Override
	public Character getById( Campaign campaign, String id ) {
		return get( String.format( "/campaigns/%s/characters/%s", campaign.getId(), id ) );
	}

	@Override
	public Character getBySlug( Campaign campaign, String slug ) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put( "use_slug", "true" );
		return get( String.format( "/campaigns/%s/characters/%s", campaign.getId(), slug ), parameters );
	}

	@Override
	public Set<Character> list( Campaign campaign ) {
		return list( String.format( "/campaigns/%s/characters", campaign.getId() ) );
	}

	@Override
	public Character update( Character character ) {
		return put( String.format( "/campaigns/%s/characters/%s", character.getCampaign().getId(), character.getId() ), character );
	}

	@Override
	protected Character adapt( Properties properties ) {

		Character character = new Character();

		character.setAuthor( properties.getUser( "author_id" ) );
		character.setAvatarUrl( properties.getString( "avatar_url" ) );
		character.setBiographyAsHtml( properties.getString( "bio_html" ) );
		character.setBiographyAsText( properties.getString( "bio" ) );
		character.getCampaign().setId( properties.getString( "campaign_id" ) );
		character.setId( properties.getString( "id" ) );
		character.setName( properties.getString( "name" ) );
		character.setSlug( properties.getString( "slug" ) );
		character.setUrl( properties.getString( "character_url" ) );
		character.setTagline( properties.getString( "tagline" ) );
		character.setPlayer( properties.getBoolean( "is_player_character" ) );
		character.setDescriptionAsText( properties.getString( "description" ) );
		character.setDescriptionAsHtml( properties.getString( "description_html" ) );
		character.getTags().addAll( properties.getList( "tags", String.class ) );
		character.setGameMasterInfoAsText( properties.getString( "game_master_info" ) );
		character.setGameMasterInfoAsHtml( properties.getString( "game_master_info_html" ) );
		character.setVisibleToGameMasterOnly( properties.getBoolean( "is_game_master_only" ) );
		character.setDateCreated( properties.getDate( "created_at" ) );
		character.setDateUpdated( properties.getDate( "updated_at" ) );

		return character;

	}

	@Override
	protected String adapt( Character model ) {
		JSONBuilder json = new JSONBuilder();
		return json.toString();
	}

}
