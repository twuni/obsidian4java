package org.twuni.obsidian.service;

import java.util.Set;

import org.twuni.obsidian.model.Campaign;
import org.twuni.obsidian.model.Page;

public interface PageService {

	public Set<Page> list( Campaign campaign );

	public Page getById( Campaign campaign, String id );

	public Page getBySlug( Campaign campaign, String slug );

	public Page create( Page page );

	public Page update( Page page );

	public void delete( Page page );

}
