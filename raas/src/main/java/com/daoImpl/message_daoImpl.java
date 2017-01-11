package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dao.message_dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utility.connectionDB;
import com.vo.message_vo;
import com.wrapper.wrapper;

@Component
public class message_daoImpl implements message_dao {

	private Connection conn;

	public void messageactivity(message_vo msg, String username) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		dateFormat.format(date);
		ResultSet user = stmt
				.executeQuery("select username,user_id,firstname from user where username='" + username + "'");
		while (user.next()) {
			username = user.getString("username");
			user.getInt("user_id");
			user.getString("firstname");
		}

	}

	public List<wrapper> userlist(String username, message_vo msg) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery("select firstname from user where username='" + username + "'");

		while (rs.next()) {
			wrapper obj = new wrapper();

			obj.setFirstname(rs.getString("firstname"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> connect(String username) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery("select firstname from participants where username='" + username + "'");

		while (rs.next()) {
			wrapper obj = new wrapper();

			obj.setFirstname(rs.getString("firstname"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> disconnect(String username) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		stmt.executeUpdate("DELETE FROM participants WHERE username='" + username + "'");

		return list;
	}

	public List<wrapper> message(message_vo msg, String username) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		int user_id = 0;
		String Firstname = "";
		sysdate = dateFormat.format(date);
		ResultSet user = stmt
				.executeQuery("select username,user_id,firstname from user where username='" + username + "'");
		while (user.next()) {
			username = user.getString("username");
			user_id = user.getInt("user_id");
			Firstname = user.getString("firstname");
		}

		// insert message table
		String messagequery = ("insert into messages(user_id,firstname,message,time,username,active_ind)values('"
				+ user_id + "','" + Firstname + "','" + msg.getMessages() + "','" + sysdate + "','" + username
				+ "','1')");

		stmt.execute(messagequery);

		ResultSet rs = stmt.executeQuery("select firstname,message,time from messages where active_ind= 1 ");
		while (rs.next()) {
			wrapper obj = new wrapper();

			obj.setFirstname(rs.getString("firstname"));
			obj.setMessages(rs.getString("message"));
			obj.setTime(rs.getString("time"));
			list.add(obj);
		}

		return list;

	}

	public List<wrapper> messages(message_vo msg) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery("select firstname,message,time from messages where active_ind= 1 ");
		while (rs.next()) {
			wrapper obj = new wrapper();

			obj.setFirstname(rs.getString("firstname"));
			obj.setMessages(rs.getString("message"));
			obj.setTime(rs.getString("time"));
			list.add(obj);
		}
		return list;
	}

	public List<wrapper> messagedata(String username, message_vo msg) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
