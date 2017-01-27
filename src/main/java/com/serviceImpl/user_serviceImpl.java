package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.common_dao;
import com.dao.user_dao;
import com.service.user_service;
import com.vo.registration_vo;
import com.vo.skill;
import com.vo.user_vo;
import com.wrapper.wrapper;

@Service
public class user_serviceImpl implements user_service {
	
	
	@Autowired
	private user_dao userDao;
	
	@Autowired
	private common_dao commonDao;
   

	public void createVerificationTokenForUser( String token, registration_vo reg) throws Exception {
		userDao.createVerificationTokenForUser(token, reg);
		
		
	}

	public void reg_activation(String token, registration_vo reg,String email_id) throws Exception {
		userDao.reg_activation(token,reg,email_id);
		
	}

	public String gettoken(String email_id) throws Exception {
	return userDao.gettoken(email_id);
		
	}

	public void resendVerificationTokenForUser(String token, registration_vo reg) throws Exception {
		userDao.resendVerificationTokenForUser(token,reg);
		
	}

	public List<wrapper> getuserdetails(int userid) throws Exception {
		
		return userDao.getuserdetails(userid);
	}
	public void skills(user_vo va, String username) throws Exception {
		userDao.skills(va, username);
	}

	public void registration(registration_vo ravo) throws Exception {
		userDao.registration(ravo);
		
	}

	public List getuserSkill(String term) throws Exception {
		return commonDao.getSkills(term);
	}

	public void getuserdetails(registration_vo rvo, user_vo uvo, MultipartFile file, String token) throws Exception {
		userDao.getuserupdate(rvo, uvo, file, token);
	}

	public void getuserdetail(registration_vo rvo, user_vo uvo) throws Exception {
		userDao.getuserdetail(rvo, uvo);
	}

	public void insertskill(int user_id, skill[] skills) throws Exception {
		userDao.insertskill(user_id,skills);
	}

	

	public void insertskill(int user_id, skill[] skills, skill skill) throws Exception {
		// TODO Auto-generated method stub
		userDao.insertskill(user_id,skills,skill);
	}

	public List<wrapper> getuserSkills(int userid) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getuserSkills(userid);
	}

	public List<wrapper> getuserrole(int userid) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getuserRole(userid);
	}

	

}
