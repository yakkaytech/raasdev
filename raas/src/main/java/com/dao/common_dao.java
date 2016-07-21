package com.dao;

import java.util.List;

import com.vo.user_vo;
import com.wrapper.wrapper;

public interface common_dao {

    public List<wrapper> tabledata() throws Exception;
	
	public List<wrapper> dropdowndata() throws Exception;
	
	public List<wrapper> timezonedata() throws Exception;
	
	public List<wrapper> zonedata() throws Exception;
	
	public String dropdownstate(user_vo obj)  throws Exception;
}
