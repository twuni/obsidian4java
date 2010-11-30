package org.twuni.obsidian.service;

import java.util.Set;

import org.twuni.obsidian.model.Campaign;
import org.twuni.obsidian.model.Character;

public interface CharacterService {

	public Set<Character> list( Campaign campaign );

	public Character getById( Campaign campaign, String id );

	public Character getBySlug( Campaign campaign, String slug );

	public Character create( Character character );

	public Character update( Character character );

	public void delete( Character character );

}
