package com.dao;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vo.crtproject_vo;
import com.vo.feature_vo;
import com.vo.projecttasks_vo;
import com.vo.projecttasksgp_vo;
import com.vo.user_vo;
import com.wrapper.wrapper;

public interface projecttasks_dao {

	public void saveptaskgroup(feature_vo tasks, int project_id, String username) throws Exception;

	public List<wrapper> gettaskgroup(int project_id) throws Exception;

	public List<wrapper> gettasktype() throws Exception;

	public List<wrapper> gettasksize() throws Exception;

	public List<wrapper> gettaskdetails(int project_id) throws Exception;

	public List<wrapper> gettaskgpbaseddetails(projecttasks_vo taskgp) throws Exception;

	public void taskCreatedActivity(projecttasks_vo taskdetails, MultipartFile file, int project_id, String username) throws Exception;

	public String editTask(projecttasks_vo edtsk) throws Exception;

	public List<wrapper> gettaskviewbaseddetails(projecttasks_vo taskgp) throws Exception;

	public void getUsername(Principal principal, String userName) throws Exception;

	public List<wrapper> getproject_id(int project_id) throws Exception;

	public void getupdatetaskdetail(projecttasks_vo ptv) throws Exception;

	public String editptaskgroup(feature_vo tasks, int project_id) throws Exception;

	public String edittaskdetails(projecttasks_vo taskdetails, MultipartFile file) throws Exception;

	public void deletedetails(int feature_id) throws Exception;

	public List<wrapper> getpriority_code() throws Exception;

	public String loadeditgroup(int task_group_id) throws Exception;
	
	public List<wrapper> getuserrole(String userName) throws Exception;

	

}
