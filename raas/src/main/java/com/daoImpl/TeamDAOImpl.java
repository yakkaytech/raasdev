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

import com.dao.TeamDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utility.connectionDB;
import com.vo.team_vo;
import com.wrapper.wrapper;

@Component
public class TeamDAOImpl implements TeamDAO {

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

		String createteam = "insert into team (project_id,name,assigned_ind,date_added,token)values('" + project_id
				+ "','" + team.getTeam_name() + "',1,'" + sysdate + "','" + token + "')";
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

	public void addmember(team_vo team) {

		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		String createteam = "insert into member (team_id,user_id,user_group_id,rate,active_ind,date_added)values('"
				+ team.getTeam_id() + "','" + team.getUser_id() + "',1,'" + team.getRate() + "',1,'" + sysdate + "')";
		jdbctemplate.execute(createteam);

	}

}
