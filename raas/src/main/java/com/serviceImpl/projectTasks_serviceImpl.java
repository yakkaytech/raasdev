package com.serviceImpl;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.projectTasks_dao;
import com.service.projectTasks_service;
import com.vo.crtproject_vo;
import com.vo.projectTasks_vo;
import com.vo.projectTasksgp_vo;
import com.wrapper.wrapper;

@Service
public class projectTasks_serviceImpl implements projectTasks_service {

	@Autowired
	projectTasks_dao taskgroupdao;

	public void saveptaskgroup(projectTasksgp_vo tasks, int project_id) throws Exception {
		taskgroupdao.saveptaskgroup(tasks, project_id);
	}

	public List<wrapper> gettaskgroup(int project_id) throws Exception {
		return taskgroupdao.gettaskgroup(project_id);
	}

	public List<wrapper> gettasktype() throws Exception {
		return taskgroupdao.gettasktype();
	}

	public List<wrapper> gettasksize() throws Exception {
		return taskgroupdao.gettasksize();
	}

	public List<wrapper> gettaskdetails(int project_id) throws Exception {
		return taskgroupdao.gettaskdetails(project_id);
	}

	public void saveptaskdetails(projectTasks_vo taskdetails, MultipartFile file, int project_id) throws Exception {
		taskgroupdao.saveptaskdetails(taskdetails, file, project_id);

	}

	public String gettaskgpbaseddetails(projectTasks_vo taskgp) throws Exception {
		return taskgroupdao.gettaskgpbaseddetails(taskgp);
	}

	public String editTask(projectTasks_vo edtsk) throws Exception {
		return taskgroupdao.editTask(edtsk);
	}

	public List<wrapper> gettaskviewbaseddetails(projectTasks_vo taskgp) throws Exception {
		return taskgroupdao.gettaskviewbaseddetails(taskgp);
	}

	public void getUsername(Principal principal, String userName) throws Exception {
		taskgroupdao.getUsername(principal, userName);

	}

	public List<wrapper>  getproject_id(int project_id) throws Exception {
		return taskgroupdao.getproject_id(project_id);
	}

	public void getupdatetaskdetail(projectTasks_vo ptv) throws Exception {
		taskgroupdao.getupdatetaskdetail(ptv);

	}

	public String editptaskgroup(projectTasksgp_vo tasks, int project_id) throws Exception {
		return taskgroupdao.editptaskgroup(tasks, project_id);
	}
	public List<wrapper> edittaskdetails(projectTasks_vo taskdetails,MultipartFile file) throws Exception {
		 return taskgroupdao.edittaskdetails(taskdetails,file);
		
	}

	public void deletedetails(int task_group_id) throws Exception {
		taskgroupdao.deletedetails(task_group_id);
		
	}

}
