package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.common_dao;
import com.dao.user_dao;
import com.service.userService;
import com.vo.registration_vo;
import com.vo.skill;
import com.vo.user_vo;
import com.wrapper.wrapper;

@Service
public class userService_Impl implements userService {
	
	
	@Autowired
	private user_dao radao;
	@Autowired
	private common_dao cdao;
   

	public void createVerificationTokenForUser( String token, registration_vo reg) throws Exception {
		radao.createVerificationTokenForUser(token, reg);
		
		
	}

	public void reg_activation(String token, registration_vo reg,String email_id) throws Exception {
		radao.reg_activation(token,reg,email_id);
		
	}

	public String gettoken(String email_id) throws Exception {
	return radao.gettoken(email_id);
		
	}

	public void resendVerificationTokenForUser(String token, registration_vo reg) throws Exception {
		radao.resendVerificationTokenForUser(token,reg);
		
	}

	public List<wrapper> getuserdetails(int userid) throws Exception {
		
		return radao.getuserdetails(userid);
	}

	

	public void skills(user_vo va, String username) throws Exception {
		radao.skills(va, username);
		
	}

	public void registration(registration_vo ravo) throws Exception {
		radao.registration(ravo);
		
	}

	public List getuserSkill(String term) throws Exception {
		// TODO Auto-generated method stub
		return cdao.getSkills(term);
	}

	public void getuserdetails(registration_vo rvo, user_vo uvo, MultipartFile file, String token) throws Exception {
		// TODO Auto-generated method stub
		radao.getuserupdate(rvo, uvo, file, token);
	}

	public void getuserdetail(registration_vo rvo, user_vo uvo) throws Exception {
		// TODO Auto-generated method stub
		radao.getuserdetail(rvo, uvo);
	}

	public void insertskill(int user_id, skill[] skills) throws Exception {
		// TODO Auto-generated method stub
		radao.insertskill(user_id,skills);
	}

	public void deleteskill(int user_id, skill skills) throws Exception {
		// TODO Auto-generated method stub
		radao.deleteskill(user_id,skills);
	}

	

}
