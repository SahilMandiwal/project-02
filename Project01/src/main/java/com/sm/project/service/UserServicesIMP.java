package com.sm.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.project.dao.UserDao;
import com.sm.project.entity.UserData;
import java.util.*;

@Service
public class UserServicesIMP implements UserServices{
	
	
    @Autowired
	private UserDao uda;
	
	@Override
	public int saverUser(UserData ud) {
		System.out.println("Service layer method");
		System.out.println(ud);
		int id = uda.saveToDb(ud);
		
		return id;		
		
		
	}
     
	@Override
	public boolean loginCheck(UserData ud) {
	
		List<UserData> allData = uda.getAllData();
		
		for(UserData ud1:allData) {
			if(ud.getUserName().equals(ud1.getUserName())  && ud.getPassword().equals(ud1.getPassword())){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public List<UserData> getAll() {
		
		List<UserData> list=uda.getAllData_Db();
		
		return list;
	}

	@Override
	public UserData getSingleData(int ID) {
		UserData udSingle=uda.getSingle(ID);
		
		return udSingle;
	}

	@Override
	public List<UserData> updateData(UserData ud) {
		List<UserData> udupdate=uda.updateData(ud);
		return udupdate;
	}

}
