package org.twuni.obsidian.repository;

import org.twuni.authentication.oauth.AccessToken;
import org.twuni.authentication.oauth.RequestToken;

public interface TokenRepository {

	public AccessToken getAccessToken( String userId );

	public RequestToken getRequestToken( String userId );

	public void setAccessToken( String userId, AccessToken accessToken );

	public void setRequestToken( String userId, RequestToken requestToken );

}
