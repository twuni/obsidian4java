package org.twuni.obsidian.service;

import org.twuni.obsidian.model.User;

public interface UserService {

	public User getCurrentUser();

	public User getById( String id );

	public User getByName( String name );

}
