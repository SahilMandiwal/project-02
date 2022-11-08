package com.sm.project.dao;

import java.util.*;

import com.sm.project.entity.UserData;

public interface UserDao {
	
	public int saveToDb(UserData ud);
	
	public List<UserData> getAllData();
	
	public List<UserData> getAllData_Db();
	
	public UserData getSingle(int ID);
	
	public List<UserData> updateData (UserData ud);
	

}
