package org.twuni.obsidian.service;

import org.twuni.obsidian.model.Campaign;

public interface CampaignService {

	public Campaign getById( String id );

	public Campaign getBySlug( String slug );

}
