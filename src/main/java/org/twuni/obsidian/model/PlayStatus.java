package org.twuni.obsidian.model;


public enum PlayStatus {
	
	PLANNING( "planning" ),
	IN_PLAY( "in_play" ),
	ON_HIATUS( "on_hiatus" ),
	COMPLETED( "completed" ),
	UNKNOWN( null );
	
	private String key;
	
	private PlayStatus( String key ) {
		this.key = key;
	}
	
	public static PlayStatus value( String key ) {
		for( PlayStatus status : values() ) {
			if( status.key.equals( key ) ) {
				return status;
			}
		}
		return UNKNOWN;
	}

}
