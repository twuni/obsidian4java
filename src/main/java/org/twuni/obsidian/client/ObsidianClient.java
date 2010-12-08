package org.twuni.obsidian.client;

import org.twuni.authentication.oauth.ConsumerToken;
import org.twuni.authentication.oauth.client.OAuthClient;

public class ObsidianClient extends OAuthClient {
	
	public ObsidianClient( ConsumerToken consumerToken ) {
		this( consumerToken, "oob" );
	}

	public ObsidianClient( ConsumerToken consumerToken, String callbackUrl ) {
		this( consumerToken.getKey(), consumerToken.getSecret(), callbackUrl );
	}

	public ObsidianClient( String consumerKey, String consumerSecret ) {
		this( consumerKey, consumerSecret, "oob" );
	}

	public ObsidianClient( String consumerKey, String consumerSecret, String callbackUrl ) {
		super( consumerKey, consumerSecret, callbackUrl );
	}

	@Override
	protected String getAccessTokenUrl() {
		return "https://www.obsidianportal.com/oauth/access_token";
	}

	@Override
	protected String getAuthorizationUrl() {
		return "https://www.obsidianportal.com/oauth/authorize";
	}

	@Override
	protected String getRequestTokenUrl() {
		return "https://www.obsidianportal.com/oauth/request_token";
	}

}
