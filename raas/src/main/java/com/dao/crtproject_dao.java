package com.dao;

import java.util.List;

import com.vo.crtproject_vo;
import com.vo.projectRole_vo;
import com.wrapper.wrapper;

public interface crtproject_dao {

	public void proregister(crtproject_vo crt,String userName)throws Exception;
	public List<wrapper> projecttype() throws Exception;
	public List<wrapper> prodetail(crtproject_vo crt, String userName, int project_id) throws Exception;
	public void getprojectupdate(crtproject_vo crt) throws Exception;
	public List<wrapper> getuserproupdate(crtproject_vo crt, String username) throws Exception;
	public int  getuserprojectid(crtproject_vo crt, String username) throws Exception;
	public List<wrapper> jobtype() throws Exception;
	public void save_addmembers(projectRole_vo role, int project_id) throws Exception;
	public List<wrapper> frequency_code() throws Exception;
	public List<wrapper> getjobdetails(projectRole_vo role, int project_id) throws Exception;
	public void edit_addmembers(projectRole_vo role) throws Exception;
	public List<wrapper> geteditdetails(projectRole_vo role, int project_role_id) throws Exception;
	public void save_and_publish(projectRole_vo role, int project_id) throws Exception;
	public List<wrapper> skill() throws Exception;
	public List<wrapper> timeline() throws Exception;
	public void prjtrole_edit_publishmember(projectRole_vo role) throws Exception;
	public List<wrapper> pro_name(int project_id) throws Exception;
	
}
