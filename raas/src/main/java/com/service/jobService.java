package com.service;

import java.sql.SQLException;
import java.util.List;

import com.vo.projectRole_vo;
import com.wrapper.wrapper;

public interface jobService {

	
	List<wrapper> getAllJobs(projectRole_vo prv) throws Exception;
	String getJobById();
	List<wrapper> getprojectdetails(projectRole_vo prv, int project_id) throws Exception;
	List<wrapper> getavailableroles(projectRole_vo prv,int project_id) throws SQLException, Exception;
	List<wrapper>  getuserid(String username) throws Exception;

	

}
