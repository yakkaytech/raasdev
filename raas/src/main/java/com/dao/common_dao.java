package com.dao;

import java.util.List;

import com.vo.user_vo;
import com.wrapper.wrapper;

public interface common_dao {

    public List<wrapper> role() throws Exception;
	
	public List<wrapper> countrydata() throws Exception;
	
	public List<wrapper> timezonedata() throws Exception;
	
	public List<wrapper> zonedata() throws Exception;
	
	public String dropdownstate(user_vo obj)  throws Exception;
	
	public int getuser_id(String userName) throws Exception;

	public String  getimage(int userid)throws Exception;
	
	public List getSkills(String term) throws Exception;

	public List<wrapper> getexplevel()throws Exception;

	public List<wrapper> getyearexp()throws Exception;

}
