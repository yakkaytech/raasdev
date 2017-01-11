package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.projectTasks_dao;
import com.dao.projectteam_dao;
import com.service.TaskStatusService;
import com.vo.projectTasks_vo;

@Service
public class TaskStatusServiceImpl implements  TaskStatusService{

	@Autowired
	projectTasks_dao taskgroupdao;
	
	@Autowired
	projectteam_dao prjtteam_dao;
	
	
	
	public void taskCreatedActivity(projectTasks_vo taskdetails, MultipartFile file, int project_id, String username) throws Exception {
		taskgroupdao.taskCreatedActivity(taskdetails, file, project_id,username);
		
	}

	public void taskreadyactivity(projectTasks_vo ptv) throws Exception {
		prjtteam_dao.taskreadyactivity(ptv);
		
	}

	public void taskInprogressactivity(projectTasks_vo ptv) throws Exception {
		prjtteam_dao.taskInprogressactivity(ptv);
		
	}

	public void taskcompletedactivity(projectTasks_vo ptv) throws Exception {
		prjtteam_dao.taskcompletedactivity(ptv);
		
	}

	public void tasksignedoffactivity(projectTasks_vo ptv) throws Exception {
		prjtteam_dao.tasksignedoffactivity(ptv);
		
	}

}
