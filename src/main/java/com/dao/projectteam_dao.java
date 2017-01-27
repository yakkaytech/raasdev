package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.vo.projectrole_vo;
import com.vo.projecttasks_vo;
import com.wrapper.wrapper;

public interface projectteam_dao {
	
	public List<wrapper> getteambrddetails(int project_id) throws Exception;

	public String getteamviewdetails(projecttasks_vo ptv) throws Exception;

	public void taskreadyactivity(projecttasks_vo ptv) throws Exception;

	public void taskInprogressactivity(projecttasks_vo ptv) throws Exception;

	public void taskcompletedactivity(projecttasks_vo ptv) throws Exception;

	public void tasksignedoffactivity(projecttasks_vo ptv) throws Exception;

	public List<wrapper> getteaminpdetails(int project_id) throws Exception;

	public List<wrapper> getteamcmpdetails(int project_id) throws Exception;

	public List<wrapper> getteamsignoffdetails(int project_id) throws Exception;

	public List<wrapper> getteamfirstdetails(int project_id) throws Exception;

	public List<wrapper> getAllJobs(projectrole_vo prv) throws Exception;

	public String getJobById();

	public String removeMember();

	public String addMember();

	

	public String getTeamMembers();

	public String getActiveTeamMembers();

	public List<wrapper> getprojectdetails(projectrole_vo prv, int project_id) throws Exception;

	public List<wrapper> getavailableroles(projectrole_vo prv,int project_id) throws SQLException, Exception;

	public List<wrapper> getteamfirstviewdetails(int project_id) throws Exception;

	public String gettaskgpviewdetails(int project_id, projecttasks_vo taskgp) throws Exception;

	public List<wrapper> getuserid(String username) throws Exception;


}
