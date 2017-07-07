package com.passmanage.service;

import java.util.List;

import com.passmanage.bean.Passinfo;
import com.passmanage.vo.PassinfoVo;

public interface PassinfoService {
	

	List<PassinfoVo> selectAll(int userId);
	
	List<Passinfo> selectByCid(int userId,int cid);
	
	Passinfo selectByPid(String pid);

	int insertPassinfo(Passinfo passinfo);

	int updatePassinfoByPid(Passinfo passinfo);
	
	
	
}
