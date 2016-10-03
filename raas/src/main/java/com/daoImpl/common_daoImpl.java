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

	public List<wrapper> tabledata() throws Exception {

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

	public List<wrapper> dropdowndata() throws Exception {

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
		ResultSet rs1 = stmt.executeQuery("select * from zone where country_id=223");
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
}