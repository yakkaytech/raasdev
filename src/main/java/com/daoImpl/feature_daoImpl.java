package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dao.feature_dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utility.connectionDB;
import com.vo.feature_vo;
import com.vo.projecttasksgp_vo;
import com.wrapper.wrapper;

@Component
public class feature_daoImpl implements feature_dao {

	private Connection conn;

	public List<wrapper> getfeaturesets(int project_id) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"select feature.description,feature.signoff_criteria,feature.name,feature.feature_id,feature.project_id,count(task.feature_id) tasks_cnt_pergp,feature.priority_code,category_code.cat_name from feature INNER JOIN category_code ON feature.priority_code = category_code.cat_cde Inner join project_user on project_user.project_id =feature.project_id  left outer join task on feature.feature_id=task.feature_id where  feature.project_id = '"
						+ project_id
						+ "' group by feature.name,feature.feature_id,feature.project_id  order by feature.feature_id ");

		while (rs.next()) {

			wrapper obj = new wrapper();
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.setFeature_name(rs.getString("name"));
			obj.settasks_cnt_pergp(rs.getInt("tasks_cnt_pergp"));
			obj.setPriority_code(rs.getString("priority_code"));
			obj.setCategory_name(rs.getString("cat_name"));
			obj.setFeature_description(rs.getString("description"));
			obj.setFeature_signoff_criteria(rs.getString("signoff_criteria"));

			list.add(obj);
		}

		return list;
	}

	public String addfeature(feature_vo ptv, String userName, String token, int project_id) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String json = "";
		int user_id = 0;
		ResultSet user = stmt.executeQuery("select user_id from user where username = '" + userName + "'");
		while (user.next()) {
			user_id = user.getInt("user_id");
		}

		String taskgpquery = "insert into feature(project_id,name,description,signoff_criteria,`key`,priority_code,active_ind,due_date,date_added,date_modified,created_by,updated_by)values('"
				+ ptv.getProject_id() + "','" + ptv.getFeature_name() + "','" + ptv.getFeature_description() + "','"
				+ ptv.getFeature_signoff_criteria() + "','" + token + "','" + ptv.getPriority_code() + "',1,'" + sysdate
				+ "','" + sysdate + "','" + sysdate + "','" + user_id + "','" + user_id + "')";

		stmt.execute(taskgpquery);
		ResultSet rs = stmt.executeQuery(
				"select feature.name,feature.feature_id,feature.project_id,count(task.feature_id) tasks_cnt_pergp,feature.priority_code,category_code.cat_name from feature INNER JOIN category_code ON feature.priority_code = category_code.cat_cde Inner join project_user on project_user.project_id =feature.project_id  left outer join task on feature.feature_id=task.feature_id where  feature.project_id = '"
						+ project_id
						+ "' group by feature.name,feature.feature_id,feature.project_id  order by feature.feature_id ");

		while (rs.next()) {

			wrapper obj = new wrapper();
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.setFeature_name(rs.getString("name"));
			obj.settasks_cnt_pergp(rs.getInt("tasks_cnt_pergp"));
			obj.setPriority_code(rs.getString("priority_code"));
			obj.setCategory_name(rs.getString("cat_name"));

			list.add(obj);
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;
	}

	public String loadeditgroup(int feature_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String json = "";

		ResultSet rs = stmt.executeQuery(
				"select feature.name,feature.description,feature.signoff_criteria,feature.priority_code,category_value.value_name from feature INNER JOIN category_value ON feature.priority_code = category_value.cat_cde where feature.feature_id = '"
						+ feature_id + "'");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setFeature_name(rs.getString("name"));
			obj.setFeature_signoff_criteria(rs.getString("signoff_criteria"));
			obj.setFeature_description(rs.getString("description"));
			obj.setPriority_cde_name(rs.getString("value_name"));
			obj.setPriority_code(rs.getString("priority_code"));

			list.add(obj);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;
	}

	public String managefeature(feature_vo tasks, int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String taskgpquery = "update feature set name= '" + tasks.getFeature_name() + "',description = '"
				+ tasks.getFeature_description() + "', signoff_criteria = '" + tasks.getFeature_signoff_criteria()
				+ "',priority_code = '" + tasks.getPriority_code_name() + "'" + "where feature_id = '"
				+ tasks.getFeature_id() + "'";
		stmt.execute(taskgpquery);

		ResultSet rs = stmt.executeQuery(
				"select feature.name,feature.feature_id,feature.project_id,count(task.feature_id) tasks_cnt_pergp,feature.priority_code,category_code.cat_name from feature INNER JOIN category_code ON feature.priority_code = category_code.cat_cde Inner join project_user on project_user.project_id =feature.project_id  left outer join task on feature.feature_id=task.feature_id where  feature.project_id = '"
						+ project_id
						+ "' group by feature.name,feature.feature_id,feature.project_id  order by feature.feature_id ");

		while (rs.next()) {

			wrapper obj = new wrapper();
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.setFeature_name(rs.getString("name"));
			obj.settasks_cnt_pergp(rs.getInt("tasks_cnt_pergp"));
			obj.setPriority_code(rs.getString("priority_code"));
			obj.setCategory_name(rs.getString("cat_name"));

			list.add(obj);
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;
	}

	public String removefeature(int feature_id, int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		int rs1 = stmt.executeUpdate("Delete  from feature where feature.feature_id ='" + feature_id + "'");
		ResultSet rs = stmt.executeQuery(
				"select feature.name,feature.feature_id,feature.project_id,count(task.feature_id) tasks_cnt_pergp,feature.priority_code,category_code.cat_name from feature INNER JOIN category_code ON feature.priority_code = category_code.cat_cde Inner join project_user on project_user.project_id =feature.project_id  left outer join task on feature.feature_id=task.feature_id where  feature.project_id = '"
						+ project_id
						+ "' group by feature.name,feature.feature_id,feature.project_id  order by feature.feature_id ");

		while (rs.next()) {

			wrapper obj = new wrapper();
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.setFeature_name(rs.getString("name"));
			obj.settasks_cnt_pergp(rs.getInt("tasks_cnt_pergp"));
			obj.setPriority_code(rs.getString("priority_code"));
			obj.setCategory_name(rs.getString("cat_name"));

			list.add(obj);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;
	}

	public List<wrapper> getfeaturepro_sets(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"select feature.description,feature.project_id,feature.signoff_criteria,feature.name,feature.feature_id,feature.project_id,count(proposal_task.feature_id) tasks_cnt_pergp,feature.priority_code,category_code.cat_name from feature INNER JOIN category_code ON feature.priority_code = category_code.cat_cde Inner join project_user on project_user.project_id =feature.project_id  left outer join proposal_task on feature.feature_id=proposal_task.feature_id where  feature.project_id = '"
						+ project_id
						+ "' group by feature.name,feature.feature_id,feature.project_id  order by feature.feature_id ");

		while (rs.next()) {

			wrapper obj = new wrapper();
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.setFeature_name(rs.getString("name"));
			obj.setProject_id(rs.getInt("project_id"));
			obj.settasks_cnt_pergp(rs.getInt("tasks_cnt_pergp"));
			obj.setPriority_code(rs.getString("priority_code"));
			obj.setCategory_name(rs.getString("cat_name"));
			obj.setFeature_description(rs.getString("description"));
			obj.setFeature_signoff_criteria(rs.getString("signoff_criteria"));

			list.add(obj);
		}

		return list;
	}

}
