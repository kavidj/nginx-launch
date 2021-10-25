package com.nusyn.hrmate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nusyn.hrmate.dao.UserDao;
import com.nusyn.hrmate.pojo.User;

@Service
public class UserService {

	@Autowired
	UserDao userdoa;
	//User u1 = null;
	public void save() {
		System.out.println("Inserting data into user table...");
		User u1 = new User();
		u1.setVchrUserName("jidhin");
		u1.setVchrPassword("jidhin123");
		u1.setChrStatus('A');
		
		User u2 = new User();
		u2.setVchrUserName("jidhin");
		u2.setVchrPassword("jidhin123");
		u2.setChrStatus('A');
		
		User u3 = new User();
		u3.setVchrUserName("kousar");
		u3.setVchrPassword("kousar123");
		u3.setChrStatus('A');
		
		User u4 = new User();
		u4.setVchrUserName("kousar");
		u4.setVchrPassword("kousar123");
		u4.setChrStatus('A');
		
		User u5 = new User();
		u5.setVchrUserName("kousar");
		u5.setVchrPassword("kousar123");
		u5.setChrStatus('A');
		
		User u6 = new User();
		u6.setVchrUserName("kousar");
		u6.setVchrPassword("kousar123");
		u6.setChrStatus('A');
		
		
		try {
			userdoa.save(u1);
			userdoa.save(u2);
			userdoa.save(u3);
			userdoa.save(u4);
			userdoa.save(u5);
			userdoa.save(u6);
		} catch (Exception e) {
			
			System.out.println("Exception in save");
			e.printStackTrace();
		}
	}

}
