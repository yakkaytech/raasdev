package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.dao.proposal_dao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.utility.connectionDB;
import com.vo.proposaltasks_vo;
import com.wrapper.wrapper;

@Component
public class Proposal_daoImpl implements proposal_dao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	private Connection conn;

	public void addTask(proposaltasks_vo taskdetails, MultipartFile file, int project_id, String token, String fileName,
			long filesize) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		String json = "";
		list.clear();
		String sysdate;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
		String attachment = "insert into attachment(name,description,file_size,token)values('" + fileName + "','file','"
				+ filesize + "','" + token + "')";

		jdbctemplate.execute(attachment);
		int attachment_id = 0;
		ResultSet rs2 = stmt.executeQuery("select attachment_id  from attachment where  token = '" + token + "'");

		while (rs2.next()) {

			attachment_id = rs2.getInt("attachment_id");
		}

		int member_id = 0;
		ResultSet rs = stmt
				.executeQuery("select member_id  from member where  team_id = '" + taskdetails.getTeam_id() + "'");

		while (rs.next()) {

			member_id = rs.getInt("member_id");
		}

		String team = "insert into proposal_task(team_id,feature_id,task_type_id,project_id,owner_member_id,task_name,description,signoff_criteria,estimated_hours,due_date,sort_order,size_code,token,date_added,attachment_id)values('"
				+ taskdetails.getTeam_id() + "','" + taskdetails.getFeature_id() + "','" + taskdetails.getTask_type_id()
				+ "','" + project_id + "','" + member_id + "','" + taskdetails.getTask_name() + "','"
				+ taskdetails.getDescription() + "','" + taskdetails.getSignoff_criteria() + "','"
				+ taskdetails.getEstimated_hours() + "','" + sysdate + "',1,'" + taskdetails.getSize_code() + "','"
				+ token + "','" + sysdate + "','" + attachment_id + "')";

		jdbctemplate.execute(team);

	}

	public List<wrapper> gettaskdetails(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"select proposal_task.estimated_hours,proposal_task.task_id,proposal_task.project_id,proposal_task.feature_id,proposal_task.task_name,proposal_task.size_code from proposal_task where project_id ='"
						+ project_id + "'");

		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_id(rs.getInt("task_id"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_size_code(rs.getString("size_code"));
			obj.setProject_id(rs.getInt("project_id"));
			obj.setEstimated_hours(rs.getInt("estimated_hours"));

			list.add(obj);
		}
		return list;
	}

	public String getproposalviewdetails(proposaltasks_vo ptv) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"select proposal_task.task_id,proposal_task.project_id,proposal_task.owner_member_id,member.member_id,member.rate*proposal_task.estimated_hours as cost,user.firstname,user.lastname,proposal_task.estimated_hours,proposal_task.signoff_criteria,proposal_task.feature_id,proposal_task.task_name,proposal_task.attachment_id,proposal_task.description,proposal_task.task_type_id,task_type.type_name,attachment.name from proposal_task INNER JOIN task_type ON task_type.task_type_id = proposal_task.task_type_id  INNER JOIN attachment ON attachment.attachment_id = proposal_task.attachment_id INNER JOIN member ON member.member_id = proposal_task.owner_member_id INNER JOIN user ON user.user_id = member.user_id where proposal_task.task_id ='"
						+ ptv.getTask_id() + "'");

		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.settask_id(rs.getInt("task_id"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.setEstimated_hours(rs.getInt("estimated_hours"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.setFile_name(rs.getString("name"));
			obj.setFirstname(rs.getString("firstname"));
			obj.setLastname(rs.getString("lastname"));
			obj.setCost(rs.getInt("cost"));
			list.add(obj);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;
	}

	public List<wrapper> getproposalfirstviewdetails(int project_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		ResultSet rs = stmt.executeQuery(
				"select proposal_task.task_id,proposal_task.project_id,proposal_task.owner_member_id,member.member_id,member.rate*proposal_task.estimated_hours as cost,user.firstname,user.lastname,proposal_task.estimated_hours,proposal_task.signoff_criteria,proposal_task.feature_id,proposal_task.task_name,proposal_task.attachment_id,proposal_task.description,proposal_task.task_type_id,task_type.type_name,attachment.name from proposal_task INNER JOIN task_type ON task_type.task_type_id = proposal_task.task_type_id  INNER JOIN attachment ON attachment.attachment_id = proposal_task.attachment_id INNER JOIN member ON member.member_id = proposal_task.owner_member_id INNER JOIN user ON user.user_id = member.user_id where proposal_task.project_id = '"+project_id+"'order by proposal_task.task_id");

		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.settask_id(rs.getInt("task_id"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.setEstimated_hours(rs.getInt("estimated_hours"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_description(rs.getString("description"));
			obj.setFile_name(rs.getString("name"));
			obj.setFirstname(rs.getString("firstname"));
			obj.setLastname(rs.getString("lastname"));
			obj.setCost(rs.getInt("cost"));
			list.add(obj);
		}

		return list;
	}

	public String getfeatureviewdetails(int project_id, proposaltasks_vo taskgp) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String json = " ";

		ResultSet rs = stmt.executeQuery(
				"select proposal_task.project_id,proposal_task.task_id,proposal_task.estimated_hours,proposal_task.feature_id,proposal_task.task_type_id,task_type.type_name,proposal_task.task_id,proposal_task.task_name,proposal_task.description,proposal_task.size_code from proposal_task  INNER JOIN task_type ON proposal_task.task_type_id = task_type.task_type_id where proposal_task.project_id = '"
						+ project_id + "' AND proposal_task.feature_id= '" + taskgp.getFeature_id()
						+ "' ORDER BY proposal_task.date_added desc");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.settask_id(rs.getInt("task_id"));
			obj.setfeature_id(rs.getInt("feature_id"));
			obj.setEstimated_hours(rs.getInt("estimated_hours"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_type_name(rs.getString("type_name"));
			obj.settask_description(rs.getString("description"));
			obj.settask_size_code(rs.getString("size_code"));
		

			list.add(obj);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);

		return json;
	}

	public List<wrapper> getteamdetails(int team_id) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"select member.user_id,member.team_id,user.firstname,user.lastname from member INNER JOIN user ON user.user_id = member.user_id where member.team_id = '"
						+ team_id + "'");

		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setFirstname(rs.getString("firstname"));
			obj.setLastname(rs.getString("lastname"));
			obj.setTeam_id(rs.getInt("team_id"));

			list.add(obj);
		}

		return list;
	}

	public String editproposaltaskdetails(proposaltasks_vo ptv, MultipartFile file) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = " ";

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		String taskgpuquery = "update proposal_task set task_name = '" + ptv.getTask_name() + "',description='"
				+ ptv.getDescription() + "',task_type_id='" + ptv.getTask_type_id() + "',signoff_criteria='"
				+ ptv.getSignoff_criteria() + "'" + " where task_id = '" + ptv.getTask_id() + "'";
		stmt.execute(taskgpuquery);

		// String filename = file.getOriginalFilename();
		// String attachupdate = "update attachment set file_name = '" +
		// file.getOriginalFilename()
		// + "' where task_id = '" + ptv.getTask_id() + "'";
		// stmt.execute(attachupdate);
		ResultSet rs = stmt.executeQuery("Select * from proposal_task where task_id = '" + ptv.getTask_id() + "'");
		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.settask_id(rs.getInt("task_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.setTask_type_id(rs.getInt("task_type_id"));
			obj.settask_name(rs.getString("task_name"));
			obj.settask_description(rs.getString("description"));
			obj.setTask_signoff_criteria(rs.getString("signoff_criteria"));
			obj.settask_size_code(rs.getString("size_code"));

			list.add(obj);

		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;

	}

	public int getteam_id(int project_id, String username) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = " ";

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		int user_id = 0;

		ResultSet rs = stmt.executeQuery("Select user_id from user where username = '" + username + "'");

		while (rs.next()) {
			user_id = rs.getInt("user_id");
		}

		int team_id = 0;
		ResultSet rs1 = stmt.executeQuery(
				"Select team.project_id,team.team_id,member.team_id,member.user_id from team INNER JOIN member ON member.team_id = team.team_id  where team.project_id = '"
						+ project_id + "' AND member.user_id = '" + user_id + "'");

		while (rs1.next()) {
			team_id = rs1.getInt("team_id");
		}

		return team_id;
	}

	public List<wrapper> getcount(int project_id) throws Exception {

		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = " ";

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"Select count(proposal_task.task_id) proposal_task_count,SUM(proposal_task.estimated_hours) estimated_hrscount from proposal_task where project_id = '"
						+ project_id + "'");

		while (rs.next()) {

			wrapper obj = new wrapper();

			obj.setProposal_task_count(rs.getInt("proposal_task_count"));
			obj.setEstimated_hrscount(rs.getInt("estimated_hrscount"));
			list.add(obj);

		}

		return list;
	}

	public String get_featurebased_count(int project_id, proposaltasks_vo taskgp) throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = " ";

		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"Select count(proposal_task.task_id) proposal_task_count,SUM(proposal_task.estimated_hours) estimated_hrscount from proposal_task where project_id = '"
						+ project_id + "' AND feature_id = '" + taskgp.getFeature_id() + "'");

		while (rs.next()) {

			wrapper obj = new wrapper();

			obj.setProposal_task_count(rs.getInt("proposal_task_count"));
			obj.setEstimated_hrscount(rs.getInt("estimated_hrscount"));
			list.add(obj);

		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);

		return json;
	}

	public List<wrapper> getestimated_hrs() throws Exception {
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"Select category_code.cat_cde,category_value.value_name from category_value INNER JOIN category_code ON category_code.cat_cde = category_value.cat_cde where category_code.cat_active_ind = '6' ORDER BY category_code.cat_cde");

		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setCategory_code(rs.getString("cat_cde"));
			obj.setCategory_value(rs.getString("value_name"));
			list.add(obj);
		}

		return list;
	}

public List<wrapper> getmyproposals(int userid,int project_id) throws Exception {
		
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		String json = "";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();

		ResultSet rs = stmt.executeQuery(
				"select member.user_id,team.team_id,team.token,team.project_id,project.projectname,project.description from member inner join team on team.team_id=member.team_id inner join project on project.project_id=team.project_id  where member.user_id='"+userid+"' AND team.project_id = '"+project_id+"'");

		while (rs.next()) {
			wrapper obj = new wrapper();
			obj.setProject_id(rs.getInt("project_id"));
			obj.setProject_name(rs.getString("projectname"));
			obj.setDes(rs.getString("description"));
			obj.setToken(rs.getString("token"));
			
			list.add(obj);
		}

		
		return list;
		
		
	}

  public String getmember_rateandcode(int user_id) throws Exception {
	conn = connectionDB.getConnection();
	Statement stmt = conn.createStatement();
	String json = "";
	List<wrapper> list = new ArrayList<wrapper>();
	list.clear();
	ResultSet rs = stmt.executeQuery(
			"select rate,member_type_code from member where  member.user_id= '"+user_id+"'");
	while (rs.next()) {
		wrapper obj = new wrapper();
		obj.setRate(rs.getInt("rate"));
		obj.setMember_type_code(rs.getString("member_type_code"));
		
		list.add(obj);
	}

	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	json = gson.toJson(list);

	return json;
}

   public int getprojectid(String token) throws Exception {
		
		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		int project_id=0;
		ResultSet rs = stmt.executeQuery("select project_id from team where token='"+token+"'");
		while (rs.next()) {
			 project_id=rs.getInt("project_id");
		}
		return project_id;
	}

    public void submit_proposal(int project_id, int team_id) throws Exception {
    	
    	conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
    	String status_code = null;
		ResultSet rs1 = stmt.executeQuery(
				"select status_code from status_type where status_group_code = 2 and status_name = 'Submitted'");
		while (rs1.next()) {
			status_code = rs1.getString("status_code");
		}
    	String submitProposal = "update team set status_code = '"+status_code+"' where project_id='"+project_id+"' AND team_id='"+team_id+"'"; 
		jdbctemplate.execute(submitProposal);
}

	public List<wrapper> getmyproposals(int userid) throws Exception {
		String sql="select user.username,member.user_id,team.team_id,team.token,team.project_id,project.projectname,project.description from member inner join team on team.team_id=member.team_id inner join project on project.project_id=team.project_id inner join user on user.user_id=member.user_id where member.user_id=1";
        List<wrapper> list= new ArrayList<wrapper>();
        List<Map<String, Object>> rows =getJdbctemplate().queryForList(sql);
        for (Map row : rows) {
            wrapper obj = new wrapper();
            obj.setProject_name((String)(row.get("projectname")));
            obj.setDes((String)(row.get("description")));
            obj.setToken((String)(row.get("token")));
            list.add(obj);
        }
        return list;
	}
}
