package org.twuni.obsidian.service.web;

import org.twuni.obsidian.client.ObsidianClient;

public class WebServiceFactory {

	public static org.twuni.obsidian.service.PageService createPageService( ObsidianClient client ) {
		return new PageService( client );
	}

	public static org.twuni.obsidian.service.CampaignService createCampaignService( ObsidianClient client ) {
		return new CampaignService( client );
	}

	public static org.twuni.obsidian.service.CreatureService createCreatureService( ObsidianClient client ) {
		return new CreatureService( client );
	}

	public static org.twuni.obsidian.service.UserService createUserService( ObsidianClient client ) {
		return new UserService( client );
	}

}
