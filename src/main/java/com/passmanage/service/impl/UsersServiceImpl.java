package com.passmanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passmanage.bean.Users;
import com.passmanage.dao.UsersDao;
import com.passmanage.service.UsersService;

@Service(value="usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public Users findUsersByNameAndPassword(String username,String password) {
		Users users= null;
		users= usersDao.findUsersByNameAndPassword(username, password);
		return users;
	}

	@Override
	public void insertUsers(Users users) {
		usersDao.insertUsers(users);
	}

	

	

	


}
