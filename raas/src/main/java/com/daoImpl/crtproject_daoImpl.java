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
<<<<<<< HEAD
import com.vo.projectRole_vo;
=======
>>>>>>> raasmain
import com.wrapper.wrapper;

@Component
public class crtproject_daoImpl implements crtproject_dao {

	private Connection conn;
<<<<<<< HEAD

	public void proregister(crtproject_vo crt, String userName) throws Exception {
=======
	public void proregister(crtproject_vo crt,String userName) throws Exception {
		// TODO Auto-generated method stub
		
		
>>>>>>> raasmain
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		int skill_id = 0;

<<<<<<< HEAD
		String projectquery = "insert into project(projectname,description,projectcode,status,approved,token,date_added,date_begin,date_end,project_type_id,timezone_id)values('"
				+ crt.getProject_name() + "','" + crt.getProject_desc() + "','1',1,0,'yes','" + sysdate + "','"
				+ sysdate + "','" + sysdate + "',1,'" + crt.getTimezone() + "')";
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

=======
		
		
		// project data

		String projectquery = "insert into project(projectname,description,projectcode,status,approved,token,date_added,date_begin,date_end,project_type_id,timezone_id)values('"
					+ crt.getProject_name() + "','" + crt.getProject_desc() + "','1',1,0,'yes','"+sysdate+"','"+sysdate+"','"+sysdate+"',1,'" + crt.getTimezone()+ "')";
			stmt.execute(projectquery);
			
			
			
		
		
		
		// get project_id from project table
		int project_id = 0;
		ResultSet rs = stmt.executeQuery("select project_id from project");
		while (rs.next()) {
			project_id = rs.getInt("project_id");
		}
		
		
		
		//get user details from user table 
		int user_id=0;
		String firstname="";
		String lastname="";
		ResultSet user = stmt.executeQuery("select * from user where username='"+userName+"'");
		while (user.next()) {
			user_id = user.getInt("user_id");
			firstname=user.getString("firstname");
			lastname=user.getString("lastname");
		}
		
		

		
		
		
		     // team table
				String team="insert into team (user_id,project_id,firstname,lastname"
						+ ",email,resource_type,code,status,date_added,project_infrastructure_id,user_group_id) values ('"+user_id+"','" + project_id+"','" + firstname + "','" + lastname + "','"
						+userName +"','null','101','0','" + sysdate + "',0,1)";
				
				stmt.execute(team);
				
		
		
>>>>>>> raasmain
		// project role
		List<Integer> projectrole = new ArrayList<Integer>();
		Set<Integer> checkbox = new HashSet<Integer>();
		projectrole.clear();
		checkbox.clear();
<<<<<<< HEAD
=======
		System.out.println(crt.getQuantity().size());
	
>>>>>>> raasmain
		ResultSet user_r = stmt.executeQuery("select role_id from project_role where project_id='" + project_id + "'");
		while (user_r.next()) {
			projectrole.add(user_r.getInt("role_id"));
		}
		int x;
		if (projectrole.isEmpty()) {
<<<<<<< HEAD
			for (x = 0; x < crt.getCheckboxes().size(); x++) {
				for (int j = 0; j < crt.getQuantity().get(x); j++) {
					String projectroleQuery = "insert into project_role(project_id,role_id,name,additional_desc,rate,rate_min,rate_max,frequency_code,hours_per_occurrence,ror_code,ror_occurrence_nbr,ror_end_date,date_added)values('"
							+ project_id + "','" + crt.getCheckboxes().get(x)
							+ "','"+ crt.getProject_name()+"','"+crt.getProject_desc()+"',1,1,1,1,1,1,1,'" + sysdate + "','" + sysdate + "')";
					stmt.execute(projectroleQuery);
=======
			for ( x = 0; x < crt.getCheckboxes().size(); x++) {
				for(int j=0;j<crt.getQuantity().get(x);j++){
				String projectroleQuery = "insert into project_role(project_id,role_id,name,additional_desc,date_added)values('"+project_id+"','"
						+ crt.getCheckboxes().get(x) + "','name','additional_desc','" + sysdate + "')";
				stmt.execute(projectroleQuery);
>>>>>>> raasmain
				}
			}
		} else {
			checkbox.addAll(crt.getCheckboxes());
			for (int i = 0; i < crt.getCheckboxes().size(); i++) {
				for (int j = 0; j < projectrole.size(); j++) {
					if (projectrole.get(j) == crt.getCheckboxes().get(i) && crt.getCheckboxes().get(i) != 999) {
						checkbox.remove(crt.getCheckboxes().get(i));
					} else {
					}
				}
			}
			Iterator<Integer> itr = checkbox.iterator();
			while (itr.hasNext()) {
<<<<<<< HEAD
				String projectrole1 = "insert into project_role(project_id,role_id,name,additional_desc,date_added)values('"
						+ project_id + "','" + itr.next() + "','name','additional_desc','" + sysdate + "')";
				stmt.execute(projectrole1);
			}

		}
=======
				String projectrole1 = "insert into project_role(project_id,role_id,name,additional_desc,date_added)values('"+project_id+"','"
						+ itr.next() + "','name','additional_desc','" + sysdate + "')";
				stmt.execute(projectrole1);
			}
		}
		
				

>>>>>>> raasmain
		// skills
		String TopSkillString = crt.getSkill();
		String[] namesList = TopSkillString.split(",");
		for (String skill : namesList) {
			ResultSet st = stmt.executeQuery("select skill_id from skill where name='" + skill + "'");
			while (st.next()) {
				skill_id = st.getInt(("skill_id"));
			}
			if (skill_id < 1) {
				skill_id = 999;
			}
<<<<<<< HEAD
			String projectSkillSplit = "insert into project_skill(skill_id,skill_other_name,project_id)values('"
					+ skill_id + "','" + skill + "','" + project_id + "')";
			stmt.execute(projectSkillSplit);
		}
		// store country id and zone id to address table
		int user_id2 = 0;
=======
			String projectSkillSplit = "insert into project_skill(skill_id,skill_other_name,project_id)values('" + skill_id
					+ "','" + skill + "','" + project_id + "')";
			stmt.execute(projectSkillSplit);
		}
		
		
		
		// store country id and zone id to address table
		int user_id2 = 0;

>>>>>>> raasmain
		ResultSet getuser = stmt.executeQuery("select user_id from address where user_id='" + user_id + "'");
		while (getuser.next()) {
			user_id2 = getuser.getInt("user_id");
		}
<<<<<<< HEAD

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
=======
			System.out.println(user_id2);	
				if (user_id2 == 0) {
					String address = "insert into address(User_id,address_1,address_2,city,postcode,country_id,zone_id)values('"
							+ user_id + "','','','','','" + crt.getCountry() + "','" + crt.getZone()
							+ "')";
					stmt.execute(address);
				} else {
					String Useraddress = "update address set country_id= '" + crt.getCountry() + "',zone_id='"
							+ crt.getZone() + "' where user_id = '" + user_id2+ "'";
					stmt.execute(Useraddress);
				}	
		
				
				
		System.out.println("Data Inserted successfully");
	}
	public List<wrapper> projecttype() throws Exception {
		// TODO Auto-generated method stub
>>>>>>> raasmain

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
<<<<<<< HEAD
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
			obj.setTimezone_name("timezone_name");
			obj.setProject_type_name("projecttype_name");
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
				"select a.user_id,b.project_id,c.projectname,c.description from user a LEFT OUTER JOIN project_user b ON a.user_id = '"
						+ user_id + "' INNER JOIN project c ON b.project_id = c.project_id  where a.username ='"
						+ username + "'GROUP BY b.project_id,c.projectname  ORDER BY b.project_id");

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

	public void save_addmembers(projectRole_vo role,int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		String project_role = "insert into project_role(project_id,role_id,name,additional_desc,rate,rate_min,rate_max,frequency_code,hours_per_occurrence,ror_code,ror_occurrence_nbr,ror_end_date,date_added)values('"+role.getProject_id()+"','"
				+ role.getRole_id() + "','" + role.getJobname() + "','" + role.getAdditional_desc() + "','"
				+ role.getRate() + "','" + role.getRate_min() + "','" + role.getRate_max() + "','"
				+ role.getCategory_code() + "','" + role.getHours_per_occurrence() + "',1,1,'" + sysdate + "','"
				+ sysdate + "')";
		System.out.println(project_role);
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

	
        ResultSet rs1 = stmt.executeQuery("select a.project_role_id, a.project_id,a.role_id,a.name as job_name,a.additional_desc,a.rate,a.rate_min,a.rate_max,a.frequency_code,a.hours_per_occurrence,a.ror_end_date,b.name as jobtype,c.cat_name from project_role a INNER JOIN role b ON a.role_id = b.role_id INNER JOIN category_code c ON a.frequency_code = c.cat_cde  where a.project_id = '"+project_id+"'"); 
       while(rs1.next()){
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
		List<wrapper> list = new ArrayList<wrapper>();
		
		String update_members = "update project_role set  role_id = '"+role.getRole_id()+"',name = '"+role.getJobname()+"',additional_desc = '"+role.getAdditional_desc()+"',rate ='"+role.getRate()+"',rate_min='"+role.getRate_min()+"',rate_max = '"+role.getRate_max()+"' where project_id = '"+role.getProject_id()+"'";
		stmt.execute(update_members);
	}

	
}
=======
		
		
		
		
	}

	

	
}
>>>>>>> raasmain
