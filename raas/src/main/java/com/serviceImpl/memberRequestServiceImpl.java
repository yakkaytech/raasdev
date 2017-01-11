package com.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.dao.memberRequest_dao;
import com.service.memberRequestService;
import com.vo.memberRequest_vo;
import com.wrapper.wrapper;


@Service
public class memberRequestServiceImpl implements memberRequestService{
	
	@Autowired
	private memberRequest_dao memberRequestdao;

	public void createVerificationTokenForUser(String token, memberRequest_vo req,int user_id) throws Exception {
		memberRequestdao.createVerificationTokenForUser(token,req,user_id);
	}

	public List<wrapper> getmessage() throws Exception {
		return memberRequestdao.getmessage();
	}

	public void saveemailcopy(SimpleMailMessage email,String email_id, String from,int user_id, int message_id) {
		memberRequestdao.saveemailcopy(email, email_id,  from, user_id,  message_id);
		
	}

}
