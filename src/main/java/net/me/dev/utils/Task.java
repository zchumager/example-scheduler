package net.me.dev.utils;

public class Task implements Runnable {
	private String message;
	
	public Task() {
		this.message = "RUNNING TASK";
	}
	
	public void run() {
		System.out.println(this.message);
	}
	
}
