package org.twuni.obsidian.util;

import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang.StringEscapeUtils;

public class JSONBuilder {

	private StringBuilder json = new StringBuilder();

	public JSONBuilder beginObject() {
		json.append( "{" );
		return this;
	}

	public JSONBuilder endObject() {
		removeTrailingComma();
		json.append( "}" );
		return this;
	}

	public JSONBuilder beginList() {
		json.append( "[" );
		return this;
	}

	public JSONBuilder endList() {
		removeTrailingComma();
		json.append( "]" );
		return this;
	}

	private JSONBuilder removeTrailingComma() {
		if( json.charAt( json.length() - 1 ) == ',' ) {
			json.deleteCharAt( json.length() - 1 );
		}
		return this;
	}

	private JSONBuilder next() {
		json.append( "," );
		return this;
	}

	public JSONBuilder key( String key ) {
		json.append( "'" ).append( StringEscapeUtils.escapeJavaScript( key ) ).append( "':" );
		return this;
	}

	private JSONBuilder value( String value ) {
		json.append( "'" ).append( StringEscapeUtils.escapeJavaScript( value ) ).append( "'" );
		return next();
	}

	public JSONBuilder value( double value ) {
		json.append( value );
		return next();
	}

	public JSONBuilder value( String key, double value ) {
		key( key );
		return value( value );
	}

	public JSONBuilder value( String key, String value ) {
		if( value == null ) {
			return this;
		}
		key( key );
		return value( value );
	}

	public <T> JSONBuilder value( String key, Collection<T> value ) {
		if( value == null ) {
			return this;
		}
		key( key );
		beginList();
		for( T item : value ) {
			value( item.toString() );
		}
		endList();
		return next();
	}

	public JSONBuilder value( String key, Date value ) {
		if( value == null ) {
			return this;
		}
		return value( key, Properties.DATE_FORMAT.format( value ) );
	}

	public JSONBuilder value( String key, boolean value ) {
		key( key );
		json.append( value );
		return next();
	}

	@Override
	public String toString() {
		return json.toString();
	}

}
