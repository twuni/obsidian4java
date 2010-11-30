package org.twuni.obsidian.client;

import java.io.IOException;
import java.net.URISyntaxException;

import org.twuni.authentication.oauth.client.OAuthClient;

import net.oauth.OAuthException;

public abstract class ObsidianClient extends OAuthClient {

	public ObsidianClient( String consumerKey, String consumerSecret ) throws IOException, OAuthException, URISyntaxException {
		this( consumerKey, consumerSecret, "oob" );
	}

	public ObsidianClient( String consumerKey, String consumerSecret, String callbackUrl ) throws IOException, OAuthException, URISyntaxException {
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
