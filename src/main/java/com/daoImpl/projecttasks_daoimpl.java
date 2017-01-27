package com.daoImpl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.dao.projecttasks_dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utility.connectionDB;
import com.vo.crtproject_vo;
import com.vo.feature_vo;
import com.vo.projecttasks_vo;
import com.vo.projecttasksgp_vo;
import com.wrapper.wrapper;

@Component
public class projecttasks_daoimpl implements projecttasks_dao {

	private Connection conn;

	public void saveptaskgroup(feature_vo taskgp, int project_id, String username) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);

		int user_id = 0;
		ResultSet user = stmt.executeQuery("select user_id from user where username = '" + username + "'");
		while (user.next()) {
			user_id = user.getInt("user_id");
		}

		if (taskgp.getFeature_id() != 0) {
			String taskgpquery1 = null;
			ResultSet rs = stmt.executeQuery("select task_group_name from feature where name='"
					+ taskgp.getFeature_name() + "'and project_id = '" + project_id + "'");
			while (rs.next()) {
				taskgpquery1 = rs.getString("task_group_name");
			}
			if (taskgpquery1 == null) {

				String taskgpquery = "update feature set name= '" + taskgp.getFeature_name() + "'"
						+ "where feature_id = '" + taskgp.getFeature_id() + "'";

				stmt.execute(taskgpquery);
			}

		} else {
			String taskgpquery1 = null;
			ResultSet rs = stmt.executeQuery("select name from feature where name='" + taskgp.getFeature_name() + "' ");
			while (rs.next()) {
				taskgpquery1 = rs.getString("task_group_name");
			}
			if (taskgpquery1 == null) {
				String taskgpquery = "insert into feature_set(project_id,task_group_name,description,priority_code,signoff_criteria,date_added,date_modified,created_by,updated_by)values('"
						+ project_id + "','" + taskgp.getFeature_name() + "','" + taskgp.getFeature_description()
						+ "','" + taskgp.getPriority_code() + "','" + taskgp.getFeature_signoff_criteria() + "','"
						+ sysdate + "','" + sysdate + "','" + user_id + "','" + user_id + "')";

				stmt.execute(taskgpquery);
			} else {
				String taskgpquery = "update feature_set set name= '" + taskgp.getFeature_name() + "',project_id = '"
						+ project_id + "'" + "where name = '" + taskgp.getFeature_name() + "'";

				stmt.execute(taskgpquery);
			}
		}

	}

	public List<wrapper> gettaskgroup(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String mainquery = "select feature.name,feature.feature_id,feature.project_id,count(task.feature_id) tasks_cnt_pergp from feature Inner join project_user on project_user.project_id =feature.project_id left outer join task on feature.feature_id=task.feature_id where  feature.project_id = '"
				+ project_id
				+ "' group by feature.name,feature.feature_id,feature.project_id  order by feature.feature_id";
		ResultSet rs = stmt.executeQuery(mainquery);
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setFeature_name(rs.getString("name"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.settasks_cnt_pergp(rs.getInt("tasks_cnt_pergp"));
			obj.setProject_id(rs.getInt("project_id"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> gettasktype() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery("select task_type_id,type_name from task_type where active_ind=1");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_type_name(rs.getString("type_name"));
			obj.setTask_type_id(rs.getInt("task_type_id"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> gettasksize() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery("select size_code,hours from size where active_ind=1 order by sort_order asc");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_size_code(rs.getString("size_code"));
			obj.settask_size_hrs(rs.getInt("hours"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> gettaskdetails(int project_id) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"select pu.user_id,ur.USER_ROLE,task.task_id,task.project_id,task.task_type_id,task_type.type_name,task.feature_id,task.task_name,task.description,task.date_begin,task.date_end,task.signoff_criteria,attach_files.file_name,task.size_code,ts.status_code,'Me' as AssignedTo from task inner join project_user pu on pu.project_id= task.project_id left outer join user_roles ur on pu.user_id=ur.user_id left outer join task_type on task.task_type_id = task_type.task_type_id  left outer join attach_files on task.task_id = attach_files.task_id left outer join task_status ts on task.task_id = ts.task_id  where task_type.active_ind = 1 and task.project_id='"
						+ project_id + "' GROUP BY task.task_id DESC");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_id(rs.getInt("task_id"));
			obj.setTask_type_id(rs.getInt("task_type_id"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setTask_status(rs.getString("status_code"));
			obj.setDate_begin(rs.getDate("Date_begin"));
			obj.setDate_end(rs.getDate("Date_end"));
			obj.setTask_AssignedTo(rs.getString("AssignedTo"));
			obj.setFile_name(rs.getString("file_name"));
			obj.setProject_id(rs.getInt("project_id"));
			obj.setUser_role(rs.getString("USER_ROLE"));
			// obj.setFile_name(rs.getBytes("file_name"));

			list.add(obj);
		}
		return list;
	}

	public List<wrapper> gettaskgpbaseddetails(projecttasks_vo taskgp) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json;
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		String Query = "select distinct pu.user_id,ur.USER_ROLE,task.task_id,task.task_type_id,task.project_id,task_type.type_name,task.feature_id,task.task_name,task.description,task.date_begin,task.date_end,attach_files.file_name,task.signoff_criteria,task.size_code,ts.status_code,'Me' as AssignedTo from task inner join project_user pu on pu.project_id= task.project_id left outer join task_type on task.task_type_id = task_type.task_type_id left outer join user_roles ur on pu.user_id=ur.user_id left outer join attach_files on task.task_id = attach_files.task_id left outer join task_status ts on task.task_id = ts.task_id where task_type.active_ind = 1 and task.feature_id='"
				+ taskgp.getFeature_id() + "' order by task.task_id desc ";

		ResultSet rs = stmt.executeQuery(
				"select distinct pu.user_id,ur.USER_ROLE,task.task_id,task.task_type_id,task.project_id,task_type.type_name,task.feature_id,task.task_name,task.description,task.date_begin,task.date_end,attach_files.file_name,task.signoff_criteria,task.size_code,ts.status_code,'Me' as AssignedTo from task inner join project_user pu on pu.project_id= task.project_id left outer join task_type on task.task_type_id = task_type.task_type_id left outer join user_roles ur on pu.user_id=ur.user_id left outer join attach_files on task.task_id = attach_files.task_id left outer join task_status ts on task.task_id = ts.task_id where task_type.active_ind = 1 and task.feature_id='"
						+ taskgp.getFeature_id() + "' order by task.task_id desc ");

		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_id(rs.getInt("task_id"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.setTask_type_id(rs.getInt("task_type_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setTask_status(rs.getString("status_code"));
			obj.setTask_AssignedTo(rs.getString("AssignedTo"));
			obj.setDate_begin(rs.getDate("Date_begin"));
			obj.setDate_end(rs.getDate("Date_end"));
			obj.setFile_name(rs.getString("file_name"));
			obj.setProject_id(rs.getInt("project_id"));
			obj.setUser_role(rs.getString("USER_ROLE"));
			list.add(obj);

		}

		return list;
	}

	public String editTask(projecttasks_vo edtsk) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery(
				"select task_id,task_type.type_name,feature_id,task_name,description,signoff_criteria,size_code,'In Progress' as status,'Me' as AssignedTo from task  where task_id = '"
						+ edtsk + "'");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setTask_id(rs.getInt("task_id"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.setTask_name(rs.getString("task_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setTask_status(rs.getString("status"));
			obj.setTask_AssignedTo(rs.getString("AssignedTo"));
			list.add(obj);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);

		return json;
	}

	public void taskCreatedActivity(projecttasks_vo taskdetails, MultipartFile file, int project_id, String username)
			throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		wrapper list = new wrapper();
		List<wrapper> list1 = new ArrayList<wrapper>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);

		if (taskdetails.getTask_id() == null) {

			String taskgpquery = "insert into task(project_id,feature_id,task_name,description,signoff_criteria,size_code,token,date_added,date_begin,date_end,estimated_hours,role_id,task_type_id)values("
					+ project_id + "," + taskdetails.getFeature_id() + ",'" + taskdetails.getTask_name() + "','"
					+ taskdetails.getDescription() + "','" + taskdetails.getSignoff_criteria() + "','"
					+ taskdetails.gettask_size_code() + "',1,'" + sysdate + "','" + sysdate + "','" + sysdate
					+ "',4,1,'" + taskdetails.gettask_type_id() + "')";

			stmt.execute(taskgpquery);
			String taskattachquery = "insert into attach_files(file_name,file_path,file_size)values('"
					+ file.getOriginalFilename() + "','D:/Attachmentssave/'," + file.getSize() + ")";
			stmt.execute(taskattachquery);

			String taskquery = " SELECT DISTINCT task.task_id from task  where project_id = project_id and feature_id = "
					+ taskdetails.getFeature_id() + " and task_name = '" + taskdetails.getTask_name()
					+ "' and description = '" + taskdetails.getDescription() + "' and signoff_criteria = '"
					+ taskdetails.getSignoff_criteria() + "' and size_code = '" + taskdetails.gettask_size_code() + "'";

			ResultSet rs = stmt.executeQuery(taskquery);
			int task_id = 0;
			while (rs.next()) {
				task_id = rs.getInt("task_id");
			}

			ResultSet rs1 = stmt
					.executeQuery("select attach_files.doc_id from attach_files where  attach_files.file_name = '"
							+ file.getOriginalFilename() + "'");
			int doc_id = 0;
			while (rs1.next()) {
				wrapper obj = new wrapper();
				obj.setDoc_id(rs1.getInt("doc_id"));
				doc_id = rs1.getInt("doc_id");
			}
			String taskattach = "update attach_files set attach_files.task_id = " + task_id
					+ " where attach_files.file_name = '" + file.getOriginalFilename() + "'and  attach_files.doc_id = "
					+ doc_id + " ";
			stmt.execute(taskattach);

			int user_id = 0;
			ResultSet user = stmt.executeQuery("select user_id from user where  username = '" + username + "'");
			while (user.next()) {
				user_id = user.getInt("user_id");

			}

			String Query = "select status_type_id,sequence_id,status_name,status_code from status_type where  sequence_id = 1";
			ResultSet rs2 = stmt.executeQuery(
					"select status_type_id,sequence_id,status_name,status_code from status_type where  sequence_id = 1 ");

			int status_type_id = 0;
			int sequence_id = 0;
			String status_name = null;
			String status_code = null;

			while (rs2.next()) {

				status_type_id = rs2.getInt("status_type_id");
				sequence_id = rs2.getInt("sequence_id");
				status_name = rs2.getString("status_name");
				status_code = rs2.getString("status_code");
			}

			String taskstatus = "insert into task_status(sequence_id,status_name,status_type_id,task_id,date_added,created_by,date_updated,updated_by,status_code)values('"
					+ sequence_id + "','" + status_name + "','" + status_type_id + "','" + task_id + "','" + sysdate
					+ "','" + user_id + "','" + sysdate + "','" + user_id + "','" + status_code + "')";

			stmt.execute(taskstatus);

		} else {

			String taskgpuquery = "update task set task_name = '" + taskdetails.getTask_name() + "',description='"
					+ taskdetails.getDescription() + "',task_type_id='" + taskdetails.gettask_type_id()
					+ "',signoff_criteria=" + "'" + taskdetails.getSignoff_criteria() + "',size_code='"
					+ taskdetails.gettask_size_code() + "'" + " where task_id = '" + taskdetails.getTask_id() + "'";

			stmt.execute(taskgpuquery);

		}
	}

	public List<wrapper> gettaskviewbaseddetails(projecttasks_vo taskgp) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"select task.task_id,task.task_type_id,task_type.type_name,task.feature_id,task.task_name,task.description,task.date_begin,task.date_end,task.signoff_criteria,attach_files.file_name,task.size_code,'In Progress' as status,'Me' as AssignedTo from task inner join task_type on task.task_type_id = task_type.task_type_id inner join attach_files on task.task_id = attach_files.task_id where task_type.active_ind = 1 and task.task_id='"
						+ taskgp.getTask_id() + "'");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_id(rs.getInt("task_id"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_name(rs.getString("type_name"));
			obj.setTask_type_id(rs.getInt("task_type_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setTask_status(rs.getString("status"));
			obj.setDate_begin(rs.getDate("Date_begin"));
			obj.setDate_end(rs.getDate("Date_end"));
			obj.setTask_AssignedTo(rs.getString("AssignedTo"));
			obj.setFile_name(rs.getString("file_name"));
			list.add(obj);

		}
		return list;
	}

	public void getUsername(Principal principal, String userName) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		int user_id = 0;
		String firstname = "";
		String lastname = "";
		ResultSet user = stmt.executeQuery("select * from user where username='" + userName + "'");
		while (user.next()) {
			user_id = user.getInt("user_id");
			firstname = user.getString("firstname");
			lastname = user.getString("lastname");
		}

	}

	public List<wrapper> getproject_id(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt
				.executeQuery("select * from project_user where project_user.project_id='" + project_id + "'");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));

			obj.setUser_id(rs.getInt("user_id"));

			list.add(obj);
		}

		return list;
	}

	public void getupdatetaskdetail(projecttasks_vo ptv) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String taskgpuquery = "update task set task_name = '" + ptv.getTask_name() + "',description='"
				+ ptv.getDescription() + "',task_type_id='" + ptv.gettask_type_id() + "',signoff_criteria=" + "'"
				+ ptv.getSignoff_criteria() + "',size_code='" + ptv.gettask_size_code() + "'" + " where task_id = '"
				+ ptv.getTask_id() + "'";

		stmt.execute(taskgpuquery);

	}

	public String editptaskgroup(feature_vo tasks, int project_id) throws Exception {

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

		String mainquery = "select DISTINCT feature.name,feature.feature_id,feature.project_id,count(task.feature_id) tasks_cnt_pergp from feature_set Inner join project_user on project_user.project_id =feature.project_id left outer join task on feature.feature_id=task.feature_id where  feature.project_id = '"
				+ project_id + "' group by feature.name,feature.feature_id,feature.project_id ";
		ResultSet rs = stmt.executeQuery(mainquery);

		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setFeature_name(rs.getString("name"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.settasks_cnt_pergp(rs.getInt("tasks_cnt_pergp"));
			obj.setProject_id(rs.getInt("project_id"));
			list.add(obj);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);

		return json;
	}

	public String edittaskdetails(projecttasks_vo taskdetails, MultipartFile file) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = " ";

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String taskgpuquery = "update task set task_name = '" + taskdetails.getTask_name() + "',description='"
				+ taskdetails.getDescription() + "',task_type_id='" + taskdetails.gettask_type_id()
				+ "',signoff_criteria='" + taskdetails.getSignoff_criteria() + "'" + " where task_id = '"
				+ taskdetails.getTask_id() + "'";
      
		
		stmt.execute(taskgpuquery);

		String filename = file.getOriginalFilename();
		String attachupdate = "update attach_files set file_name = '" + file.getOriginalFilename()
				+ "' where task_id = '" + taskdetails.getTask_id() + "'";
		stmt.execute(attachupdate);
		ResultSet rs = stmt.executeQuery("Select * from task where task_id = '" + taskdetails.getTask_id() + "'");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_id(rs.getInt("task_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.setTask_type_id(rs.getInt("task_type_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setDate_begin(rs.getDate("Date_begin"));
			obj.setDate_end(rs.getDate("Date_end"));

			list.add(obj);

		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;

	}

	public void deletedetails(int feature_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		int rs1 = stmt.executeUpdate("Delete  from feature where feature.feature_id ='" + feature_id + "'");
	}

	public List<wrapper> getpriority_code() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery(
				"select category_value.value_name,category_value.cat_cde,category_code.cat_cde from category_value INNER JOIN category_code ON category_value.cat_cde= category_code.cat_cde where category_value.value_active_ind = 2");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setPriority_code(rs.getString("cat_cde"));
			obj.setPriority_cde_name(rs.getString("value_name"));

			list.add(obj);
		}
		return list;
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

	public List<wrapper> getuserrole(String userName) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery("select USER_ROLE from user_roles where USERNAME='" + userName + "'");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setUser_role(rs.getString("USER_ROLE"));
			list.add(obj);
		}
		return list;
	}

}
