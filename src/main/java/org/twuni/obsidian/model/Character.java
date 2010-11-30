package org.twuni.obsidian.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Character {

	private String id;
	private String name;
	private String slug;
	private String url;
	private Date dateCreated;
	private Date dateUpdated;
	private String tagline;

	private Set<String> tags = new HashSet<String>();
	private String avatarUrl;
	private Campaign campaign = new Campaign();
	private User author;
	private boolean player;
	private boolean visibleToGameMasterOnly;

	private String descriptionAsText;
	private String descriptionAsHtml;

	private String biographyAsText;
	private String biographyAsHtml;

	private String gameMasterInfoAsText;
	private String gameMasterInfoAsHtml;

	public User getAuthor() {
		return author;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public String getBiographyAsHtml() {
		return biographyAsHtml;
	}

	public String getBiographyAsText() {
		return biographyAsText;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public String getDescriptionAsHtml() {
		return descriptionAsHtml;
	}

	public String getDescriptionAsText() {
		return descriptionAsText;
	}

	public String getGameMasterInfoAsHtml() {
		return gameMasterInfoAsHtml;
	}

	public String getGameMasterInfoAsText() {
		return gameMasterInfoAsText;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSlug() {
		return slug;
	}

	public String getTagline() {
		return tagline;
	}

	public Set<String> getTags() {
		return tags;
	}

	public String getUrl() {
		return url;
	}

	public boolean isPlayer() {
		return player;
	}

	public boolean isVisibleToGameMasterOnly() {
		return visibleToGameMasterOnly;
	}

	public void setAuthor( User author ) {
		this.author = author;
	}

	public void setAvatarUrl( String avatarUrl ) {
		this.avatarUrl = avatarUrl;
	}

	public void setBiographyAsHtml( String biographyAsHtml ) {
		this.biographyAsHtml = biographyAsHtml;
	}

	public void setBiographyAsText( String biographyAsText ) {
		this.biographyAsText = biographyAsText;
	}

	public void setCampaign( Campaign campaign ) {
		this.campaign = campaign;
	}

	public void setDateCreated( Date dateCreated ) {
		this.dateCreated = dateCreated;
	}

	public void setDateUpdated( Date dateUpdated ) {
		this.dateUpdated = dateUpdated;
	}

	public void setDescriptionAsHtml( String descriptionAsHtml ) {
		this.descriptionAsHtml = descriptionAsHtml;
	}

	public void setDescriptionAsText( String descriptionAsText ) {
		this.descriptionAsText = descriptionAsText;
	}

	public void setGameMasterInfoAsHtml( String gameMasterInfoAsHtml ) {
		this.gameMasterInfoAsHtml = gameMasterInfoAsHtml;
	}

	public void setGameMasterInfoAsText( String gameMasterInfoAsText ) {
		this.gameMasterInfoAsText = gameMasterInfoAsText;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public void setPlayer( boolean player ) {
		this.player = player;
	}

	public void setSlug( String slug ) {
		this.slug = slug;
	}

	public void setTagline( String tagline ) {
		this.tagline = tagline;
	}

	public void setTags( Set<String> tags ) {
		this.tags = tags;
	}

	public void setUrl( String url ) {
		this.url = url;
	}

	public void setVisibleToGameMasterOnly( boolean visibleToGameMasterOnly ) {
		this.visibleToGameMasterOnly = visibleToGameMasterOnly;
	}

}
