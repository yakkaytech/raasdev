package com.service;

import org.springframework.web.multipart.MultipartFile;

import com.vo.projectTasks_vo;

public interface TaskStatusService {

	void taskCreatedActivity(projectTasks_vo taskdetails, MultipartFile file, int project_id, String username)
			throws Exception;

	void taskreadyactivity(projectTasks_vo ptv) throws Exception;

	void taskInprogressactivity(projectTasks_vo ptv) throws Exception;

	void taskcompletedactivity(projectTasks_vo ptv) throws Exception;

	void tasksignedoffactivity(projectTasks_vo ptv) throws Exception;

}
