package com.vo;

public class message_vo {

	public String username;
	public String messages;
    public String time;
    public String firstname;
	public Integer user_id;
    public String text; 
	
    public message_vo(){}
	
	@Override
	public String toString() {
		
		return "message_vo[username="+ username +",user_id="+user_id+",message="+messages+",time="+time+",text="+text+"]";
		   
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
