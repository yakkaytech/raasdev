package com.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.feature_dao;
import com.dao.projecttasks_dao;
import com.dao.feature_dao;
import com.service.feature_service;
import com.vo.feature_vo;
import com.vo.projecttasksgp_vo;
import com.wrapper.wrapper;


@Service
public class feature_serviceImpl implements feature_service {

	@Autowired
	private projecttasks_dao taskGroupDao;
	
	
	@Autowired
	private feature_dao featureDao;
	
	
	
	public List<wrapper> gettaskgroup(int project_id) throws Exception {
		return taskGroupDao.gettaskgroup(project_id);
	}

	public List<wrapper> getfeaturesets(int project_id) throws Exception {
		return featureDao.getfeaturesets(project_id);
	}

	public String addfeature(feature_vo ptv, String userName,String token,int project_id) throws Exception {
           return featureDao.addfeature(ptv,userName,token,project_id);		
	}


	public String loadeditgroup(int task_group_id) throws Exception {
		return featureDao.loadeditgroup(task_group_id);
	}

	public String managefeature(feature_vo tasks, int project_id) throws Exception {
		return featureDao.managefeature(tasks,project_id);
	}

	public String removefeature(int feature_id,int project_id) throws Exception {
		return featureDao.removefeature(feature_id,project_id);
	}

	public List<wrapper> getfeaturepro_sets(int project_id) throws Exception {
		return featureDao.getfeaturepro_sets(project_id);
	}
}
