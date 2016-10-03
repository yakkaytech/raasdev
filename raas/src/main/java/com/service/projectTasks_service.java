package com.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vo.crtproject_vo;
import com.vo.projectTasks_vo;
import com.vo.projectTasksgp_vo;
import com.wrapper.wrapper;

public interface projectTasks_service {

	void saveptaskgroup(projectTasksgp_vo tasks, int project_id) throws Exception;

	List<wrapper> gettaskgroup(int project_id) throws Exception;

	List<wrapper> gettasktype() throws Exception;

	List<wrapper> gettasksize() throws Exception;

	List<wrapper> gettaskdetails(int project_id) throws Exception;

	void saveptaskdetails(projectTasks_vo taskdetails, MultipartFile file, int project_id) throws Exception;

	String gettaskgpbaseddetails(projectTasks_vo taskgp) throws Exception;

	String editTask(projectTasks_vo taskdetails) throws Exception;

	List<wrapper> gettaskviewbaseddetails(projectTasks_vo taskgp) throws Exception;

	void getUsername(Principal principal, String userName) throws Exception;

	List<wrapper> getproject_id(int project_id) throws Exception;

	void getupdatetaskdetail(projectTasks_vo ptv) throws Exception;

	String editptaskgroup(projectTasksgp_vo tasks, int project_id) throws Exception;

	List<wrapper> edittaskdetails(projectTasks_vo taskdetails, MultipartFile file) throws Exception;

	void deletedetails(int task_group_id) throws Exception;

}
