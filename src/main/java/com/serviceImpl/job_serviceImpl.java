package com.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.projectteam_dao;
import com.service.job_service;
import com.vo.projectrole_vo;
import com.wrapper.wrapper;

@Service
public class job_serviceImpl implements job_service{
	
	@Autowired
	projectteam_dao projectTeamDao;

	

	public String getJobById() {
		return projectTeamDao.getJobById();
	}



	public List<wrapper> getAllJobs(projectrole_vo prv) throws Exception {
		
		return projectTeamDao.getAllJobs(prv);
	    
	}

	public List<wrapper> getprojectdetails(projectrole_vo prv,int project_id) throws Exception {
		return projectTeamDao.getprojectdetails(prv, project_id);
	}

	public List<wrapper> getavailableroles(projectrole_vo prv,int project_id) throws Exception {
		
		List<wrapper> newlist = projectTeamDao.getavailableroles(prv, project_id);
		List<wrapper> list=new ArrayList();
	    int index=newlist.size();
	    
	    for(int i=0;i<index;i++){
	    
		 String role_name =newlist.get(i).getRole_name();
    	 String description =newlist.get(i).getDes();
    	 int rate =newlist.get(i).getRate();
    	 String frequency =newlist.get(i).getFrequency();
    	 String category_code =newlist.get(i).getCategory_code();

    	 
    	 wrapper obj = new wrapper();
    	 
    	 obj.setRole_name(role_name);
    	 obj.setDes(description);
    	 obj.setRate(rate);
    	 obj.setFrequency(frequency);
    	 obj.setCategory_code(category_code);
    	 obj.setRole_count(index);

    	 list.add(obj);
    	 
	    }
		return list;
}



	public List<wrapper> getuserid(String username) throws Exception {
		return projectTeamDao.getuserid(username);
	}
	
}
