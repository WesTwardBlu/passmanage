package com.passmanage.dao;

import com.passmanage.bean.Users;

public interface UsersDao {
    int deleteByPrimaryKey(Integer uid);

    int insertUsers(Users users);


    //登陆
    Users findUsersByNameAndPassword(String username,String password);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}