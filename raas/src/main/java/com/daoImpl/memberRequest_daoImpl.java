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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.dao.memberRequest_dao;
import com.utility.connectionDB;
import com.vo.memberRequest_vo;
import com.wrapper.wrapper;

@Component
public class memberRequest_daoImpl implements memberRequest_dao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	private Connection conn;

	public void createVerificationTokenForUser(String token, memberRequest_vo req, int user_id) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		String json = "";
		list.clear();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);

		int project_role_id = 0;
		ResultSet rs2 = stmt.executeQuery(
				"select project_role_id  from project_role where  project_id = '" + req.getProject_id() + "'");

		while (rs2.next()) {
			project_role_id = rs2.getInt("project_role_id");
		}
		int teamkey = 0;
		ResultSet rs = stmt.executeQuery("select *  from team where  team_id = '" + req.getTeam_id() + "'");

		while (rs.next()) {
			teamkey = rs.getInt("token");
		}

		String attachment = "insert into member_request(team_id,firstname,lastname,team_key,request_key,user_id,project_role_id,rate,frequency_code,hours_per_occurrence,ror_code,ror_occurrence_nbr,ror_end_date,date_added)values('"
				+ req.getTeam_id() + "','" + req.getFirstname() + "','" + req.getLastname() + "','" + teamkey + "','"
				+ token + "','" + user_id + "','" + project_role_id + "',1,1,1,1,1,'" + sysdate + "','" + sysdate
				+ "')";

		jdbctemplate.execute(attachment);
	}

	public List<wrapper> getmessage() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		String json = "";
		list.clear();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		ResultSet rs2 = stmt.executeQuery("select message_id,message  from message where  active_ind = 1");
		while (rs2.next()) {
			wrapper obj = new wrapper();

			obj.setMessage(rs2.getString("message"));
			obj.setMessage_id(rs2.getInt("message_id"));
			list.add(obj);

		}
		return list;
	}

	public void saveemailcopy(SimpleMailMessage email, String email_id, String from, int user_id, int message_id) {
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		String emailcopy = "insert into message_log(message_id,user_id,notified_ind,notified_date,created_date,send_to,send_from,subject,message)values('"
				+ message_id + "','" + user_id + "','1','" + sysdate + "','" + sysdate + "','" + email_id + "','" + from
				+ "','" + email.getSubject() + "','" + email.getText() + "')";

		jdbctemplate.execute(emailcopy);

	}

}
