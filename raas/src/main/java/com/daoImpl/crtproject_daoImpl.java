package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.dao.crtproject_dao;

import com.utility.connectionDB;
import com.vo.crtproject_vo;
import com.vo.projectRole_vo;
import com.wrapper.wrapper;

@Component
public class crtproject_daoImpl implements crtproject_dao {

	private Connection conn;

	public void proregister(crtproject_vo crt, String userName) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		int skill_id = 0;

		String projectquery = "insert into project(projectname,description,projectcode,status,approved,token,date_added,date_begin,date_end,project_type_id,timezone_id,active_ind)values('"
				+ crt.getProject_name() + "','" + crt.getProject_desc() + "','1',1,0,'yes','" + sysdate + "','"
				+ sysdate + "','" + sysdate + "',1,'" + crt.getTimezone() + "',1)";
		stmt.execute(projectquery);

		// get project_id from project table
		int project_id = 0;
		String projectname = "";
		ResultSet rs = stmt.executeQuery(
				"select project_id,projectname from project where projectname = '" + crt.getProject_name() + "'");
		while (rs.next()) {
			project_id = rs.getInt("project_id");
			projectname = rs.getString("projectname");

			crt.setProject_id(rs.getInt("project_id"));
		}
		// get user details from user table
		int user_id = 0;
		String firstname = "";
		String lastname = "";
		ResultSet user = stmt.executeQuery("select * from user where username='" + userName + "'");
		while (user.next()) {
			user_id = user.getInt("user_id");
			firstname = user.getString("firstname");
			lastname = user.getString("lastname");
		}
		String projectuser = "insert into project_user(user_id,project_id)values('" + user_id + "','" + project_id
				+ "')";
		stmt.execute(projectuser);

		// skills
		String skill = crt.getSkill();
		String skill_name = null;
		ResultSet st = stmt.executeQuery("select name from skill where skill_id ='" + skill + "'");
		while (st.next()) {

			skill_name = st.getString("name");

		}

		String skillname = crt.getSkill_other_name();

		String projectSkillSplit = "insert into project_skill(skill_id,skill_other_name,project_id)values('" + skill
				+ "','" + skillname + "','" + project_id + "')";

		stmt.execute(projectSkillSplit);

		// store country id and zone id to address table
		int user_id2 = 0;
		ResultSet getuser = stmt.executeQuery("select user_id from address where user_id='" + user_id + "'");
		while (getuser.next()) {
			user_id2 = getuser.getInt("user_id");
		}

		if (user_id2 == 0) {
			String address = "insert into address(User_id,address_1,address_2,city,postcode,country_id,zone_id)values('"
					+ user_id + "','','','','','" + crt.getCountry() + "','" + crt.getZone() + "')";
			stmt.execute(address);
		} else {
			String Useraddress = "update address set country_id= '" + crt.getCountry() + "',zone_id='" + crt.getZone()
					+ "' where user_id = '" + user_id2 + "'";
			stmt.execute(Useraddress);
		}

	}

	public List<wrapper> projecttype() throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs1 = stmt.executeQuery("select * from project_type where active_ind=1");
		while (rs1.next()) {
			wrapper obj1 = new wrapper();
			obj1.setProject_id(rs1.getInt("project_type_id"));
			obj1.setProject_type(rs1.getString("type_name"));
			list.add(obj1);
		}
		return list;
	}

	public List<wrapper> prodetail(crtproject_vo crt, String userName, int project_id) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		List<wrapper> list1 = new ArrayList<wrapper>();
		list.clear();
		int timezone_id = 0;
		int project_type_id = 0;
		String projecttype_name = null;
		String timezone_name = null;
		ResultSet rs = stmt.executeQuery("select * from project where project_id ='" + project_id + "'");

		while (rs.next()) {
			timezone_id = rs.getInt("timezone_id");
			project_type_id = rs.getInt("project_type_id");
		}
		ResultSet rs1 = stmt
				.executeQuery("select timezone.timezone_name from timezone where timezone_id ='" + timezone_id + "'");
		while (rs1.next()) {
			timezone_name = rs1.getString("timezone_name");
		}
		ResultSet rs2 = stmt.executeQuery(
				"select project_type.type_name from project_type where project_type_id ='" + project_type_id + "'");
		while (rs2.next()) {
			projecttype_name = rs2.getString("type_name");
		}

		ResultSet rs3 = stmt.executeQuery("select * from project where project_id ='" + project_id + "'");
		while (rs3.next()) {
			wrapper obj = new wrapper();
			obj.setProject_name(rs3.getString("projectname"));
			obj.setProject_desc(rs3.getString("description"));
			obj.setProject_id(rs3.getInt("project_id"));
			obj.setTimezone_name(timezone_name);
			obj.setProject_type_name(projecttype_name);
			list.add(obj);
		}
		return list;
	}

	public void getprojectupdate(crtproject_vo crt) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String projectupdate = "update project set projectname = '" + crt.getProject_name() + "',description = '"
				+ crt.getProject_desc() + "' where project_id='" + crt.getProject_id() + "'";
		stmt.execute(projectupdate);

	}

	public List<wrapper> getuserproupdate(crtproject_vo crt, String username) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery("select * from user where username ='" + username + "'");
		int user_id = 0;
		if (rs.next()) {
			user_id = rs.getInt("user_id");
		}
		ResultSet rs1 = stmt.executeQuery(
				"select a.user_id,b.project_id,c.projectname,c.description from user a LEFT OUTER JOIN project_user b ON a.user_id = b.user_id INNER JOIN project c ON b.project_id = c.project_id  where a.username ='"
						+ username + "' GROUP BY b.project_id,c.projectname  ORDER BY b.project_id");

		int project_id;
		int project_name;
		int project_desc;
		while (rs1.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs1.getInt("project_id"));
			obj.setProject_name(rs1.getString("projectname"));
			obj.setProject_desc(rs1.getString("description"));
			list.add(obj);
		}
		return list;

	}

	public int getuserprojectid(crtproject_vo crt, String username) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery("select * from user where username = '" + username + "'");
		int user_id = 0;
		while (rs.next()) {
			user_id = rs.getInt("user_id");
		}
		ResultSet rs1 = stmt.executeQuery("select * from project_user where user_id = '" + user_id + "'");
		int project_id = 0;
		while (rs1.next()) {
			wrapper obj = new wrapper();
			project_id = rs1.getInt("project_id");

		}
		return project_id;
	}

	public List<wrapper> jobtype() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery("select * from role where status=1");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setRole_id(rs.getInt("role_id"));
			obj.setRole_name(rs.getString("name"));
			list.add(obj);
		}
		return list;
	}

	public void save_addmembers(projectRole_vo role, int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		String project_role = "insert into project_role(project_id,role_id,name,additional_desc,rate,rate_min,rate_max,frequency_code,hours_per_occurrence,ror_code,ror_occurrence_nbr,ror_end_date,date_added,active_ind,publish_ind)values('"
				+ role.getProject_id() + "','" + role.getRole_id() + "','" + role.getJobname() + "','"
				+ role.getAdditional_desc() + "','" + role.getRate() + "','" + role.getRate_min() + "','"
				+ role.getRate_max() + "','" + role.getCategory_code() + "','" + role.getHours_per_occurrence()
				+ "',1,1,'" + sysdate + "','" + sysdate + "',1,0)";

		stmt.execute(project_role);

	}

	public List<wrapper> frequency_code() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery("select * from category_code where cat_active_ind=1");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setCategory_code(rs.getString("cat_cde"));
			obj.setCategory_name(rs.getString("cat_name"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> getjobdetails(projectRole_vo role, int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs1 = stmt.executeQuery(
				"select a.project_role_id, a.project_id,a.role_id,a.name as job_name,a.additional_desc,a.rate,a.rate_min,a.rate_max,a.frequency_code,a.hours_per_occurrence,a.ror_end_date,b.name as jobtype,c.cat_name from project_role a INNER JOIN role b ON a.role_id = b.role_id INNER JOIN category_code c ON a.frequency_code = c.cat_cde  where a.project_id = '"
						+ project_id + "' AND a.publish_ind = 0");
		while (rs1.next()) {
			wrapper obj = new wrapper();
			obj.setProject_role_id(rs1.getInt("project_role_id"));
			obj.setJobname(rs1.getString("job_name"));
			obj.setJobtype(rs1.getString("jobtype"));
			obj.setJob_desc(rs1.getString("additional_desc"));
			obj.setRate(rs1.getInt("rate"));
			obj.setRate_min(rs1.getInt("rate_min"));
			obj.setRate_max(rs1.getInt("rate_max"));
			obj.setNo_of_occurrence(rs1.getInt("hours_per_occurrence"));
			obj.setRor_enddate(rs1.getDate("ror_end_date"));
			obj.setFrequency(rs1.getString("cat_name"));
			obj.setProject_id(rs1.getInt("project_id"));

			list.add(obj);
		}
		return list;

	}

	public void edit_addmembers(projectRole_vo role) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String update_members = "update project_role set  role_id = '" + role.getRole_id() + "',name = '"
				+ role.getJobname() + "',additional_desc = '" + role.getAdditional_desc() + "',rate = '"
				+ role.getRate() + "',rate_min='" + role.getRate_min() + "',rate_max = '" + role.getRate_max()
				+ "',hours_per_occurrence = '" + role.getHours_per_occurrence() + "',frequency_code = '"
				+ role.getCategory_code() + "' where project_role_id = '" + role.getProject_role_id() + "'";
		stmt.execute(update_members);
	}

	public List<wrapper> geteditdetails(projectRole_vo role, int project_role_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();

		ResultSet rs = stmt.executeQuery("select * from project_role where project_role_id = '" + project_role_id
				+ "' GROUP BY project_role_id;");

		while (rs.next()) {
			wrapper obj = new wrapper();

			obj.setProject_role_id(rs.getInt("project_role_id"));
			obj.setJobname(rs.getString("name"));
			obj.setRole_id(rs.getInt("role_id"));
			obj.setJob_desc(rs.getString("additional_desc"));
			obj.setRate(rs.getInt("rate"));
			obj.setRate_min(rs.getInt("rate_min"));
			obj.setRate_max(rs.getInt("rate_max"));
			obj.setNo_of_occurrence(rs.getInt("hours_per_occurrence"));
			obj.setRor_enddate(rs.getDate("ror_end_date"));
			obj.setProject_id(rs.getInt("project_id"));

			list.add(obj);
		}
		return list;
	}

	public void save_and_publish(projectRole_vo role, int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		String project_role = "insert into project_role(project_id,role_id,name,additional_desc,rate,rate_min,rate_max,frequency_code,hours_per_occurrence,ror_code,ror_occurrence_nbr,ror_end_date,date_added,active_ind,publish_ind)values('"
				+ role.getProject_id() + "','" + role.getRole_id() + "','" + role.getJobname() + "','"
				+ role.getAdditional_desc() + "','" + role.getRate() + "','" + role.getRate_min() + "','"
				+ role.getRate_max() + "','" + role.getCategory_code() + "','" + role.getHours_per_occurrence()
				+ "',1,1,'" + sysdate + "','" + sysdate + "',1,1)";

		stmt.execute(project_role);

	}

	public List<wrapper> skill() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		List<wrapper> list1 = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery("select * from skill where description = 'Java'");
		int project_id = 0;
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setSkill_id(rs.getInt("skill_id"));
			obj.setSkill_name(rs.getString("name"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> timeline() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery("select * from category_code where cat_active_ind=3");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setCategory_code(rs.getString("cat_cde"));
			obj.setCategory_name(rs.getString("cat_name"));
			list.add(obj);
		}

		return list;

	}

	public void prjtrole_edit_publishmember(projectRole_vo role) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String update_members = "update project_role set  role_id = '" + role.getRole_id() + "',name = '"
				+ role.getJobname() + "',additional_desc = '" + role.getAdditional_desc() + "',rate = '"
				+ role.getRate() + "',rate_min='" + role.getRate_min() + "',rate_max = '" + role.getRate_max()
				+ "',hours_per_occurrence = '" + role.getHours_per_occurrence() + "',frequency_code = '"
				+ role.getCategory_code() + "',publish_ind = 1 where project_role_id = '" + role.getProject_role_id()
				+ "'  ";
		stmt.execute(update_members);
	}

	public List<wrapper> pro_name(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String project_name = " ";
		ResultSet rs = stmt.executeQuery("select * from project where project_id='" + project_id + "'");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_name(rs.getString("projectname"));
			obj.setProject_id(rs.getInt("project_id"));
			list.add(obj);
		}

		return list;
	}

}