package org.twuni.obsidian.client;

import org.twuni.authentication.oauth.client.OAuthClient;

public class ObsidianClient extends OAuthClient {

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
