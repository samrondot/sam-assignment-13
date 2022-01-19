package com.coderscampus.assignment13.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.Address;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.repository.AccountRepository;
import com.coderscampus.assignment13.repository.AddressRepository;
import com.coderscampus.assignment13.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private AddressRepository addressRepo;
	
	public List<User> findByUsername(String username){
		return userRepo.findByUsername(username);
	}
	public List<User> findByUsernameAndName(String name, String username){
		return userRepo.findByUsernameAndName(name, username);
	}
	public List<User> findByCreatedDateBetween(LocalDate date1, LocalDate date2){
		return userRepo.findByCreatedDateBetween(date1, date2);
	}
	public User findByExactlyOneUserByUsername(String username) {
		List<User> users =  userRepo.findByExactlyOneUserByUsername(username);
		if(users.size()>0)
			return users.get(0);
		else
			return new User();
	}
	
	public Set<User> findAll(){
		return userRepo.findAllWithAccountsAndAddresses();
	}
	
	public User findOne(Long userId) {
		Optional<User> userOpt = userRepo.findById(userId);
		return userOpt.orElse(new User());
	}

	public User saveUser(User user, Address address) {
		if(user.getUserId() == null) {
			Account checking = new Account();
			checking.setAccountName("Checking Account");
			checking.getUsers().add(user);
			user.getAccounts().add(checking);
			Account savings = new Account();
			savings.setAccountName("Savings");
			savings.getUsers().add(user);
			user.getAccounts().add(savings);
			accountRepo.save(checking);
			accountRepo.save(savings);
		}
		if(user.getAddress()==null) {
		Address address1 = new Address();
		address1.setAddressLine1(address.getAddressLine1());
		address1.setAddressLine2(address.getAddressLine2());
		address1.setCity(address.getCity());
		address1.setCountry(address.getCountry());
		address1.setRegion(address.getRegion());
		address1.setZipCode(address.getZipCode());
		address1.setUser(user);
		address1.setUserId(user.getUserId());
		addressRepo.save(address1);
		user.setAddress(address1);
		}
			
			return userRepo.save(user);
		
	}
	

	public void delete(Long userId) {
		userRepo.deleteById(userId);
		
	}
	public Account findOneAccount(Long accountId) {
		Optional<Account> accountOpt = accountRepo.findById(accountId);
		return accountOpt.orElse(new Account());
		
	}
	public User findByUserId(Long userId) {
		return userRepo.findByUserId(userId);
	}

	public Optional<Address> findAddress(Address address, Long userId) {
		return addressRepo.findById(userId);
		
	}



}
