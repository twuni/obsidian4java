package org.twuni.obsidian.service;

import java.util.Set;

import org.twuni.obsidian.model.Campaign;
import org.twuni.obsidian.model.Creature;

public interface CreatureService {

	public Set<Creature> list( Campaign campaign );

	public Creature getById( Campaign campaign, String id );

	public Creature getBySlug( Campaign campaign, String slug );

	public Creature create( Creature creature );

	public Creature update( Creature creature );

	public void delete( Creature creature );

}
