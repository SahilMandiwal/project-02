package com.sm.project.service;

import java.util.*;

import com.sm.project.entity.UserData;

public interface UserServices {
	
	public  int saverUser(UserData ud) ;
	
	public boolean loginCheck(UserData ud);
	
	public List<UserData> getAll();
	
	public UserData getSingleData(int ID);
	
	public List<UserData> updateData(UserData ud);
	
	
	
	
		
	

}
