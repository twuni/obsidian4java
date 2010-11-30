package org.twuni.obsidian.model;

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

}
