package com.dao;

import java.util.List;

import com.vo.message_vo;
import com.wrapper.wrapper;

public interface message_dao {
	
	public List<wrapper> messagedata(String username,message_vo msg) throws Exception; 

 //   public void messageactivity(message_vo msg,String username) throws Exception;

    public List<wrapper> message(message_vo msg,String username) throws Exception;
    
//	public List<wrapper> getuser_id(int user_id) throws Exception;

//  public int getuser_id(String username) throws Exception;

//	public String getfirstname(String username) throws Exception;

	public List<wrapper> userlist(String username,message_vo msg) throws Exception;

	public List<wrapper> connect(String username) throws Exception;
		
	public List<wrapper> disconnect(String username) throws Exception;

	public List<wrapper> messages(message_vo msg) throws Exception;

	public String getMessageById(Integer message_id) throws Exception;

	public List<wrapper> getUserMessages(String username,message_vo msg) throws Exception;

	public List<wrapper> SendMessage(message_vo msg,String username)throws Exception;

	public List<wrapper> getUserMessagebycreated(String username) throws Exception;

	public String deletemessage(int message_id, String username) throws Exception;
	
}
