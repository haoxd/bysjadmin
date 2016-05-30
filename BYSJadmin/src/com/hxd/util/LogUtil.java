package com.hxd.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class LogUtil {
	
	
	
	
	

	private static Logger sysoLog(String sysolog,Object obj){
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
		Logger log = Logger.getLogger(obj.getClass());
		log.info(sysolog);
		return log;
	}

}
