package com.dao;



import com.vo.registration_vo;
import com.vo.user_vo;


public interface user_dao {

	
	public void registration(registration_vo ravo) throws Exception;

	public void skills(user_vo va, String username) throws Exception;
	
	

}
