package com.passmanage.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.passmanage.bean.Passinfo;
import com.passmanage.bean.Users;
import com.passmanage.service.PassinfoService;
import com.passmanage.vo.PassinfoVo;

@Controller
@RequestMapping("/passinfo")
public class PassinfoController {
	@Resource(name="passinfoService")
	private PassinfoService passinfoService;
	
	
	@RequestMapping(value="/selectpassinfobycid")
	public @ResponseBody List<Passinfo> passinfosByCid(String cid,HttpSession session) {
		System.out.println("------PassinfoController.passinfosByCid------");
		Users users =    (Users) session.getAttribute("users");
		users= users==null?  new Users() : users;
		List<Passinfo> passinfos = passinfoService.selectByCid(users.getUid(), Integer.parseInt(cid));
		return	passinfos;
	}
	
	@RequestMapping(value="/selectpassinfo")
	public @ResponseBody List<PassinfoVo> passinfos(HttpSession session) {
		System.out.println("------PassinfoController.passinfos------");
		Users users =    (Users) session.getAttribute("users");
		users= users==null?  new Users() : users;
		List<PassinfoVo> passinfoVos = passinfoService.selectAll(users.getUid());
		return	passinfoVos;
	}
	
	
	
	/*@RequestMapping(value="/passinfotest")
	public @ResponseBody List<PassinfoVo> passinfos() {
		List<PassinfoVo> passinfoVos = passinfoService.selectAll(1);
		return	passinfoVos;
	}*/
	
	
	@RequestMapping(value="/selectpassinfodetail")
	public @ResponseBody Passinfo passinfoDetail(String pid){
		System.out.println("------PassinfoController.passinfoDetail------");
		return passinfoService.selectByPid(pid);
		
	}
	
	@RequestMapping(value="/insertpassinfo")
	public @ResponseBody String insertPassinfo(Passinfo passinfo,HttpSession session){
		System.out.println("------PassinfoController.insertPassinfo------");
		Users users =    (Users) session.getAttribute("users");
		users= users==null?  new Users() : users;
		passinfo.setUid(users.getUid());
		passinfoService.insertPassinfo(passinfo);
		return "success";
	}
	
	@RequestMapping(value="/updatepassinfo")
	public @ResponseBody String updatePassinfo(Passinfo passinfo,HttpSession session){
		System.out.println("------PassinfoController.updatePassinfo------");
		Users users =    (Users) session.getAttribute("users");
		users= users==null?  new Users() : users;
		passinfo.setUid(users.getUid());
		passinfoService.updatePassinfoByPid(passinfo);
		return "success";
	}
	
	
	
}
