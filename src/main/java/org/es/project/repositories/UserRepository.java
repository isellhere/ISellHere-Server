package org.es.project.repositories;

import org.es.project.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query(value = "Select user from User user where user.username=:username")
	public User findByUsername(@Param("username") String username);
	
	@Query(value = "Select user from User user where user.email=:email")
	public User findByEmail(@Param("email") String email);

}
