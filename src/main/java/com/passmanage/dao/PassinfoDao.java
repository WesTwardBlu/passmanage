package com.passmanage.dao;

import java.util.List;

import com.passmanage.bean.Passinfo;
import com.passmanage.vo.PassinfoVo;

public interface PassinfoDao {
	
	List<PassinfoVo> selectAll(int uid);
	
	List<Passinfo> selectByCid(int uid,int cid);
	
	Passinfo selectByPid(int pid);
	
	int insertPassinfo(Passinfo passinfo);
	
	int updatePassinfoByPid(Passinfo passinfo);
	
	
	
    int deleteByPrimaryKey(Integer pid);




}