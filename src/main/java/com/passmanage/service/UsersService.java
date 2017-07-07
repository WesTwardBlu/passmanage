package com.passmanage.service;

import com.passmanage.bean.Users;

public interface UsersService {
	Users findUsersByNameAndPassword(String username,String password);

	void insertUsers(Users users);
	
	
}
