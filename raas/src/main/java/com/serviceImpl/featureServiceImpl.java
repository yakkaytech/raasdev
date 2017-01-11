package com.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.feature_dao;
import com.dao.projectTasks_dao;
import com.dao.feature_dao;
import com.service.featureService;
import com.vo.feature_vo;
import com.vo.projectTasksgp_vo;
import com.wrapper.wrapper;


@Service
public class featureServiceImpl implements featureService {

	@Autowired
	private projectTasks_dao taskgroupdao;
	
	
	@Autowired
	private feature_dao featuredao;
	
	
	
	public List<wrapper> gettaskgroup(int project_id) throws Exception {
		return taskgroupdao.gettaskgroup(project_id);
	}

	public List<wrapper> getfeaturesets(int project_id) throws Exception {
		return featuredao.getfeaturesets(project_id);
	}

	public String addfeature(feature_vo ptv, String userName,String token,int project_id) throws Exception {
           return featuredao.addfeature(ptv,userName,token,project_id);		
	}


	public String loadeditgroup(int task_group_id) throws Exception {
		return featuredao.loadeditgroup(task_group_id);
	}

	public String managefeature(feature_vo tasks, int project_id) throws Exception {
		return featuredao.managefeature(tasks,project_id);
	}

	public String removefeature(int feature_id,int project_id) throws Exception {
		return featuredao.removefeature(feature_id,project_id);
	}

	public List<wrapper> getfeaturepro_sets(int project_id) throws Exception {
		return featuredao.getfeaturepro_sets(project_id);
	}
}
