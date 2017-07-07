package com.passmanage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.passmanage.bean.Users;
import com.passmanage.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Resource(name="usersService")
	private UsersService usersService;
	
	
	
	
	/*@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String login(String username,String password){
		System.out.println("------UsersController.login------");
		
		
		return "login";
	}
	
	@RequestMapping(value="/index.htm",method=RequestMethod.POST)
	public String index(String username,String password){
		System.out.println("------UsersController.login------");
		
		
		return "index";
	}*/
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session){
		System.out.println("------UsersController.login------");
		Users users= usersService.findUsersByNameAndPassword(username, password);
		if (users==null) {
			return "redirect:/login.html";
		}
		session.setAttribute("users", users);
		return "redirect:/index.html";
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(Users users){
		System.out.println("------UsersController.regist------");
		usersService.insertUsers(users);
		return "redirect:/registwait.html";
	}
	
}
