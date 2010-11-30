package org.twuni.obsidian.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public abstract class Page {

	private String id;
	private String name;
	private String slug;
	private String url;
	private Date dateCreated;
	private Date dateUpdated;

	private Campaign campaign = new Campaign();

	private Set<String> tags = new HashSet<String>();
	private String bodyAsText;
	private String bodyAsHtml;

	private boolean isGameMasterOnly;

	private String gameMasterInfoAsText;
	private String gameMasterInfoAsHtml;

	public String getBodyAsHtml() {
		return bodyAsHtml;
	}

	public String getBodyAsText() {
		return bodyAsText;
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

	public Set<String> getTags() {
		return tags;
	}

	public String getUrl() {
		return url;
	}

	public boolean isGameMasterOnly() {
		return isGameMasterOnly;
	}

	public void setBodyAsHtml( String bodyAsHtml ) {
		this.bodyAsHtml = bodyAsHtml;
	}

	public void setBodyAsText( String bodyAsText ) {
		this.bodyAsText = bodyAsText;
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

	public void setGameMasterInfoAsHtml( String gameMasterInfoAsHtml ) {
		this.gameMasterInfoAsHtml = gameMasterInfoAsHtml;
	}

	public void setGameMasterInfoAsText( String gameMasterInfoAsText ) {
		this.gameMasterInfoAsText = gameMasterInfoAsText;
	}

	public void setGameMasterOnly( boolean isGameMasterOnly ) {
		this.isGameMasterOnly = isGameMasterOnly;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public void setSlug( String slug ) {
		this.slug = slug;
	}

	public void setTags( Set<String> tags ) {
		this.tags = tags;
	}

	public void setUrl( String url ) {
		this.url = url;
	}

}
