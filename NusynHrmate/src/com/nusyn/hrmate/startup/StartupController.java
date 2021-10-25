package com.nusyn.hrmate.startup;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;


import com.nusyn.hrmate.service.UserService;

@Service
public class StartupController  implements ApplicationContextAware, ServletContextAware {


	@Autowired
	private UserService userService;
	public void start() {
		userService.save();

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub

	}

}
