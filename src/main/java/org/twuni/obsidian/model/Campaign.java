package org.twuni.obsidian.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Campaign {

	private String id;
	private String name;
	private String slug;
	private String url;
	private Date dateCreated;
	private Date dateUpdated;

	private Visibility visibility = Visibility.PUBLIC;
	private Set<Membership> members = new HashSet<Membership>();
	private String bannerUrl;
	private PlayStatus playStatus = PlayStatus.UNKNOWN;
	private boolean lookingForPlayers;
	private Location location = new Location();

	public String getBannerUrl() {
		return bannerUrl;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public String getId() {
		return id;
	}

	public Location getLocation() {
		return location;
	}

	public Set<Membership> getMembers() {
		return members;
	}

	public String getName() {
		return name;
	}

	public PlayStatus getPlayStatus() {
		return playStatus;
	}

	public String getSlug() {
		return slug;
	}

	public String getUrl() {
		return url;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public boolean isLookingForPlayers() {
		return lookingForPlayers;
	}

	public void setBannerUrl( String bannerUrl ) {
		this.bannerUrl = bannerUrl;
	}

	public void setDateCreated( Date dateCreated ) {
		this.dateCreated = dateCreated;
	}

	public void setDateUpdated( Date dateUpdated ) {
		this.dateUpdated = dateUpdated;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public void setLocation( Location location ) {
		this.location = location;
	}

	public void setLookingForPlayers( boolean lookingForPlayers ) {
		this.lookingForPlayers = lookingForPlayers;
	}

	public void setMembers( Set<Membership> members ) {
		this.members = members;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public void setPlayStatus( PlayStatus playStatus ) {
		this.playStatus = playStatus;
	}

	public void setSlug( String slug ) {
		this.slug = slug;
	}

	public void setUrl( String url ) {
		this.url = url;
	}

	public void setVisibility( Visibility visibility ) {
		this.visibility = visibility;
	}

}
