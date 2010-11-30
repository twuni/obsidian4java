package org.twuni.obsidian.model;

public enum Visibility {

	PUBLIC( "public" ),
	FRIENDS( "friends" ),
	PRIVATE( "private" );

	private String key;

	private Visibility( String key ) {
		this.key = key;
	}

	public static Visibility value( String key ) {
		for( Visibility visibility : values() ) {
			if( visibility.key.equals( key ) ) {
				return visibility;
			}
		}
		return PUBLIC;
	}

}
