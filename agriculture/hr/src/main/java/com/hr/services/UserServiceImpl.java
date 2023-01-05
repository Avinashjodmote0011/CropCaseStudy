package com.hr.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.model.User;
import com.hr.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userrepo;

	@Override
	public List<User> getAllAccounts() {
		
		List<User> userlist=userrepo.findAll();
		return userlist;
	}

	@Override
	public String delete(int id) {
		userrepo.deleteByUserId(id);
		return "account deleted successfully";
	}
	@Override
	public String update(User user) {
		User user1=userrepo.findByUserId(user.getId());
		user1.setPassword(user.getPassword());
		userrepo.save(user1);
		return "updated profile";
	}

//	@Override
//	public List<User> getAllFarmerAccounts(String role) {
//		List<User> userList=userrepo.findByRoles(role);
//		return userList;
//	}
	
	

}

