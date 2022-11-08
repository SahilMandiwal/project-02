package com.sm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sm.project.entity.UserData;
import com.sm.project.service.UserServices;




@Controller
public class UserController {
	
	@Autowired
	private UserServices us;
	
	@GetMapping("/wcl")
	public String openForm() {
		
		return "RegForm";
		
	}
	
	@GetMapping("/login")
	public String preLogin() {
		
		return "login";
	}
	
	
	@GetMapping("/log")
	public String logCheck(UserData ud) {
		
		System.out.println(ud);
		boolean loginCheck = us.loginCheck(ud);
		
		if(loginCheck) {
			return "loginSuccess";
		}else
			return "loginFail";
			
	
		
	}
	
	@PostMapping("/reg")
	public String sucessForm(UserData ud,Model ml) {
		
		System.out.println("Controller Layer");
		System.out.println(ud);
		
		int id = us.saverUser(ud);
	
		ml.addAttribute("ID" ,id);
		
		return "RegSucess";
		
	}
	
	@GetMapping("/getSingleData/{ID}")
	public String SingleUserData(@PathVariable int ID,Model ml) {
		
		System.out.println(ID);
		UserData udSingle=us.getSingleData(ID);
		System.out.println(udSingle);
		
		ml.addAttribute("UserData", udSingle);
		
		return "SingleUserData";
	}
	
	@GetMapping("/alldata")
	public String getAllData(Model ml) {
		
		List<UserData> all=us.getAll();
		
		ml.addAttribute("List",all);
		
		
		return "getAll";
		
	}
	
	@GetMapping("/updateUser")
	public String updateData(UserData ud,Model ml) {
		
		System.out.println(ud);
		List<UserData> udupdate=us.updateData(ud);
		System.out.println(udupdate);
		ml.addAttribute("list",udupdate);
		
		return "updateList";
		
	}
	
	@GetMapping("/update")
	public String update() {
		return "update";
	}

}
