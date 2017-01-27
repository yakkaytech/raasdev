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

import com.dao.memberrequest_dao;
import com.utility.connectionDB;
import com.vo.memberRequest_vo;
import com.wrapper.wrapper;

@Component
public class memberrequest_daoImpl implements memberrequest_dao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	private Connection conn;

	public String createVerificationTokenForUser(String token, memberRequest_vo req, int user_id) throws Exception {

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
		ResultSet rs = stmt.executeQuery("select token  from team where  team_id = '" + req.getTeam_id() + "'");

		while (rs.next()) {
			teamkey = rs.getInt("token");
		}
		
		String member_request = "insert into member_request(team_id,firstname,lastname,team_key,request_key,user_id,project_role_id,rate,frequency_code,hours_per_occurrence,ror_code,ror_occurrence_nbr,ror_end_date,date_added)values('"
				+ req.getTeam_id() + "','" + req.getFirstname() + "','" + req.getLastname() + "','" + teamkey + "','"
				+ token + "','" + user_id + "','" + project_role_id + "',1,1,1,1,1,'" + sysdate + "','" + sysdate
				+ "')";

		jdbctemplate.execute(member_request);
		
		int memberuser_id = 0;
		String Query = "select user_id  from user where  username = '" + req.getEmail() + "'";
		ResultSet rs3 = stmt.executeQuery("select user_id  from user where  username = '" + req.getEmail() + "'");


		while (rs3.next()) {
			memberuser_id = rs3.getInt("user_id");
		}
		
		if(memberuser_id != 0){
			
			int userid = 0;
			
			ResultSet rs5 = stmt.executeQuery("(select member.user_id,team.project_id  from member INNER JOIN team ON member.team_id = team.team_id where  member.user_id = '"+memberuser_id+"' AND  team.project_id='"+req.getProject_id()+"') UNION (SELECT '0','0')LIMIT 1");
			while (rs5.next()) {
				userid = rs5.getInt("user_id");
				
			}
			
			if(userid == 0){
				
				String member_code = null;
				ResultSet rs4 = stmt.executeQuery(
						"select category_code.cat_name from category_code INNER JOIN category_value ON category_code.cat_cde = category_value.cat_cde where category_value.value_name = 'Member'");

				while (rs4.next()){
					member_code = rs4.getString("cat_name");
				}
				
				String member = "insert into member(team_id,user_id,user_group_id,rate,active_ind,date_added,member_type_code)values('"
						+ req.getTeam_id() + "','" + memberuser_id + "','1','3','0','" + sysdate + "','"+member_code+"')";
				jdbctemplate.execute(member);
				
			}else{
				
				return "false";
				
			}
		}else{
		return "false";
		
		}
		return "true";
	}

	public List<wrapper> getmessage() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
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

	public void saveemailcopy(SimpleMailMessage email, String email_id,  int user_id, int message_id) {
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		String emailcopy = "insert into message_log(message_id,user_id,notified_ind,notified_date,created_date,send_to,send_from,subject,message)values('"
				+ message_id + "','" + user_id + "','1','" + sysdate + "','" + sysdate + "','" + email_id + "','" + email.getFrom()
				+ "','" + email.getSubject() + "','" + email.getText() + "')";

		jdbctemplate.execute(emailcopy);

	}

}
