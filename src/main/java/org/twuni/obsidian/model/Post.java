package org.twuni.obsidian.model;

import java.util.Date;

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

}
