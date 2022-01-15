package com.coderscampus.assignment13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.assignment13.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
