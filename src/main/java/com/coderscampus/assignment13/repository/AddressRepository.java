package com.coderscampus.assignment13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.assignment13.domain.Address;
import com.coderscampus.assignment13.domain.User;

public interface AddressRepository extends JpaRepository<Address,Long>{


}
