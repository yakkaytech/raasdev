package com.dao;

import java.util.List;

import com.vo.crtproject_vo;
import com.wrapper.wrapper;

public interface crtproject_dao {

	public void proregister(crtproject_vo crt,String userName)throws Exception;
	public List<wrapper> projecttype() throws Exception;
}
