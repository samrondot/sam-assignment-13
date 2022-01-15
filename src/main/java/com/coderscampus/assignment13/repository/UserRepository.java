package com.coderscampus.assignment13.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.assignment13.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	List<User> findByUsername(String usernname);
	
	List<User> findByName (String name);
	
	List<User> findByUsernameAndName(String name, String username);
	
	List<User> findByCreatedDateBetween(LocalDate date1, LocalDate date2);
	
	@Query("select u from User u where username = :username")
	List<User> findByExactlyOneUserByUsername(String username);
	
}
