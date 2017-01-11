package com.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vo.ProposalTasksVO;
import com.vo.crtproject_vo;
import com.vo.feature_vo;
import com.vo.projectTasks_vo;
import com.vo.projectTasksgp_vo;
import com.wrapper.wrapper;

public interface projectTasks_service {

	void saveptaskgroup(feature_vo tasks, int project_id, String username) throws Exception;

	List<wrapper> gettasktype() throws Exception;

	List<wrapper> gettasksize() throws Exception;

	List<wrapper> gettaskdetails(int project_id) throws Exception;

	String gettaskgpbaseddetails(projectTasks_vo taskgp) throws Exception;

	String editTask(projectTasks_vo taskdetails) throws Exception;

	List<wrapper> gettaskviewbaseddetails(projectTasks_vo taskgp) throws Exception;

	void getUsername(Principal principal, String userName) throws Exception;

	List<wrapper> getproject_id(int project_id) throws Exception;

	void getupdatetaskdetail(projectTasks_vo ptv) throws Exception;

	String editptaskgroup(feature_vo tasks, int project_id) throws Exception;

	String edittaskdetails(projectTasks_vo taskdetails, MultipartFile file) throws Exception;

	void deletedetails(int feature_id) throws Exception;

	List<wrapper> getpriority_code() throws Exception;

	String loadeditgroup(int feature_id) throws Exception;

	List<wrapper> getteambrddetails(int project_id) throws Exception;

	String getteamviewdetails(projectTasks_vo ptv) throws Exception;

	List<wrapper> getteaminpdetails(int project_id) throws Exception;

	List<wrapper> getteamcmpdetails(int project_id) throws Exception;

	List<wrapper> getteamsignoffdetails(int project_id) throws Exception;

	List<wrapper> getteamfirstddetails(int project_id) throws Exception;

	List<wrapper> getuserrole(String userName) throws Exception;

	List<wrapper> getteamfirstviewdetails(int project_id) throws Exception;

	String gettaskgpviewdetails(int project_id, projectTasks_vo taskgp) throws Exception;

}
