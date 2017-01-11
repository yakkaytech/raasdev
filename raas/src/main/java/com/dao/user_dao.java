package com.dao;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vo.registration_vo;
import com.vo.skill;
import com.vo.user_vo;
import com.wrapper.wrapper;

public interface user_dao {
	
	public void registration(registration_vo ravo) throws Exception;
	public void skills(user_vo va, String username) throws Exception;
	public void createVerificationTokenForUser(String token, registration_vo reg) throws Exception;
	public void reg_activation(String token, registration_vo reg, String email_id) throws Exception;
	public String gettoken(String email_id) throws Exception;
	public void resendVerificationTokenForUser(String token, registration_vo reg) throws Exception;
	public List<wrapper> getuserdetails(int userid)throws Exception;
	public void getuserdetail(registration_vo rvo, user_vo uvo) throws Exception; 
	
	public List<wrapper> getuserskills(int userid) throws Exception;
	public void getuserupdate(registration_vo rvo, user_vo uvo, MultipartFile file,final String token) throws Exception;
	public void insertskill(int user_id, skill[] skills)throws Exception;
	public void deleteskill(int user_id, skill skills) throws Exception;
	
	
	

}
