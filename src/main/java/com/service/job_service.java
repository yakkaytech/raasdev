package com.service;

import java.sql.SQLException;
import java.util.List;

import com.vo.projectrole_vo;
import com.wrapper.wrapper;

public interface job_service {

	
	List<wrapper> getAllJobs(projectrole_vo prv) throws Exception;
	String getJobById();
	List<wrapper> getprojectdetails(projectrole_vo prv, int project_id) throws Exception;
	List<wrapper> getavailableroles(projectrole_vo prv,int project_id) throws SQLException, Exception;
	List<wrapper>  getuserid(String username) throws Exception;

	

}
