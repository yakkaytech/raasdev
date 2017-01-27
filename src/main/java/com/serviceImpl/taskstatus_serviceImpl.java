package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.projecttasks_dao;
import com.dao.projectteam_dao;
import com.service.taskstatus_service;
import com.vo.projecttasks_vo;

@Service
public class taskstatus_serviceImpl implements  taskstatus_service{

	@Autowired
	projecttasks_dao taskGroupDao;
	
	@Autowired
	projectteam_dao projectTeamDao;
	
	
	
	public void taskCreatedActivity(projecttasks_vo taskdetails, MultipartFile file, int project_id, String username) throws Exception {
		taskGroupDao.taskCreatedActivity(taskdetails, file, project_id,username);
		
	}

	public void taskreadyactivity(projecttasks_vo ptv) throws Exception {
		projectTeamDao.taskreadyactivity(ptv);
		
	}

	public void taskInprogressactivity(projecttasks_vo ptv) throws Exception {
		projectTeamDao.taskInprogressactivity(ptv);
		
	}

	public void taskcompletedactivity(projecttasks_vo ptv) throws Exception {
		projectTeamDao.taskcompletedactivity(ptv);
		
	}

	public void tasksignedoffactivity(projecttasks_vo ptv) throws Exception {
		projectTeamDao.tasksignedoffactivity(ptv);
		
	}

}
