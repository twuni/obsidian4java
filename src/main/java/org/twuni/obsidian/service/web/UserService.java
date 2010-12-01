package org.twuni.obsidian.service.web;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.twuni.obsidian.client.ObsidianClient;
import org.twuni.obsidian.model.Membership;
import org.twuni.obsidian.model.User;
import org.twuni.obsidian.util.JSONBuilder;
import org.twuni.obsidian.util.Properties;

class UserService extends Service<User> implements org.twuni.obsidian.service.UserService {

	public UserService( ObsidianClient client ) {
		super( client );
	}

	@Override
	public User getById( String id ) {
		return get( "/users/" + id );
	}

	@Override
	public User getByName( String name ) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put( "use_username", "true" );
		return get( "/users/" + name, parameters );
	}

	@Override
	public User getCurrentUser() {
		return get( "/users/me" );
	}

	@Override
	protected User adapt( Properties properties ) {

		User user = new User();

		user.setTimeZoneOffset( properties.getString( "utc_offset" ) );
		user.setName( properties.getString( "username" ) );
		user.setId( properties.getString( "id" ) );
		user.setDateCreated( properties.getDate( "created_at" ) );
		user.setDateLastSeen( properties.getDate( "last_seen_at" ) );
		user.setLocale( properties.getLocale( "locale" ) );
		user.setAvatarUrl( properties.getString( "avatar_url" ) );
		user.setProfileUrl( properties.getString( "profile_url" ) );
		user.setAscendant( properties.getBoolean( "is_ascendant" ) );

		Set<Membership> memberships = new HashSet<Membership>();

		@SuppressWarnings( "rawtypes" )
        List<Map> campaigns = properties.getList( "campaigns", Map.class );

		for( Map<String, Object> campaign : campaigns ) {

			Properties p = new Properties( campaign );

			Membership membership = new Membership();

			membership.getCampaign().setUrl( p.getString( "campaign_url" ) );
			membership.getCampaign().setId( p.getString( "id" ) );
			membership.getCampaign().setName( p.getString( "name" ) );
			membership.setRole( p.getRole( "role" ) );
			membership.getCampaign().setVisibility( p.getVisibility( "visibility" ) );

			memberships.add( membership );

		}

		user.setCampaigns( memberships );

		return user;

	}

	@Override
    protected String adapt( User model ) {
		JSONBuilder json = new JSONBuilder();
		return json.toString();
    }

}
