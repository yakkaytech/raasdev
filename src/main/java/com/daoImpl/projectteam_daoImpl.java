package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dao.projectteam_dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utility.connectionDB;
import com.vo.projectrole_vo;
import com.vo.projecttasks_vo;
import com.wrapper.wrapper;

@Component
public class projectteam_daoImpl implements projectteam_dao {

	private Connection conn;

	public List<wrapper> getteambrddetails(int project_id) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs2 = stmt
				.executeQuery("select status_type_id,sequence_id,status_name from status_type where  status_type_id = 2 ");

		int status_type_id = 0;
		int sequence_id = 0;
		String status_name = null;

		while (rs2.next()) {

			status_type_id = rs2.getInt("status_type_id");
			sequence_id = rs2.getInt("sequence_id");
			status_name = rs2.getString("status_name");
		}

	
		
		ResultSet rs = stmt.executeQuery(
				"select task.project_id,task.signoff_criteria,task.task_type_id,task_type.type_name,task.task_id,task.task_name,task.description,task.size_code,task_status.status_name from task INNER JOIN task_status ON task.task_id = task_status.task_id INNER JOIN task_type ON task.task_type_id = task_type.task_type_id where task.project_id = '"
						+ project_id + "' and task_status.status_name = '" + status_name
						+ "' ORDER BY task.date_added desc");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.settask_id(rs.getInt("task_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setTask_status(rs.getString("status_name"));
			list.add(obj);
		}
		return list;
	}

	public String getteamviewdetails(projecttasks_vo ptv) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"select task.project_id,task.task_id,task.task_name,task.description,task_status.status_name,task.signoff_criteria,task_type.type_name,attach_files.file_name,task.feature_id from task INNER JOIN task_type ON task.task_type_id = task_type.task_type_id INNER JOIN task_status ON task.task_id = task_status.task_id INNER JOIN  attach_files ON task.task_id = attach_files.task_id  where task.task_id = '"
						+ ptv.getTask_id() + "' ");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.settask_id(rs.getInt("task_id"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.setStatus_name(rs.getString("status_name"));
			obj.setFile_name(rs.getString("file_name"));
			list.add(obj);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;
	}

	public void taskreadyactivity(projecttasks_vo ptv) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		ResultSet rs2 = stmt.executeQuery(
				"select status_type_id,sequence_id,status_name,status_code from status_type where  status_type_id = 2 ");

		int status_type_id = 0;
		int sequence_id = 0;
		String status_name = null;
		String status_code = null;

		while (rs2.next()) {

			status_type_id = rs2.getInt("status_type_id");
			sequence_id = rs2.getInt("sequence_id");
			status_code = rs2.getString("status_code");
			status_name = rs2.getString("status_name");
		}
		String readystatus = "update task_status set sequence_id = '" + sequence_id + "',status_name = '" + status_name
				+ "',status_type_id = '" + status_type_id + "',status_code = '" + status_code + "' where task_id = '"
				+ ptv.getTask_id() + "'";
		stmt.execute(readystatus);

	}

	public void taskInprogressactivity(projecttasks_vo ptv) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		ResultSet rs2 = stmt.executeQuery(
				"select status_type_id,sequence_id,status_name,status_code from status_type where  status_type_id = 3 ");

		int status_type_id = 0;
		int sequence_id = 0;
		String status_name = null;
		String status_code = null;

		while (rs2.next()) {

			status_type_id = rs2.getInt("status_type_id");
			sequence_id = rs2.getInt("sequence_id");
			status_code = rs2.getString("status_code");
			status_name = rs2.getString("status_name");
		}
		String readystatus = "update task_status set sequence_id = '" + sequence_id + "',status_name = '" + status_name
				+ "',status_type_id = '" + status_type_id + "',status_code = '" + status_code + "'  where task_id = '"
				+ ptv.getTask_id() + "'";
		stmt.execute(readystatus);

	}

	public void taskcompletedactivity(projecttasks_vo ptv) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		ResultSet rs2 = stmt.executeQuery(
				"select status_type_id,sequence_id,status_name,status_code from status_type where  status_type_id = 4 ");

		int status_type_id = 0;
		int sequence_id = 0;
		String status_name = null;
		String status_code = null;

		while (rs2.next()) {

			status_type_id = rs2.getInt("status_type_id");
			sequence_id = rs2.getInt("sequence_id");
			status_code = rs2.getString("status_code");
			status_name = rs2.getString("status_name");
		}
		String readystatus = "update task_status set sequence_id = '" + sequence_id + "',status_name = '" + status_name
				+ "',status_type_id = '" + status_type_id + "',status_code = '" + status_code + "' where task_id = '"
				+ ptv.getTask_id() + "'";

		stmt.execute(readystatus);

	}

	public void tasksignedoffactivity(projecttasks_vo ptv) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		ResultSet rs2 = stmt.executeQuery(
				"select status_type_id,sequence_id,status_name,status_code from status_type where  status_type_id = 5 ");

		int status_type_id = 0;
		int sequence_id = 0;
		String status_name = null;
		String status_code = null;

		while (rs2.next()) {

			status_type_id = rs2.getInt("status_type_id");
			sequence_id = rs2.getInt("sequence_id");
			status_code = rs2.getString("status_code");
			status_name = rs2.getString("status_name");
		}
		String readystatus = "update task_status set sequence_id = '" + sequence_id + "',status_name = '" + status_name
				+ "',status_type_id = '" + status_type_id + "',status_code = '" + status_code + "' where task_id = '"
				+ ptv.getTask_id() + "'";

		stmt.execute(readystatus);

	}

	public List<wrapper> getteaminpdetails(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs2 = stmt
				.executeQuery("select status_type_id,sequence_id,status_name from status_type where  status_type_id = 3 ");

		int status_type_id = 0;
		int sequence_id = 0;
		String status_name = null;

		while (rs2.next()) {

			status_type_id = rs2.getInt("status_type_id");
			sequence_id = rs2.getInt("sequence_id");
			status_name = rs2.getString("status_name");
		}

		ResultSet rs = stmt.executeQuery(
				"select task.project_id,task.signoff_criteria,task.task_type_id,task_type.type_name,task.task_id,task.task_name,task.description,task.size_code,task_status.status_name from task INNER JOIN task_status ON task.task_id = task_status.task_id INNER JOIN task_type ON task.task_type_id = task_type.task_type_id where task.project_id = '"
						+ project_id + "' and task_status.status_name = '" + status_name + "' ");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.settask_id(rs.getInt("task_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setTask_status(rs.getString("status_name"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> getteamcmpdetails(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs2 = stmt
				.executeQuery("select status_type_id,sequence_id,status_name from status_type where  status_type_id = 4 ");

		int status_type_id = 0;
		int sequence_id = 0;
		String status_name = null;

		while (rs2.next()) {

			status_type_id = rs2.getInt("status_type_id");
			sequence_id = rs2.getInt("sequence_id");
			status_name = rs2.getString("status_name");
		}

		ResultSet rs = stmt.executeQuery(
				"select task.project_id,task.signoff_criteria,task.task_type_id,task_type.type_name,task.task_id,task.task_name,task.description,task.size_code,task_status.status_name from task INNER JOIN task_status ON task.task_id = task_status.task_id INNER JOIN task_type ON task.task_type_id = task_type.task_type_id where task.project_id = '"
						+ project_id + "' and task_status.status_name = '" + status_name + "' ");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.settask_id(rs.getInt("task_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setTask_status(rs.getString("status_name"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> getteamsignoffdetails(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs2 = stmt
				.executeQuery("select status_type_id,sequence_id,status_name from status_type where  status_type_id = 5 ");

		int status_type_id = 0;
		int sequence_id = 0;
		String status_name = null;

		while (rs2.next()) {

			status_type_id = rs2.getInt("status_type_id");
			sequence_id = rs2.getInt("sequence_id");
			status_name = rs2.getString("status_name");
		}

		ResultSet rs = stmt.executeQuery(
				"select task.project_id,task.signoff_criteria,task.task_type_id,task_type.type_name,task.task_id,task.task_name,task.description,task.size_code,task_status.status_name from task INNER JOIN task_status ON task.task_id = task_status.task_id INNER JOIN task_type ON task.task_type_id = task_type.task_type_id where task.project_id = '"
						+ project_id + "' and task_status.status_name = '" + status_name + "' ");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.settask_id(rs.getInt("task_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setTask_status(rs.getString("status_name"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> getteamfirstdetails(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs2 = stmt
				.executeQuery("select status_type_id,sequence_id,status_name from status_type where  status_type_id = 1 ");

		int status_type_id = 0;
		int sequence_id = 0;
		String status_name = null;

		while (rs2.next()) {

			status_type_id = rs2.getInt("status_type_id");
			sequence_id = rs2.getInt("sequence_id");
			status_name = rs2.getString("status_name");
		}

		
		ResultSet rs = stmt.executeQuery(
				"select task.project_id,task.signoff_criteria,task.task_type_id,task_type.type_name,task.task_id,task.task_name,task.description,task.size_code,task_status.status_name,attach_files.file_name from task INNER JOIN task_status ON task.task_id = task_status.task_id INNER JOIN task_type ON task.task_type_id = task_type.task_type_id INNER JOIN attach_files ON task.task_id = attach_files.task_id where task.project_id = '"
						+ project_id + "' and task_status.status_name != '" + status_name
						+ "' ORDER BY task.date_added desc ");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.settask_id(rs.getInt("task_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			// obj.setTask_status(rs.getString("status_name"));
			obj.setStatus_name(rs.getString("status_name"));
			obj.setFile_name(rs.getString("file_name"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> getAllJobs(projectrole_vo prv) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery(
				"select project.projectname,project.project_id,project.description,project_skill.skill_id,project_skill.skill_other_name,skill.name  from project INNER JOIN project_skill ON project.project_id = project_skill.project_id INNER JOIN skill ON skill.skill_id = project_skill.skill_id  ");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.setProject_name(rs.getString("projectname"));
			obj.setProject_desc(rs.getString("description"));
			obj.setPrimary_skill(rs.getString("name"));
			obj.setSecondary_skill(rs.getString("skill_other_name"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> getprojectdetails(projectrole_vo prv, int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		String json = "";

		list.clear();
		ResultSet rs = stmt.executeQuery(
				"select project.project_id,project.projectname,project.description ,project_skill.skill_id,project_skill.skill_other_name,skill.name,feature.name,feature.description as task_desc,feature.signoff_criteria,feature.priority_code,category_code.cat_name from project INNER JOIN feature ON project.project_id = feature.project_id INNER JOIN project_skill ON project.project_id = project_skill.project_id INNER JOIN skill ON skill.skill_id = project_skill.skill_id INNER JOIN category_code ON feature.priority_code = category_code.cat_cde where project.project_id = '"
						+ project_id + "' ");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.setProject_name(rs.getString("projectname"));
			obj.setProject_desc(rs.getString("description"));
			obj.setPrimary_skill(rs.getString("name"));
			obj.setSecondary_skill(rs.getString("skill_other_name"));
			obj.setFeature_name(rs.getString("name"));
			obj.settask_description(rs.getString("task_desc"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.setCategory_name(rs.getString("cat_name"));

			list.add(obj);
		}

		return list;
	}

	public String getJobById() {
		return null;
	}

	public String removeMember() {
		return null;
	}

	public String addMember() {
		return null;
	}

	public String getTeamMembers() {
		return null;
	}

	public String getActiveTeamMembers() {
		return null;
	}

	public List<wrapper> getavailableroles(projectrole_vo prv, int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		String json = "";
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"select project_role.role_id,role.name,project_role.additional_desc,project_role.rate,project_role.frequency_code,category_value.cat_cde,category_code.cat_name from project  INNER JOIN project_role ON project.project_id = project_role.project_id INNER JOIN role ON role.role_id = project_role.role_id INNER JOIN category_value ON category_value.value_cde = project_role.frequency_code INNER JOIN category_code ON category_value.cat_cde = category_code.cat_cde  where   project_role.publish_ind = 1 AND project_role.project_id = '"
						+ project_id + "'");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setRole_name(rs.getString("name"));
			obj.setDes(rs.getString("additional_desc"));
			obj.setRate(rs.getInt("rate"));
			obj.setFrequency(rs.getString("frequency_code"));
			obj.setCategory_code(rs.getString("cat_name"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> getteamfirstviewdetails(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs2 = stmt
				.executeQuery("select status_type_id,sequence_id,status_name from status_type where  status_type_id = 1 ");

		int status_type_id = 0;
		int sequence_id = 0;
		String status_name = null;

		while (rs2.next()) {

			status_type_id = rs2.getInt("status_type_id");
			sequence_id = rs2.getInt("sequence_id");
			status_name = rs2.getString("status_name");
		}
		ResultSet rs = stmt.executeQuery(
				"select task.project_id,task.feature_id,task.signoff_criteria,task.task_type_id,task_type.type_name,task.task_id,task.task_name,task.description,task.size_code,task_status.status_name,attach_files.file_name from task INNER JOIN task_status ON task.task_id = task_status.task_id INNER JOIN task_type ON task.task_type_id = task_type.task_type_id INNER JOIN attach_files ON task.task_id = attach_files.task_id where task.project_id = '"
						+ project_id + "'  ORDER BY task.date_added desc ");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.settask_id(rs.getInt("task_id"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			// obj.setTask_status(rs.getString("status_name"));
			obj.setStatus_name(rs.getString("status_name"));
			obj.setFile_name(rs.getString("file_name"));
			list.add(obj);
		}
		return list;
	}

	public String gettaskgpviewdetails(int project_id, projecttasks_vo taskgp) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String json = " ";
		ResultSet rs2 = stmt
				.executeQuery("select status_type_id,sequence_id,status_name from status_type where  status_type_id = 1 ");

		int status_type_id = 0;
		int sequence_id = 0;
		String status_name = null;

		while (rs2.next()) {

			status_type_id = rs2.getInt("status_type_id");
			sequence_id = rs2.getInt("sequence_id");
			status_name = rs2.getString("status_name");
		}
		ResultSet rs = stmt.executeQuery(
				"select task.project_id,task.feature_id,task.signoff_criteria,task.task_type_id,task_type.type_name,task.task_id,task.task_name,task.description,task.size_code,task_status.status_name,attach_files.file_name from task INNER JOIN task_status ON task.task_id = task_status.task_id INNER JOIN task_type ON task.task_type_id = task_type.task_type_id INNER JOIN attach_files ON task.task_id = attach_files.task_id where task.project_id = '"
						+ project_id + "' AND task.feature_id= '" + taskgp.getFeature_id()
						+ "' ORDER BY task.date_added desc ");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.settask_id(rs.getInt("task_id"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			// obj.setTask_status(rs.getString("status_name"));
			obj.setStatus_name(rs.getString("status_name"));
			obj.setFile_name(rs.getString("file_name"));
			list.add(obj);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);

		return json;
	}

	public List<wrapper> getuserid(String username) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		String json = "";
		list.clear();
		ResultSet rs = stmt.executeQuery(
				"select user.user_id,project_user.project_id from user INNER JOIN project_user ON project_user.user_id=user.user_id where user.username = '"
						+ username + "' ");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setUser_id(rs.getInt("user_id"));
			obj.setProject_id(rs.getInt("project_id"));
			list.add(obj);
		}
		return list;
	}

}
