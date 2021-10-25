package com.nusyn.hrmate.controller;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.apache.catalina.util.Base64;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nusyn.hrmate.model.Data;


@Controller
//@RequestMapping(value="/login" ,method= RequestMethod.GET)
public class LoginController {
     
	@RequestMapping(value="/" ,method=RequestMethod.GET)
	public String Welcome() {
		
		System.out.println("Login page got invoked!!");
		
		
		return "login";
	}
	

	@RequestMapping(value="/home" ,method=RequestMethod.POST)
	public String Validation(HttpServletRequest request,HttpServletRequest session) {
		

		
		String name = request.getParameter("userName");
		
		String password = request.getParameter("Password");
		
		System.out.println("the entered username is " +name);
        
		System.out.println("The entered password is " + password);
		
		
		DBManager dbManager = new DBManager();
		try {
			dbManager.validateUser("jidhin", "jidhin123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "dashboard";
	
	 }
	

	@RequestMapping(value="/home" ,method=RequestMethod.GET)
	public String homePage() {
		
		return "login";
	}
	
	@RequestMapping(value="/publish" ,method=RequestMethod.POST)
	public void publish(HttpServletRequest request) {
       
		// opens input stream from the HTTP connection
        
		try {
			InputStream inputStream;
			inputStream = request.getInputStream();
		       // opens an output stream to save into file
	        FileOutputStream outputStream = new FileOutputStream("D:/content.rar");

	        int bytesRead = -1;
	        byte[] buffer = new byte[4096];
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, bytesRead);
	        }

	        outputStream.close();
	        inputStream.close();
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
		System.out.println("Publishing Content");
		
	}
	
	@RequestMapping(value="/OnClick" ,method=RequestMethod.GET)
	public String OnClick(HttpServletRequest request) {
		System.out.println("Clicked on continue button!!");
		
		if (request.getSession(false).getAttribute("userName")== null) {
			return "login"; 
			} 
		else {
		    return "todo";
		    }
	}
	@RequestMapping(value="/logOut",method=RequestMethod.GET)
	public String logOut(HttpServletRequest request) {
		
		//destroy the session
		
		request.getSession().invalidate();
		
		return "logout";		
	}

	
	@RequestMapping(value = "/getdata", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Data> getdata() throws SQLException {
	//public ResultSet getdata(HttpServletRequest request) throws SQLException {	
		DBManager dbManager = new DBManager();
		ResultSet rstShopData = dbManager.getShopData();
		
		// Shop details
		List<Data> shopDetails = new ArrayList<Data>();
		while(rstShopData.next()) {
			shopDetails.add(new Data(rstShopData.getString(1),rstShopData.getInt(2)));
		}

		return shopDetails;
	}	
	
	
	@RequestMapping(value = "/getselectiondata", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Data> getselectiondata() throws SQLException {
	//public ResultSet getdata(HttpServletRequest request) throws SQLException {	
		DBManager dbManager = new DBManager();

	 
		//Selection type details
		ResultSet rstSelectionData = dbManager.getSelectionTypeData();
		List<Data> selectionDetails = new ArrayList<Data>();
		while(rstSelectionData.next()) {
			selectionDetails.add(new Data(rstSelectionData.getString(1),rstSelectionData.getInt(2)));
		}

		return selectionDetails;
	}	
}


