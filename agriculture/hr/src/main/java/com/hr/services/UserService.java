package com.hr.services;

import java.util.List;

import com.hr.model.User;

public interface UserService {
	List<User> getAllAccounts();
	  
	   String delete(int id);
	   String update(User user);

//	List<User> getAllFarmerAccounts(String role);
}
