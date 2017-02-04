package org.es.project.services.implementations;

import org.es.project.models.User;
import org.es.project.repositories.UserRepository;
import org.es.project.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	
	@Autowired
	public void setUserRepository(UserRepository repository){
		this.userRepository = repository;
	}
	
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User delete(Long id) {
		User deletedUser = findById(id);
		userRepository.delete(id);
		return deletedUser;
	}

	@Override
	public User update(User user) {
		User result = null;
		if(userRepository.findOne(user.getId()) != null){
			result = userRepository.save(user);
		}
		return result;
	}

}
