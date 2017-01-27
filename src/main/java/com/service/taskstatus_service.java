package com.service;

import org.springframework.web.multipart.MultipartFile;

import com.vo.projecttasks_vo;

public interface taskstatus_service {

	void taskCreatedActivity(projecttasks_vo taskdetails, MultipartFile file, int project_id, String username)
			throws Exception;

	void taskreadyactivity(projecttasks_vo ptv) throws Exception;

	void taskInprogressactivity(projecttasks_vo ptv) throws Exception;

	void taskcompletedactivity(projecttasks_vo ptv) throws Exception;

	void tasksignedoffactivity(projecttasks_vo ptv) throws Exception;

}
