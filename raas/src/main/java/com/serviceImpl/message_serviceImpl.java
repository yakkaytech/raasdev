package com.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.dao.message_dao;
import com.service.message_service;
import com.vo.message_vo;
import com.wrapper.wrapper;

public class message_serviceImpl implements message_service{
	
	private message_dao msg_dao;

	public void messageactivity(message_vo msg,String username) throws Exception {
    	msg_dao.messageactivity(msg,username);
    }
    
    public List<wrapper> messagedata(String username,message_vo msg) throws Exception {
		return msg_dao.messagedata(username,msg);
	}
    
//    public String message(message_vo msg, String username) throws Exception {
//    	return msg_dao.message(msg, username);
//    }
	
//    public List<wrapper>  getuser_id(int user_id) throws Exception {
//		return msg_dao.getuser_id(user_id);
//	}

}
