package org.twuni.obsidian.model;

import org.twuni.obsidian.util.JSONBuilder;

public class Location {

	private double latitude;
	private double longitude;

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLatitude( double latitude ) {
		this.latitude = latitude;
	}

	public void setLongitude( double longitude ) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		JSONBuilder json = new JSONBuilder();
		json.beginObject();
		json.value( "latitude", getLatitude() );
		json.value( "longitude", getLongitude() );
		json.endObject();
		return json.toString();
	}

}
