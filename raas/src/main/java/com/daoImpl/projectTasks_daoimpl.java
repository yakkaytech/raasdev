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
import com.dao.projectTasks_dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utility.connectionDB;
import com.vo.crtproject_vo;
import com.vo.projectTasks_vo;
import com.vo.projectTasksgp_vo;
import com.wrapper.wrapper;

@Component
public class projectTasks_daoimpl implements projectTasks_dao {

	private Connection conn;

	public void saveptaskgroup(projectTasksgp_vo taskgp, int project_id) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		if (taskgp.gettask_group_id() != 0) {
			String taskgpquery1 = null;
			ResultSet rs = stmt.executeQuery("select task_group_name from task_group where task_group_name='"
					+ taskgp.gettask_group_name() + "'and project_id = '" + project_id + "'");
			while (rs.next()) {
				taskgpquery1 = rs.getString("task_group_name");
			}
			if (taskgpquery1 == null) {

				String taskgpquery = "update task_group set task_group_name= '" + taskgp.gettask_group_name() + "'"
						+ "where task_group_id = '" + taskgp.gettask_group_id() + "'";

				stmt.execute(taskgpquery);

			}

		} else {
			String taskgpquery1 = null;
			ResultSet rs = stmt.executeQuery("select task_group_name from task_group where task_group_name='"
					+ taskgp.gettask_group_name() + "'");
			while (rs.next()) {
				taskgpquery1 = rs.getString("task_group_name");
			}
			if (taskgpquery1 == null) {
				String taskgpquery = "insert into task_group(task_group_name,date_added,date_modified,methodology_id,project_id)values('"
						+ taskgp.gettask_group_name() + "','" + sysdate + "','" + sysdate + "',1,'" + project_id + "')";

				stmt.execute(taskgpquery);
			} else {
				String taskgpquery = "update task_group set task_group_name= '" + taskgp.gettask_group_name()
						+ "',project_id = '" + project_id + "'" + "where task_group_name = '"
						+ taskgp.gettask_group_name() + "'";

				stmt.execute(taskgpquery);
			}
		}

	}

	public List<wrapper> gettaskgroup(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String mainquery = "select task_group.task_group_name,task_group.task_group_id,task_group.project_id,count(task.task_group_id) tasks_cnt_pergp from task_group Inner join project_user on project_user.project_id =task_group.project_id left outer join task on task_group.task_group_id=task.task_group_id where  task_group.project_id = '"
				+ project_id + "' group by task_group.task_group_name,task_group.task_group_id,task_group.project_id";
		ResultSet rs = stmt.executeQuery(mainquery);
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_group_name(rs.getString("task_group_name"));
			obj.settask_group_id(rs.getInt("task_group_id"));
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
				"select task.task_id,task.project_id,task.task_type_id,task_type.type_name,task.task_group_id,task.task_name,task.description,task.date_begin,task.date_end,task.signoff_criteria,attach_files.file_name,task.size_code,'In Progress' as status,'Me' as AssignedTo from task inner join project_user on project_user.project_id= task.project_id left outer join task_type on task.task_type_id = task_type.task_type_id  left outer join attach_files on task.task_id = attach_files.task_id where task_type.active_ind = 1 and task.project_id='"
						+ project_id + "' GROUP BY task.task_id ");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_id(rs.getInt("task_id"));
			obj.setTask_type_id(rs.getInt("task_type_id"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_group_id(rs.getInt("task_group_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setTask_status(rs.getString("status"));
			obj.setDate_begin(rs.getDate("Date_begin"));
			obj.setDate_end(rs.getDate("Date_end"));
			obj.setTask_AssignedTo(rs.getString("AssignedTo"));
			obj.setFile_name(rs.getString("file_name"));
			obj.setProject_id(rs.getInt("project_id"));
			// obj.setFile_name(rs.getBytes("file_name"));

			list.add(obj);
		}
		return list;
	}

	public String gettaskgpbaseddetails(projectTasks_vo taskgp) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery(
				"select task.task_id,task.task_type_id,task.project_id,task_type.type_name,task.task_group_id,task.task_name,task.description,task.date_begin,task.date_end,attach_files.file_name,task.signoff_criteria,task.size_code,'In Progress' as status,'Me' as AssignedTo from task left outer join task_type on task.task_type_id = task_type.task_type_id left outer join attach_files on task.task_id = attach_files.task_id where task_type.active_ind = 1 and task.task_group_id='"
						+ taskgp.gettask_group_id() + "order by task.task_id asc'");

		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_id(rs.getInt("task_id"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.setTask_type_id(rs.getInt("task_type_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_group_id(rs.getInt("task_group_id"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setTask_status(rs.getString("status"));
			obj.setTask_AssignedTo(rs.getString("AssignedTo"));
			obj.setDate_begin(rs.getDate("Date_begin"));
			obj.setDate_end(rs.getDate("Date_end"));
			obj.setFile_name(rs.getString("file_name"));
			obj.setProject_id(rs.getInt("project_id"));

			list.add(obj);

		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;
	}

	public String editTask(projectTasks_vo edtsk) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery(
				"select task_id,task_type.type_name,task_group_id,task_name,description,signoff_criteria,size_code,'In Progress' as status,'Me' as AssignedTo from task  where task_id = '"
						+ edtsk + "'");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setTask_id(rs.getInt("task_id"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_group_id(rs.getInt("task_group_id"));
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

	public void saveptaskdetails(projectTasks_vo taskdetails, MultipartFile file, int project_id) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		wrapper list = new wrapper();
		List<wrapper> list1 = new ArrayList<wrapper>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);

		if (taskdetails.getTask_id() == null) {

			String taskgpquery = "insert into task(project_id,task_group_id,task_name,description,signoff_criteria,size_code,token,date_added,date_begin,date_end,estimated_hours,role_id,task_type_id)values("
					+ project_id + "," + taskdetails.gettask_group_id() + ",'" + taskdetails.getTask_name() + "','"
					+ taskdetails.getDescription() + "','" + taskdetails.getSignoff_criteria() + "','"
					+ taskdetails.gettask_size_code() + "',1,'" + sysdate + "','" + sysdate + "','" + sysdate
					+ "',4,1,'" + taskdetails.gettask_type_id() + "')";
			stmt.execute(taskgpquery);
			String taskattachquery = "insert into attach_files(file_name,file_path,file_size)values('"
					+ file.getOriginalFilename() + "','D:/Attachmentssave/'," + file.getSize() + ")";
			stmt.execute(taskattachquery);

			String taskquery = " SELECT DISTINCT task.task_id from task  where project_id = project_id and task_group_id = "
					+ taskdetails.gettask_group_id() + " and task_name = '" + taskdetails.getTask_name()
					+ "' and description = '" + taskdetails.getDescription() + "' and signoff_criteria = '"
					+ taskdetails.getSignoff_criteria() + "' and size_code = '" + taskdetails.gettask_size_code() + "'";

			ResultSet rs = stmt.executeQuery(taskquery);
			int test = 0;
			while (rs.next()) {
				test = rs.getInt("task_id");
			}

			ResultSet rs1 = stmt
					.executeQuery("select attach_files.doc_id from attach_files where  attach_files.file_name = '"
							+ file.getOriginalFilename() + "'");

			String task = "select attach_files.doc_id from attach_files where  attach_files.file_name = '"
					+ file.getOriginalFilename() + "'";

			int doc_id = 0;
			while (rs1.next()) {
				wrapper obj = new wrapper();
				obj.setDoc_id(rs1.getInt("doc_id"));
				doc_id = rs1.getInt("doc_id");
			}
			String taskattach = "update attach_files set attach_files.task_id = " + test
					+ " where attach_files.file_name = '" + file.getOriginalFilename() + "'and  attach_files.doc_id = "
					+ doc_id + " ";
			stmt.execute(taskattach);

		} else {

			String taskgpuquery = "update task set task_name = '" + taskdetails.getTask_name() + "',description='"
					+ taskdetails.getDescription() + "',task_type_id='" + taskdetails.gettask_type_id()
					+ "',signoff_criteria=" + "'" + taskdetails.getSignoff_criteria() + "',size_code='"
					+ taskdetails.gettask_size_code() + "'" + " where task_id = '" + taskdetails.getTask_id() + "'";

			stmt.execute(taskgpuquery);

		}
	}

	public List<wrapper> gettaskviewbaseddetails(projectTasks_vo taskgp) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"select task.task_id,task.task_type_id,task_type.type_name,task.task_group_id,task.task_name,task.description,task.date_begin,task.date_end,task.signoff_criteria,attach_files.file_name,task.size_code,'In Progress' as status,'Me' as AssignedTo from task inner join task_type on task.task_type_id = task_type.task_type_id inner join attach_files on task.task_id = attach_files.task_id where task_type.active_ind = 1 and task.task_id='"
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
				.executeQuery("select * from project_user where project_user.project_id='" + project_id+ "'");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id( rs.getInt("project_id"));
			
		    obj.setUser_id(rs.getInt("user_id"));
		   
			list.add(obj);
		}
		
		return list;
	}

	public void getupdatetaskdetail(projectTasks_vo ptv) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String taskgpuquery = "update task set task_name = '" + ptv.getTask_name() + "',description='"
				+ ptv.getDescription() + "',task_type_id='" + ptv.gettask_type_id() + "',signoff_criteria=" + "'"
				+ ptv.getSignoff_criteria() + "',size_code='" + ptv.gettask_size_code() + "'" + " where task_id = '"
				+ ptv.getTask_id() + "'";

		stmt.execute(taskgpuquery);

	}

	public String editptaskgroup(projectTasksgp_vo tasks, int project_id) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String taskgpquery = "update task_group set task_group_name= '" + tasks.gettask_group_name() + "'"
				+ "where task_group_id = '" + tasks.gettask_group_id() + "'";

		stmt.execute(taskgpquery);

		String mainquery = "select DISTINCT task_group.task_group_name,task_group.task_group_id,task_group.project_id,count(task.task_group_id) tasks_cnt_pergp from task_group Inner join project_user on project_user.project_id =task_group.project_id left outer join task on task_group.task_group_id=task.task_group_id where  task_group.project_id = '"
				+ project_id + "' group by task_group.task_group_name,task_group.task_group_id,task_group.project_id ";
		ResultSet rs = stmt.executeQuery(mainquery);

		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_group_name(rs.getString("task_group_name"));
			obj.settask_group_id(rs.getInt("task_group_id"));
			obj.settasks_cnt_pergp(rs.getInt("tasks_cnt_pergp"));
			obj.setProject_id(rs.getInt("project_id"));
			list.add(obj);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);

		return json;
	}

	public List<wrapper> edittaskdetails(projectTasks_vo taskdetails, MultipartFile file) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String taskgpuquery = "update task set task_name = '" + taskdetails.getTask_name() + "',description='"
				+ taskdetails.getDescription() + "',task_type_id='" + taskdetails.gettask_type_id()
				+ "',signoff_criteria='" + taskdetails.getSignoff_criteria() + "'" + " where task_id = '"
				+ taskdetails.getTask_id() + "'";

		stmt.execute(taskgpuquery);
	
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
		return list;

	}

	public void deletedetails(int task_group_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		
	
		
		ResultSet rs = stmt
				.executeQuery("select * from task where task.task_group_id ='" + task_group_id+ "'");
		
		if (rs != null ){
			int rs1 = stmt
					.executeUpdate("Delete  from task where task.task_group_id ='" + task_group_id+ "'");
			int rs2 = stmt
					.executeUpdate("Delete  from task_group where task_group.task_group_id ='" + task_group_id+ "'");
		}else{
			int rs3 = stmt
					.executeUpdate("Delete  from task_group where task_group.task_group_id ='" + task_group_id+ "'");
			
		}
		
		
	}

}
