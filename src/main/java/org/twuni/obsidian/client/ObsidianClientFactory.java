package org.twuni.obsidian.client;

import org.twuni.authentication.oauth.ConsumerToken;
import org.twuni.authentication.oauth.client.OAuthClientFactory;
import org.twuni.authentication.oauth.repository.TokenRepository;

public class ObsidianClientFactory extends OAuthClientFactory<ObsidianClient> {

	public ObsidianClientFactory( String consumerKey, String consumerSecret, TokenRepository tokenRepository ) {
		this( new ConsumerToken( consumerKey, consumerSecret ), tokenRepository );
	}

	public ObsidianClientFactory( ConsumerToken consumerToken, TokenRepository tokenRepository ) {
		super( consumerToken, tokenRepository );
	}

	@Override
	protected ObsidianClient createInstance( ConsumerToken consumerToken ) {
		return new ObsidianClient( consumerToken );
	}

	@Override
	protected ObsidianClient createInstance( ConsumerToken consumerToken, String callbackUrl ) {
		return new ObsidianClient( consumerToken, callbackUrl );
	}
}
