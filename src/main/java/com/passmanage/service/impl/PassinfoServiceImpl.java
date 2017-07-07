package com.passmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passmanage.bean.Passinfo;
import com.passmanage.dao.PassinfoDao;
import com.passmanage.service.PassinfoService;
import com.passmanage.vo.PassinfoVo;

@Service(value="passinfoService")
public class PassinfoServiceImpl implements PassinfoService {

	@Autowired
	private PassinfoDao passinfoDao;
	
	@Override
	public List<PassinfoVo> selectAll(int userId) {
		
		List<PassinfoVo> passinfoVos= passinfoDao.selectAll(userId);
		return passinfoVos;
	}

	@Override
	public Passinfo selectByPid(String pid) {
		Passinfo passinfo= passinfoDao.selectByPid(Integer.parseInt(pid));
		return passinfo;
	}

	@Override
	public List<Passinfo> selectByCid(int userId, int cid) {
		List<Passinfo> passinfos = passinfoDao.selectByCid(userId, cid);
		return passinfos;
	}

	@Override
	public int insertPassinfo(Passinfo passinfo) {
		return passinfoDao.insertPassinfo(passinfo);
	}

	@Override
	public int updatePassinfoByPid(Passinfo passinfo) {
		return passinfoDao.updatePassinfoByPid(passinfo);
	}

}
