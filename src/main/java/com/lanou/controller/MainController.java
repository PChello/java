package com.lanou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.experimental.theories.ParametersSuppliedBy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping(value="/")
	public String  findPage(){

		return "indext";
	}
	
	@RequestMapping(value="/loginpage")
	public  String loginPage(){
		
		
		
		return "one";
	}
	

	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,  @RequestParam("usename") String name , @RequestParam("password") String pwd){
		
		
	HttpSession session=request.getSession();
	session.setAttribute("usename", name);
	
		return "redirect:userinfo";
		
	}
	
	@RequestMapping(value="/userinfo")
	public String userinfopage(){
			
		
		
		return "second";
	}
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request){
		
		HttpSession session=request.getSession();
		session.invalidate();
		
		return "one";
		
	}

}
