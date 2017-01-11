package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dao.common_dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utility.connectionDB;
import com.vo.user_vo;
import com.wrapper.wrapper;

@Component
public class common_daoImpl implements common_dao {

	private Connection conn;

	public List<wrapper> role() throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery("select * from role");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setCheckbox(rs.getString("role_id"));
			obj.setName(rs.getString("name"));
			obj.setDes(rs.getString("description"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> countrydata() throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs1 = stmt.executeQuery("select * from country ORDER BY country_code ASC");
		while (rs1.next()) {
			wrapper obj1 = new wrapper();
			obj1.setCountry_name(rs1.getString("country_name"));
			obj1.setCountry_id(rs1.getInt("country_id"));
			list.add(obj1);
		}
		return list;
	}

	public List<wrapper> timezonedata() throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs1 = stmt.executeQuery("select * from timezone");
		while (rs1.next()) {
			wrapper obj1 = new wrapper();
			obj1.setTimezone_name(rs1.getString("timezone_name"));
			obj1.setTimezone_id(rs1.getInt("timezone_id"));
			list.add(obj1);
		}
		return list;
	}

	public List<wrapper> zonedata() throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs1 = stmt.executeQuery("select * from zone where country_id=99");
		while (rs1.next()) {
			wrapper obj1 = new wrapper();
			obj1.setState_name(rs1.getString("zonename"));
			obj1.setState_id(rs1.getInt("zone_id"));
			list.add(obj1);
		}
		return list;
	}

	// states
	public String dropdownstate(user_vo obj) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list1 = new ArrayList<wrapper>();
		list1.clear();
		ResultSet rs1 = stmt.executeQuery("select * from zone where country_id='" + obj.getDropstate() + "'");
		while (rs1.next()) {
			wrapper obj1 = new wrapper();
			obj1.setState_name(rs1.getString("zonename"));
			obj1.setState_id(rs1.getInt("zone_id"));
			list1.add(obj1);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list1);
		return json;
	}

	public int getuser_id(String userName) throws Exception {
		// TODO Auto-generated method stub
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		int userid = 0;
		ResultSet rs = stmt.executeQuery("select user_id from user where username='" + userName + "'");
		while (rs.next()) {
			userid = rs.getInt("user_id");
		}
		return userid;
	}

	public String getimage(int userid) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String imagename = null;
		ResultSet rs = stmt.executeQuery("select image_name from uploadimage where user_id='" + userid + "'");
		while (rs.next()) {
			imagename = rs.getString("image_name");
		}
		return imagename;
	}

	public List getSkills(String term) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select name from skill");
		String skill = null;
		List list = new ArrayList();
		while (rs.next()) {
			skill = rs.getString("name");
			list.add(skill);
		}
		int ctn = 1;
		String skills = null;
		List<String> matched = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			skills = list.get(i).toString().toUpperCase();
			String tm = term.toString().toUpperCase();
			if (skills.startsWith(tm)) {
				matched.add(skills);

			}
		}
		return matched;
	}

	public List<wrapper> getexplevel() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs1 = stmt.executeQuery(
				"select cc.cat_name from category_value cv inner join category_code cc on cv.cat_cde=cc.cat_cde where cat_active_ind=4");
		while (rs1.next()) {
			wrapper obj1 = new wrapper();
			obj1.setExplevel(rs1.getString("cat_name"));
			list.add(obj1);
		}
		return list;
	}

	public List<wrapper> getyearexp() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs1 = stmt.executeQuery(
				"select cc.cat_name from category_value cv  inner join category_code cc on cv.cat_cde=cc.cat_cde  where cat_active_ind=5 order by cv.cat_cde + 0");
		while (rs1.next()) {
			wrapper obj1 = new wrapper();
			obj1.setYearexp(rs1.getString("cat_name"));
			list.add(obj1);
		}
		return list;
	}

}