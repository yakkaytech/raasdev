package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.mail.SimpleMailMessage;

import com.vo.memberRequest_vo;
import com.wrapper.wrapper;

public interface memberrequest_dao {

	String createVerificationTokenForUser(String token, memberRequest_vo req, int user_id) throws SQLException, Exception;

	List<wrapper> getmessage() throws Exception;

	void saveemailcopy(SimpleMailMessage email, String email_id, int user_id, int message_id);

}
