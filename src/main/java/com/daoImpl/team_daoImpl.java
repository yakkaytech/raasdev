package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.dao.team_dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utility.connectionDB;
import com.vo.team_vo;
import com.wrapper.wrapper;

@Component
public class team_daoImpl implements team_dao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	private Connection conn;

	public String createTeam(int project_id, team_vo team, String token) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String json = " ";
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		
		String status_cde = null;
		ResultSet rs1 = stmt.executeQuery(
				"select status_code from status_type where status_group_code = 2 and status_name = 'Open'");

		while (rs1.next()) {
			status_cde = rs1.getString("status_code");
			
		}
		

		String createteam = "insert into team (project_id,name,assigned_ind,date_added,token,status_code)values('" + project_id
				+ "','" + team.getTeam_name() + "',0,'" + sysdate + "','" + token + "','"+status_cde+"')";
		jdbctemplate.execute(createteam);

		int rate = team.getRate();
		ResultSet rs = stmt.executeQuery(
				"select team_id from team where project_id = '" + project_id + "' AND token = '" + token + "'");

		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setTeam_id(rs.getInt("team_id"));
			obj.setRate(rate);
			list.add(obj);
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;

	}

	public void addmember(team_vo team) throws Exception {

		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		
		
		String member_code = null;
		ResultSet rs = stmt.executeQuery(
				"select category_code.cat_name from category_code INNER JOIN category_value ON category_code.cat_cde = category_value.cat_cde where category_value.value_name = 'Leader'");

		while (rs.next()){
			member_code = rs.getString("cat_name");
		}
		String createteam = "insert into member (team_id,user_id,user_group_id,rate,active_ind,date_added,member_type_code)values('"
				+ team.getTeam_id() + "','" + team.getUser_id() + "',1,'" + team.getRate() + "',1,'" + sysdate + "','"+member_code+"')";
		jdbctemplate.execute(createteam);
	}

	public List<wrapper> getteamstatus(int project_id, int team_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String status_code = null;
		List<wrapper> list = new ArrayList<wrapper>();
		ResultSet rs = stmt.executeQuery(
				"select  status_code from team where project_id = '"+project_id+"' AND team_id = '"+team_id+"'");
		while (rs.next()){
			wrapper obj = new wrapper();
			obj.setStatus_code(rs.getString("status_code"));	
			list.add(obj);
		
		}
		return list;
	}

	public String checkvalidmember(team_vo team, int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String status_code = null;
		List<wrapper> list = new ArrayList<wrapper>();
		String json = " ";
		
		ResultSet rs1 = stmt.executeQuery(
				"select  team_id from team where project_id = '"+project_id+"'");
	    int team_id = 0;
	    
		while (rs1.next()){
			wrapper obj = new wrapper();
			team_id = rs1.getInt("team_id");	
		}
		ResultSet rs = stmt.executeQuery(
				"(select  user_id from member where team_id = '"+team_id+"' AND user_id = '"+team.getUser_id()+"') UNION (SELECT '0')LIMIT 1");
	    int user_id = 0;
		
		while (rs.next()){
			wrapper obj = new wrapper();
			obj.setUser_id(rs.getInt("user_id")); 	
			list.add(obj);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;
	}

}
