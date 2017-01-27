package com.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vo.proposaltasks_vo;
import com.vo.crtproject_vo;
import com.vo.feature_vo;
import com.vo.projecttasks_vo;
import com.vo.projecttasksgp_vo;
import com.wrapper.wrapper;

public interface projecttasks_service {

	void saveptaskgroup(feature_vo tasks, int project_id, String username) throws Exception;

	List<wrapper> gettasktype() throws Exception;

	List<wrapper> gettasksize() throws Exception;

	List<wrapper> gettaskdetails(int project_id) throws Exception;

	String gettaskgpbaseddetails(projecttasks_vo taskgp) throws Exception;

	String editTask(projecttasks_vo taskdetails) throws Exception;

	List<wrapper> gettaskviewbaseddetails(projecttasks_vo taskgp) throws Exception;

	void getUsername(Principal principal, String userName) throws Exception;

	List<wrapper> getproject_id(int project_id) throws Exception;

	void getupdatetaskdetail(projecttasks_vo ptv) throws Exception;

	String editptaskgroup(feature_vo tasks, int project_id) throws Exception;

	String edittaskdetails(projecttasks_vo taskdetails, MultipartFile file) throws Exception;

	void deletedetails(int feature_id) throws Exception;

	List<wrapper> getpriority_code() throws Exception;

	String loadeditgroup(int feature_id) throws Exception;

	List<wrapper> getteambrddetails(int project_id) throws Exception;

	String getteamviewdetails(projecttasks_vo ptv) throws Exception;

	List<wrapper> getteaminpdetails(int project_id) throws Exception;

	List<wrapper> getteamcmpdetails(int project_id) throws Exception;

	List<wrapper> getteamsignoffdetails(int project_id) throws Exception;

	List<wrapper> getteamfirstddetails(int project_id) throws Exception;

	List<wrapper> getuserrole(String userName) throws Exception;

	List<wrapper> getteamfirstviewdetails(int project_id) throws Exception;

	String gettaskgpviewdetails(int project_id, projecttasks_vo taskgp) throws Exception;

}
