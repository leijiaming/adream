package com.dream.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * 同步接口监听
 * */
public class TimerListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent arg0) {
		new TimerManager().timerStart();
	}
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
 