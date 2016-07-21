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
import com.wrapper.wrapper;

@Component
public class crtproject_daoImpl implements crtproject_dao {

	private Connection conn;
	public void proregister(crtproject_vo crt,String userName) throws Exception {
		// TODO Auto-generated method stub
		
		
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		int skill_id = 0;

		
		
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
				
		
		
		// project role
		List<Integer> projectrole = new ArrayList<Integer>();
		Set<Integer> checkbox = new HashSet<Integer>();
		projectrole.clear();
		checkbox.clear();
		System.out.println(crt.getQuantity().size());
	
		ResultSet user_r = stmt.executeQuery("select role_id from project_role where project_id='" + project_id + "'");
		while (user_r.next()) {
			projectrole.add(user_r.getInt("role_id"));
		}
		int x;
		if (projectrole.isEmpty()) {
			for ( x = 0; x < crt.getCheckboxes().size(); x++) {
				for(int j=0;j<crt.getQuantity().get(x);j++){
				String projectroleQuery = "insert into project_role(project_id,role_id,name,additional_desc,date_added)values('"+project_id+"','"
						+ crt.getCheckboxes().get(x) + "','name','additional_desc','" + sysdate + "')";
				stmt.execute(projectroleQuery);
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
				String projectrole1 = "insert into project_role(project_id,role_id,name,additional_desc,date_added)values('"+project_id+"','"
						+ itr.next() + "','name','additional_desc','" + sysdate + "')";
				stmt.execute(projectrole1);
			}
		}
		
				

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
			String projectSkillSplit = "insert into project_skill(skill_id,skill_other_name,project_id)values('" + skill_id
					+ "','" + skill + "','" + project_id + "')";
			stmt.execute(projectSkillSplit);
		}
		
		
		
		// store country id and zone id to address table
		int user_id2 = 0;

		ResultSet getuser = stmt.executeQuery("select user_id from address where user_id='" + user_id + "'");
		while (getuser.next()) {
			user_id2 = getuser.getInt("user_id");
		}
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

	

	
}
