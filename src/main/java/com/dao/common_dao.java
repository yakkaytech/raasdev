package com.dao;

import java.util.List;

import com.vo.user_vo;
import com.wrapper.wrapper;

public interface common_dao {

    public List<wrapper> getrole() throws Exception;
	
	public List<wrapper> getcountrydata() throws Exception;
	
	public List<wrapper> gettimezonedata() throws Exception;
	
	public List<wrapper> getzonedata() throws Exception;
	
	public String dropdownstate(user_vo obj)  throws Exception;
	
	public int getuser_id(String userName) throws Exception;

	public String  getimage(int userid)throws Exception;
	
	public List getSkills(String term) throws Exception;

	public List<wrapper> getexplevel()throws Exception;

	public List<wrapper> getyearexp()throws Exception;

}
