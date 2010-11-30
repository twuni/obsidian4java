package org.twuni.obsidian.service.web;

import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.twuni.obsidian.client.ObsidianClient;
import org.twuni.obsidian.util.Properties;

import flexjson.JSONDeserializer;

abstract class Service<T> {

	private static final String BASE_URL = "http://api.obsidianportal.com/v1";

	private final JSONDeserializer<Map<String, Object>> deserializer = new JSONDeserializer<Map<String, Object>>();
	private final JSONDeserializer<List<Map<String, Object>>> collectionDeserializer = new JSONDeserializer<List<Map<String, Object>>>();

	private ObsidianClient client;

	protected Service( ObsidianClient client ) {
		this.client = client;
	}

	private T adapt( InputStream input ) {
		try {
			String raw = IOUtils.toString( input );
			return adapt( new Properties( deserializer.deserialize( raw ) ) );
		} catch( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}

	private Set<T> adapt( List<Map<String, Object>> items ) {
		Set<T> collection = new HashSet<T>();
		for( Map<String, Object> item : items ) {
			collection.add( adapt( new Properties( item ) ) );
		}
		return collection;
	}

	protected abstract T adapt( Properties properties );

	protected abstract String adapt( T model );

	private Set<T> adaptCollection( InputStream input ) {
		try {
			String raw = IOUtils.toString( input );
			return adapt( collectionDeserializer.deserialize( raw ) );
		} catch( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}

	protected T delete( String path ) {
		return delete( path, new HashMap<String, String>() );
	}

	protected T delete( String path, Map<String, String> parameters ) {
		try {
			return adapt( client.delete( getUrl( path ), parameters ) );
		} catch( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}

	protected T get( String path ) {
		return get( path, new HashMap<String, String>() );
	}

	protected T get( String path, Map<String, String> parameters ) {
		try {
			return adapt( client.get( getUrl( path ), parameters ) );
		} catch( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}

	private String getUrl( String path ) {
		StringBuilder url = new StringBuilder();
		url.append( BASE_URL ).append( path ).append( ".json" );
		return url.toString();
	}

	protected Set<T> list( String path ) {
		return list( path, new HashMap<String, String>() );
	}

	protected Set<T> list( String path, Map<String, String> parameters ) {
		try {
			return adaptCollection( client.get( getUrl( path ), parameters ) );
		} catch( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}

	protected T post( String path ) {
		return post( path, null );
	}

	protected T post( String path, T model ) {
		try {
			return adapt( client.post( getUrl( path ), adapt( model ) ) );
		} catch( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}

	protected T put( String path ) {
		return put( path, null );
	}

	protected T put( String path, T model ) {
		try {
			return adapt( client.put( getUrl( path ), adapt( model ) ) );
		} catch( Exception exception ) {
			throw new RuntimeException( exception );
		}
	}

}
