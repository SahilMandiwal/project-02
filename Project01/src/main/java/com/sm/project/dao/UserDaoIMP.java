package com.sm.project.dao;

import java.util.*;

import java.io.Serializable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import com.sm.project.entity.UserData;

@Repository
public class UserDaoIMP implements UserDao{

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public int saveToDb(UserData ud) {
		System.out.println("Dao layer method");
		System.out.println(ud);
		
		Session ses=sf.openSession();
		ses.beginTransaction();
		int save= (int) ses.save(ud);
		ses.getTransaction().commit();
		
		return save;
	}


	@Override
	public List<UserData> getAllData() {
		
		Session ses=sf.openSession();
		Query qy=ses.createQuery("from UserData");
		List<UserData> list = qy.getResultList();
		
		return list;
		
		
	}


	@Override
	public List<UserData> getAllData_Db() {
		
		Session ses=sf.openSession();
	   Query qy=ses.createQuery("from UserData");
	   List<UserData> list=qy.getResultList();
		
		return list;
	}


	@Override
	public UserData getSingle(int ID) {
		
		Session ses=sf.openSession();
		UserData ud=ses.get(UserData.class, ID);
		return  ud;
	}


	@Override
	public List<UserData> updateData(UserData ud) {
		
		Session ses=sf.openSession();
		ses.beginTransaction();
		ses.update(ud);
		ses.getTransaction().commit();
		
		Session ses1=sf.openSession();
		
		
		Query qy=ses1.createQuery("from UserData");
		List<UserData> list =qy.getResultList();
		
		return list;
	}

}
