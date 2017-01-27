package com.vo;

import java.sql.Date;

public class message_vo {

	public String username;
	public String messages;
    public String time;
    public String firstname;
	public Integer user_id;
    public String text;
    public Integer message_log_id;
    public Integer message_id;
	public String to_email_id;
	public String lastname;
	public Integer message_key;
	public String message_text;
	public Date date_added;
	public String action_type_code;
	public String created_by;
	public String subject;
	
	
    public message_vo(){}
	
	@Override
	public String toString() {
		return "message_vo[username="+ username +",user_id="+user_id+",messages="+messages+",time="+time+",text="+text+"]";
		   
	}
	
	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAction_type_code() {
		return action_type_code;
	}

	public void setAction_type_code(String action_type_code) {
		this.action_type_code = action_type_code;
	}

	public Integer getMessage_log_id() {
		return message_log_id;
	}

	public void setMessage_log_id(Integer message_log_id) {
		this.message_log_id = message_log_id;
	}

	public Integer getMessage_id() {
		return message_id;
	}

	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}

	public String getTo_email_id() {
		return to_email_id;
	}

	public void setTo_email_id(String to_email_id) {
		this.to_email_id = to_email_id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getMessage_key() {
		return message_key;
	}

	public void setMessage_key(Integer message_key) {
		this.message_key = message_key;
	}

	public String getMessage_text() {
		return message_text;
	}

	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
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
