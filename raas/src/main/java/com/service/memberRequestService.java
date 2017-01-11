package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import com.dao.memberRequest_dao;
import com.vo.memberRequest_vo;
import com.wrapper.wrapper;

public interface memberRequestService {

	void createVerificationTokenForUser(String token, memberRequest_vo req, int user_id) throws SQLException, Exception;

	List<wrapper> getmessage() throws Exception;

	void saveemailcopy(SimpleMailMessage email, String email_id, String from, int user_id, int message_id);

}
