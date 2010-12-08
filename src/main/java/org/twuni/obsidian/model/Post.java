package org.twuni.obsidian.model;

import java.util.Date;

import org.twuni.obsidian.util.JSONBuilder;

public class Post extends Page {

	public static final String TYPE = "Post";

	private String title;
	private String tagline;
	private Date date;

	public Date getDate() {
		return date;
	}

	public String getTagline() {
		return tagline;
	}

	public String getTitle() {
		return title;
	}

	public void setDate( Date date ) {
		this.date = date;
	}

	public void setTagline( String tagline ) {
		this.tagline = tagline;
	}

	public void setTitle( String title ) {
		this.title = title;
	}
	
	@Override
	public String toString() {

		JSONBuilder json = new JSONBuilder();

		json.beginObject();
		json.key( "wiki_page" );
		json.beginObject();
		json.value( "name", getName() );
		json.value( "body", getBodyAsText() );
		json.value( "game_master_info", getGameMasterInfoAsText() );
		json.value( "is_game_master_only", isGameMasterOnly() );
		json.value( "tags", getTags() );
		json.value( "post_title", getTitle() );
		json.value( "post_tagline", getTagline() );
		json.value( "post_time", getDate() );
		json.endObject();
		json.endObject();

		return json.toString();
	}

}
