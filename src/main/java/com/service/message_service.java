package com.service;

import java.util.List;

import com.vo.message_vo;
import com.wrapper.wrapper;

public interface message_service {
	
 //   public void messageactivity(message_vo msg,String username) throws Exception;
	
	public List<wrapper> messagedata(String username,message_vo msg) throws Exception;

//	public String message(message_vo msg, String username) throws Exception;

//	List<wrapper> getuser_id(int user_id) throws Exception;
	
	public List<wrapper> SendMessage(message_vo msg,String username) throws Exception;
	
	public String getMessageById(Integer message_id ) throws Exception;

	public List<wrapper> getUserMessages(String username,message_vo msg) throws Exception;

	public List<wrapper> getUserMessagebycreated(String username) throws Exception;

	public String deletemessage(int message_id, String username) throws Exception;
	
}
