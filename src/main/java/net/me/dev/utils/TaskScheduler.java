package net.me.dev.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TaskScheduler {
	private int corePoolSize = 1;
	private int taskDelay = 4;
	private int taskPeriod = 0;
	private String dayOfTheWeek = "";
	private ScheduledExecutorService taskScheduler;
	private ScheduledFuture<?> sf;
	private Runnable task = null;
	
	public TaskScheduler(Runnable task) {
		this.task = task;
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		this.dayOfTheWeek = sdf.format(date);
		
		System.out.println("TODAY IS: " + this.dayOfTheWeek);
	}
	
	public void turnOn() {
		switch(this.dayOfTheWeek) {
			case "miercoles":
				this.taskPeriod = 3;
				break;
			case "jueves":
				this.taskPeriod = 2;
				break;
			case "viernes":
				this.taskPeriod = 1;
				break;
			default:
				this.taskPeriod = 0;
				System.out.println("THE PROCESS IS NOT EXECUTED TODAY");
		}
		
		if(this.taskPeriod != 0) {
			this.taskScheduler = Executors.newScheduledThreadPool(this.corePoolSize);
			this.taskScheduler.scheduleAtFixedRate(this.task, this.taskDelay, this.taskPeriod, TimeUnit.SECONDS);
		}
	}
	
	public void shutDown() {
		if(this.taskScheduler != null)
			this.taskScheduler.shutdown();
	}
}
