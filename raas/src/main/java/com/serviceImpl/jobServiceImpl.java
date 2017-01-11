package com.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.projectteam_dao;
import com.service.jobService;
import com.vo.projectRole_vo;
import com.wrapper.wrapper;

@Service
public class jobServiceImpl implements jobService{
	
	@Autowired
	projectteam_dao prjtteam_dao;

	

	public String getJobById() {
		// TODO Auto-generated method stub
		return prjtteam_dao.getJobById();
	}



	public List<wrapper> getAllJobs(projectRole_vo prv) throws Exception {
		
		return prjtteam_dao.getAllJobs(prv);
	    
	}

	public List<wrapper> getprojectdetails(projectRole_vo prv,int project_id) throws Exception {
		return prjtteam_dao.getprojectdetails(prv, project_id);
	}

	public List<wrapper> getavailableroles(projectRole_vo prv,int project_id) throws Exception {
		
		List<wrapper> newlist = prjtteam_dao.getavailableroles(prv, project_id);
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
		
		return prjtteam_dao.getuserid(username);
	}
	
}
