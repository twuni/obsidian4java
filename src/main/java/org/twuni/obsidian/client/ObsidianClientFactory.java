package org.twuni.obsidian.client;

import java.net.URL;

import org.twuni.authentication.oauth.AccessToken;
import org.twuni.authentication.oauth.ConsumerToken;
import org.twuni.authentication.oauth.RequestToken;
import org.twuni.obsidian.repository.TokenRepository;

public class ObsidianClientFactory {

	private final ConsumerToken consumerToken;
	private final TokenRepository tokenRepository;

	public ObsidianClientFactory( String consumerKey, String consumerSecret, TokenRepository tokenRepository ) {
		this.consumerToken = new ConsumerToken( consumerKey, consumerSecret );
		this.tokenRepository = tokenRepository;
	}

	public ObsidianClient createInstance( String key, URL callbackUrl ) {

		ObsidianClient client = new ObsidianClient( consumerToken, callbackUrl.toString() );

		AccessToken accessToken = tokenRepository.getAccessToken( key );

		if( accessToken == null ) {

			RequestToken requestToken = client.getRequestToken();
			tokenRepository.setRequestToken( key, requestToken );

			String authorizationUrl = client.getAuthorizationUrl( requestToken );
			throw new AuthorizationRequiredException( authorizationUrl );

		}

		client.setAccessToken( accessToken );

		return client;

	}

	public ObsidianClient createInstance( String key, String verifier ) {

		ObsidianClient client = new ObsidianClient( consumerToken );

		RequestToken requestToken = tokenRepository.getRequestToken( key );
		client.setRequestToken( requestToken );

		AccessToken accessToken = client.getAccessToken( verifier );
		tokenRepository.setAccessToken( key, accessToken );

		client.setAccessToken( accessToken );

		return client;

	}

}
