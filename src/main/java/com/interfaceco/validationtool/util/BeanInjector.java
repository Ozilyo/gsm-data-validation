package com.interfaceco.validationtool.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanInjector {
	public static ApplicationContext ctx;
	
	@Autowired
	private void setApplicationContext(ApplicationContext applicationContext){
		ctx = applicationContext;
	}
}
