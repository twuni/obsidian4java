package org.twuni.obsidian.client;

public class AuthorizationRequiredException extends RuntimeException {

	private String authorizationUrl;

	public AuthorizationRequiredException( String authorizationUrl ) {
		this.authorizationUrl = authorizationUrl;
	}

	public String getAuthorizationUrl() {
		return authorizationUrl;
	}

}
