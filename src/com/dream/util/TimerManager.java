package com.dream.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

public class TimerManager { 
	private static Logger logger=Logger.getLogger(TimerManager.class.getName());
	public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static Timer timer1;
	public static int time1=1000*60*60*24; //24h同步一次
	/**
	 * 从某个时间起发起定时器
	 * */
	public void timerStart(){
		 timer1=starttimer(time1);

	}
	public void timerStop(){
		if(timer1!=null){
			timer1.cancel();
		}
	}
	/**
	 * 每24小时刷新一次用户信息存储的list
	 * */
	public Timer starttimer(int time){
			if(time==time1){
			Timer timer=new Timer();
			timer.schedule(saveRate(), new Date(),time);//周期24h执行
			return timer;
		}
		return null;
	} 
	public TimerTask saveRate(){
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				try {
			//		new UserOperationImpl().userName();
			//	logger.info("定时刷新用户信息的结果：刷新list成功!");
				} catch (Exception e) {
					e.printStackTrace();
			//	logger.info("刷新用户list失败"+e);
				}
			}
		};
		return task;
	}
}