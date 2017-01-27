package com.chat;

public class userList {
	
	private String from;
	private String time;


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public userList(String from, String time) {
 
		this.from=from;
		this.time=time;
	}

}
