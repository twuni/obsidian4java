package org.twuni.obsidian.model;

public enum Role {

	GAME_MASTER( "game_master" ),
	PLAYER( "player" ),
	FAN( "fan" ),
	NONE( null );

	private String key;

	private Role( String key ) {
		this.key = key;
	}

	public static Role value( String key ) {
		for( Role role : values() ) {
			if( role.key.equals( key ) ) {
				return role;
			}
		}
		return NONE;
	}

}
