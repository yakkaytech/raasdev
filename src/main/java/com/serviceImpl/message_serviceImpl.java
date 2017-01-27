package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.message_dao;
import com.service.message_service;
import com.vo.message_vo;
import com.wrapper.wrapper;

@Service
public class message_serviceImpl implements message_service{
	
	@Autowired
	private message_dao msg_dao;

//	public void messageactivity(message_vo msg,String username) throws Exception {
//    	msg_dao.messageactivity(msg,username);
//    }
    
    public List<wrapper> messagedata(String username,message_vo msg) throws Exception {
		return msg_dao.messagedata(username,msg);
	}
    
//    public String message(message_vo msg, String username) throws Exception {
//    	return msg_dao.message(msg, username);
//    }
	
//    public List<wrapper>  getuser_id(int user_id) throws Exception {
//		return msg_dao.getuser_id(user_id);
//	}
    
    public List<wrapper> SendMessage(message_vo msg,String username) throws Exception{
    	 
		return msg_dao.SendMessage(msg,username);
    }
    
    public String getMessageById(Integer message_id) throws Exception {
    	return msg_dao.getMessageById(message_id);
    	
    }

	public List<wrapper> getUserMessages(String username,message_vo msg) throws Exception {
		return msg_dao.getUserMessages(username,msg);
		
	}
	
	public List<wrapper> getUserMessagebycreated(String username) throws Exception{
		return msg_dao.getUserMessagebycreated(username);
	}
	
	public String deletemessage(int message_id,String username) throws Exception {
		return msg_dao.deletemessage(message_id, username);
		
	}
	
}
