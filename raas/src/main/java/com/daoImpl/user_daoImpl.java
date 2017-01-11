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
import org.springframework.web.multipart.MultipartFile;

import com.dao.user_dao;
import com.utility.connectionDB;
import com.vo.registration_vo;
import com.vo.skill;
import com.vo.user_vo;
import com.wrapper.wrapper;

@Component
public class user_daoImpl implements user_dao {
	private Connection conn;

	public void registration(registration_vo reg) throws Exception {

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
		stmt.execute(str);
		int user_id = 0;
		ResultSet rs = stmt.executeQuery("select user_id from user");
		while (rs.next()) {
			user_id = rs.getInt("user_id");
		}
		String map = "insert into user_roles values(1,'" + reg.getEmail() + "','" + user_role + "','" + user_id + "')";

		stmt.execute(map);
	}

	public void skills(user_vo org, String username) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		int skill_id = 0;
		// get user_id from user table
		int user_id = 0;
		ResultSet rs = stmt.executeQuery("select user_id from user where username='" + username + "'");
		while (rs.next()) {
			user_id = rs.getInt("user_id");
		}

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

	}
	

	public void insertskill(int user_id, skill[] skills) throws Exception {
		// TODO Auto-generated method stub
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		 System.out.println(skills.length);
		 int skill_id=0;
	     for (skill data : skills) {
	    	 System.out.println(data.getInputskill());
	    	 System.out.println(data.getInputyear());
	    	 ResultSet st = stmt.executeQuery("select skill_id,skill_other_name from user_skill where skill_other_name='" +data.getInputskill()+"' and user_id='"+user_id+"'");  
	    	 while (st.next()) {
					skill_id = st.getInt(("skill_id"));
	          }
	    	
	    	 if(skill_id == 0){
	    		 ResultSet st1 = stmt.executeQuery("select skill_id from skill where name='" +data.getInputskill() + "'");
	 			 int skill_id1=0;
	    		 while (st1.next()) {
	 				skill_id1 = st1.getInt(("skill_id"));
	 			}
	 			if (skill_id < 1) {
	 				skill_id = 999;
	 			}
	 			String UserSkillSplit = "insert into user_skill(skill_id,skill_other_name,user_id,yoe_code,el_code)values('" + skill_id1
	 					+ "','" + data.getInputskill() + "','" + user_id + "','"+data.getInputyear()+"','"+data.getInputexp()+"')";
	 			stmt.execute(UserSkillSplit);
	    		 
	    	 }else{
	    		 String Useraddress = "update user_skill  set  yoe_code='"+data.getInputyear()+"',el_code='"+data.getInputexp()+"' where skill_id='" +skill_id+"' and  user_id = '" + user_id+ "'" ;
	 			  stmt.execute(Useraddress);
	 			  //System.out.println(Useraddress);
	    	 }
	     }
		
		
	}
	public void deleteskill(int user_id, skill skills) throws Exception {
		// TODO Auto-generated method stub
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		int rs1 = stmt.executeUpdate("Delete  from user_skill where user_id ='" + user_id + "' and skill_other_name='"+skills.getInputskill()+"'");
		
	}


	public void createVerificationTokenForUser(String token, registration_vo reg) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		// String username;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);

		String str = "insert into user_reg_activation(token,email,active_ind,date_and_time) values('" + token + "','"
				+ reg.getEmail() + "','0','" + sysdate + "')";
		stmt.execute(str);

	}

	public void reg_activation(String token, registration_vo reg, String email_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		// String username;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);

		String str = "update user_reg_activation set active_ind = '1',activation_date = '" + sysdate
				+ "' WHERE token = '" + token + "' AND email = '" + email_id + "'";
		stmt.execute(str);

	}

	public String gettoken(String email_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String token = "";
		String sql = "select token from user_reg_activation WHERE email = '" + email_id + "'";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {

			token = rs.getString("token");

		}
		return token;
	}

	public void resendVerificationTokenForUser(String token, registration_vo reg) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);

		String str = "update user_reg_activation set token = '" + token + "',date_and_time= '" + sysdate
				+ "' WHERE  email = '" + reg.getEmail() + "'";
		stmt.execute(str);

	}

	public List<wrapper> getuserdetails(int userid) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String sql = "select user.user_id,user.firstname,user.lastname,user.email,ur.role_id,r.name,ad.country_id,ctry.country_name,ad.zone_id,z.zonename "
				+ "from user INNER JOIN user_role ur on user.user_id=ur.user_id INNER JOIN role r on r.role_id=ur.role_id inner join address ad on ad.user_id=user.user_id "
				+ "inner join country ctry on ad.country_id=ctry.country_id inner join zone z on ad.zone_id=z.zone_id where user.user_id='"
				+ userid + "'";
		ResultSet rs1 = stmt.executeQuery(sql);
		while (rs1.next()) {
			wrapper obj1 = new wrapper();
			obj1.setUser_id(rs1.getInt("user_id"));
			obj1.setFirstname(rs1.getString("firstname"));
			obj1.setLastname(rs1.getString("lastname"));
			obj1.setEmail(rs1.getString("email"));
			obj1.setRole_id(rs1.getInt("role_id"));
			obj1.setRole_name(rs1.getString("name"));
			// obj1.setSkill_id(rs1.getInt("skill_id"));
			// obj1.setSkill_name(rs1.getString("skill_other_name"));
			obj1.setCountry_id(rs1.getInt("country_id"));
			obj1.setCountry_name(rs1.getString("country_name"));
			obj1.setZone_id(rs1.getInt("zone_id"));
			obj1.setZone_name(rs1.getString("zonename"));
			list.add(obj1);
		}

		return list;
	}

	public List<wrapper> getuserskills(int userid) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt
				.executeQuery("select skill_other_name,skill_id,yoe_code,el_code from user_skill where user_id='" + userid + "'");
		while (rs.next()) {
			wrapper obj1 = new wrapper();
			obj1.setSkill_name(rs.getString("skill_other_name"));
			obj1.setSkill_id(rs.getInt("skill_id"));
			obj1.setYearexp(rs.getString("yoe_code"));
			obj1.setExplevel(rs.getString("el_code"));
			list.add(obj1);
		}

		return list;
	}

	public void getuserdetail(registration_vo rvo, user_vo uvo) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		int user_id = rvo.getUser_id();
		String user = "update user set user_id='" + rvo.getUser_id() + "',firstname='" + rvo.getFirst_name()
				+ "',lastname='" + rvo.getLast_name() + "' where user_id='" + rvo.getUser_id() + "'";
		stmt.execute(user);
		String role = "update user_role set role_id='" + uvo.getRole_id() + "' where user_id='" + rvo.getUser_id()
				+ "'";
		stmt.execute(role);
		String address = "update address set country_id='" + uvo.getCountry_id() + "',zone_id='" + uvo.getSzone_id()
				+ "' where user_id='" + rvo.getUser_id() + "'";
		stmt.execute(address);

	}

	public void getuserupdate(registration_vo rvo, user_vo uvo, MultipartFile file, String token) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		int user_id = rvo.getUser_id();
		String user = "update user set user_id='" + rvo.getUser_id() + "',firstname='" + rvo.getFirst_name()
				+ "',lastname='" + rvo.getLast_name() + "' where user_id='" + rvo.getUser_id() + "'";
		stmt.execute(user);
		String role = "update user_role set role_id='" + uvo.getRole_id() + "' where user_id='" + rvo.getUser_id()
				+ "'";
		stmt.execute(role);
		String address = "update address set country_id='" + uvo.getCountry_id() + "',zone_id='" + uvo.getSzone_id()
				+ "' where user_id='" + rvo.getUser_id() + "'";
		stmt.execute(address);
		ResultSet getuser = stmt
				.executeQuery("select user_id from uploadimage where user_id='" + rvo.getUser_id() + "'");
		int userid = 0;
		while (getuser.next()) {
			userid = getuser.getInt("user_id");

		}
		if (userid == 0) {

			String image = "insert into uploadimage(image_path,image_name,size,user_id)values('D:/Attachmentssave/','"
					+ token + ".jpg','" + file.getSize() + "','" + rvo.getUser_id() + "')";
			stmt.execute(image);
		} else {
			String imageupdate = "update uploadimage set image_name='" + token + ".jpg',size='" + file.getSize()
					+ "' where user_id='" + userid + "'";
			stmt.execute(imageupdate);
		}

	}

	

}
