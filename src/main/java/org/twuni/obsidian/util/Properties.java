package org.twuni.obsidian.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.twuni.obsidian.model.PlayStatus;
import org.twuni.obsidian.model.Role;
import org.twuni.obsidian.model.User;
import org.twuni.obsidian.model.Visibility;

public class Properties {

	public static final DateFormat DATE_FORMAT = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss'Z'" );

	private final Map<String, Object> map;

	public Properties( Map<String, Object> map ) {
		this.map = map;
	}

	public String getString( String key ) {
		return String.class.cast( map.get( key ) );
	}

	public double getDouble( String key ) {
		return Double.class.cast( map.get( key ) ).doubleValue();
	}

	public Date getDate( String key ) {
		try {
			return DATE_FORMAT.parse( getString( key ) );
		} catch( ParseException exception ) {
			throw new RuntimeException( exception );
		}
	}

	public boolean getBoolean( String key ) {
		return Boolean.class.cast( map.get( key ) ).booleanValue();
	}

	public Visibility getVisibility( String key ) {
		return Visibility.value( getString( key ) );
	}

	public Role getRole( String key ) {
		return Role.value( getString( key ) );
	}

	public PlayStatus getPlayStatus( String key ) {
		return PlayStatus.value( getString( key ) );
	}

	@SuppressWarnings( "unchecked" )
	public <T> List<T> getList( String key, Class<T> type ) {
		return (List<T>) map.get( key );
	}

	public Locale getLocale( String key ) {
		return new Locale( getString( key ) );
	}

	public User getUser( String key ) {
		User user = new User();
		user.setId( getString( key ) );
		return user;
	}

}
