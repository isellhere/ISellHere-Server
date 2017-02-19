package org.es.project.services.interfaces;

import org.es.project.models.User;

public interface UserService {
	public Iterable<User> findAll();
	public User findByEmail(String email);
	public User findById(Long id);
	public User findByUsername(String username);
	public User save(User user);
	public User delete(Long id);
	public User update(User user);

}
