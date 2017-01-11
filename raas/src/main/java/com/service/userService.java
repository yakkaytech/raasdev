package com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vo.registration_vo;
import com.vo.skill;
import com.vo.user_vo;
import com.wrapper.wrapper;

@Service
public interface userService {
	void registration(registration_vo ravo) throws Exception;

	void createVerificationTokenForUser(String token, registration_vo reg) throws Exception;

	void reg_activation(String token, registration_vo reg, String email) throws Exception;

	String gettoken(String email_id) throws Exception;

	void resendVerificationTokenForUser(String token, registration_vo reg) throws Exception;

	List<wrapper> getuserdetails(int userid) throws Exception;

	void skills(user_vo va, String username) throws Exception;

	List getuserSkill(String term) throws Exception;

	void getuserdetails(registration_vo rvo, user_vo uvo, MultipartFile file, String token) throws Exception;

	void getuserdetail(registration_vo rvo, user_vo uvo) throws Exception;

	void insertskill(int user_id, skill[] skills) throws Exception;

	void deleteskill(int user_id, skill skills) throws Exception;

	

}
