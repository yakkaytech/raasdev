package com.daoImpl;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dao.user_dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utility.connectionDB;
import com.vo.registration_vo;
import com.vo.user_vo;
import com.wrapper.wrapper;

@Component
public class user_daoImpl implements user_dao {
	private Connection conn;

<<<<<<< HEAD
=======
	
	
	
	
>>>>>>> raasmain
	public void registration(registration_vo reg) throws Exception {
		// TODO Auto-generated method stub

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		InetAddress ip = InetAddress.getLocalHost();
		String ips = ip.getHostAddress();
		String user_role = "";
		String pass = new BCryptPasswordEncoder().encode(reg.getPassword());
		if ("Create Work".equals(reg.getSub())) {
			user_role = "EMPLOYER";
		} else if ("Ready for work".equals(reg.getSub1())) {
			user_role = "EMPLOYEE";
		}
		String str = "insert into user(user_group_id,username,password,firstname,lastname,email,code,ip,status,date_added,user_role,enabled) values('5','"
				+ reg.getEmail() + "','" + pass + "','" + reg.getFirst_name() + "','" + reg.getLast_name() + "','"
				+ reg.getEmail() + "','101','" + ips + "','0','" + sysdate + "','" + user_role + "',1)";
		String map = "insert into user_roles values(1,'" + reg.getEmail() + "','" + user_role + "')";

		stmt.execute(str);
		stmt.execute(map);
<<<<<<< HEAD
	}
=======
		
		
		
		
		
	}
	
	
	
	
	
	
>>>>>>> raasmain

	public void skills(user_vo org, String username) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		int skill_id = 0;
<<<<<<< HEAD
=======

		
		
		
		
>>>>>>> raasmain
		// get user_id from user table
		int user_id = 0;
		ResultSet rs = stmt.executeQuery("select user_id from user where username='" + username + "'");
		while (rs.next()) {
			user_id = rs.getInt("user_id");
		}

<<<<<<< HEAD
		String Update_team = "update team set user_id= '" + user_id + "' where email = '" + username + "'";
		stmt.execute(Update_team);

=======
		String Update_team = "update team set user_id= '" + user_id+"' where email = '" + username + "'";
        stmt.execute(Update_team);
		
		
		
		
		
>>>>>>> raasmain
		// user_additional_info
		int user_id1 = 0;
		ResultSet rs1 = stmt.executeQuery("select user_id from user_additional_info where user_id='" + user_id + "'");
		while (rs1.next()) {
			user_id1 = rs1.getInt("user_id");
		}
		if (user_id1 == 0) {
			String UserSummary = "insert into user_additional_info(user_id,summaryInfo,timezone_id,UserRate,UserAvailability)values('"
					+ user_id + "','" + org.getBreif_education() + "','" + org.getSelect2_TimeZone() + "','"
					+ org.getIdRate() + "','" + org.getSelect2_Hour() + "')";
			stmt.execute(UserSummary);
		} else {
			String UserSummary = "update user_additional_info set summaryInfo= '" + org.getBreif_education()
					+ "',UserRate='" + org.getIdRate() + "',UserAvailability='" + org.getSelect2_Hour()
					+ "' where user_id = '" + user_id1 + "'";
			stmt.execute(UserSummary);
		}
<<<<<<< HEAD
=======

		
		
		
		
		
		
		
>>>>>>> raasmain
		// user role
		List<Integer> userrole = new ArrayList<Integer>();
		Set<Integer> checkbox = new HashSet<Integer>();
		userrole.clear();
		checkbox.clear();
		ResultSet user_r = stmt.executeQuery("select role_id from user_role where user_id='" + user_id + "'");
		while (user_r.next()) {
			userrole.add(user_r.getInt("role_id"));
		}
		if (userrole.isEmpty()) {
			for (int i = 0; i < org.getCheckboxes().size(); i++) {
				String UserRole = "insert into user_role(role_id,date_added,user_id,timezone_id)values("
						+ org.getCheckboxes().get(i) + ",'" + sysdate + "','" + user_id + "','"
						+ org.getSelect2_TimeZone() + "')";
				stmt.execute(UserRole);
			}
		} else {
			checkbox.addAll(org.getCheckboxes());
			for (int i = 0; i < org.getCheckboxes().size(); i++) {
				for (int j = 0; j < userrole.size(); j++) {
					if (userrole.get(j) == org.getCheckboxes().get(i) && org.getCheckboxes().get(i) != 999) {
						checkbox.remove(org.getCheckboxes().get(i));
					} else {
					}
				}
			}
			Iterator<Integer> itr = checkbox.iterator();
			while (itr.hasNext()) {
				String UserRole1 = "insert into user_role(role_id,date_added,user_id,timezone_id)values(" + itr.next()
						+ ",'" + sysdate + "','" + user_id + "','" + org.getSelect2_TimeZone() + "')";
				stmt.execute(UserRole1);
			}
		}
<<<<<<< HEAD
=======
		
		
		
		
		
		
		

>>>>>>> raasmain
		// store country id and zone id to address table

		int user_id2 = 0;

		ResultSet getuser = stmt.executeQuery("select user_id from address where user_id='" + user_id + "'");
		while (getuser.next()) {
			user_id2 = getuser.getInt("user_id");
		}
		if (user_id2 == 0) {
			String address = "insert into address(User_id,address_1,address_2,city,postcode,country_id,zone_id)values('"
					+ user_id + "','','','','','" + org.getSelect2_Country() + "','" + org.getSelect2_StateZone()
					+ "')";
			stmt.execute(address);
		} else {
			String Useraddress = "update address set country_id= '" + org.getSelect2_Country() + "',zone_id='"
					+ org.getSelect2_StateZone() + "' where user_id = '" + user_id2 + "'";
			stmt.execute(Useraddress);
		}
<<<<<<< HEAD
=======
		
		
		
		
		
		
		

>>>>>>> raasmain
		// skills
		String TopSkillString = org.getTopskill();
		String[] namesList = TopSkillString.split(",");
		for (String skill : namesList) {
			ResultSet st = stmt.executeQuery("select skill_id from skill where name='" + skill + "'");
			while (st.next()) {
				skill_id = st.getInt(("skill_id"));
			}
			if (skill_id < 1) {
				skill_id = 999;
			}
			String UserSkillSplit = "insert into user_skill(skill_id,skill_other_name,user_id)values('" + skill_id
					+ "','" + skill + "','" + user_id + "')";
			stmt.execute(UserSkillSplit);
		}
<<<<<<< HEAD
		
	}

=======
		System.out.println("Data Inserted successfully");
	}

		

	
	
	
	
	
	
	
	
	

	
	
	
	

	
>>>>>>> raasmain
}
