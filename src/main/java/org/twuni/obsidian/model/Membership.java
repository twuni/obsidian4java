package org.twuni.obsidian.model;

import org.twuni.obsidian.util.JSONBuilder;

public class Membership {

	private User user = new User();
	private Campaign campaign = new Campaign();
	private Role role = Role.NONE;

	public Campaign getCampaign() {
		return campaign;
	}

	public Role getRole() {
		return role;
	}

	public User getUser() {
		return user;
	}

	public void setCampaign( Campaign campaign ) {
		this.campaign = campaign;
	}

	public void setRole( Role role ) {
		this.role = role;
	}

	public void setUser( User user ) {
		this.user = user;
	}

	@Override
	public String toString() {

		JSONBuilder json = new JSONBuilder();

		json.beginObject();
		json.value( "user", getUser().toString() );
		json.value( "role", getRole().toString() );
		json.value( "campaign", getCampaign().toString() );
		json.endObject();

		return json.toString();

	}

}
