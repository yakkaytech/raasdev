package com.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.dao.memberrequest_dao;
import com.service.memberrequest_service;
import com.vo.memberRequest_vo;
import com.wrapper.wrapper;


@Service
public class memberrequest_serviceImpl implements memberrequest_service{
	
	@Autowired
	private memberrequest_dao memberRequestDao;

	public String createVerificationTokenForUser(String token, memberRequest_vo req,int user_id) throws Exception {
		return memberRequestDao.createVerificationTokenForUser(token,req,user_id);
	}

	public List<wrapper> getmessage() throws Exception {
		return memberRequestDao.getmessage();
	}

	public void saveemailcopy(SimpleMailMessage email,String email_id,int user_id, int message_id) {
		memberRequestDao.saveemailcopy(email, email_id, user_id,  message_id);
		
	}

}
