package org.twuni.authentication.oauth;

public class OAuthToken {

	private String key;
	private String secret;

	public OAuthToken() {
	}

	public OAuthToken( String key, String secret ) {
		this.key = key;
		this.secret = secret;
	}

	public String getKey() {
		return key;
	}

	public void setKey( String key ) {
		this.key = key;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret( String secret ) {
		this.secret = secret;
	}

}
