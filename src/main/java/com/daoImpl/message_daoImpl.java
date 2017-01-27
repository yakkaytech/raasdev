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
public class message_daoImpl implements message_dao{
	
	private Connection conn;
	
//	public void messageactivity(message_vo msg,String username) throws Exception {
//		conn = connectionDB.getConnection();
//		Statement stmt = conn.createStatement();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
//		Date date = new Date();
//		dateFormat.format(date);
//		ResultSet user = stmt.executeQuery("select username,user_id,firstname from user where username='" + username + "'");
//		while (user.next()) {
//			username=user.getString("username");
//			user.getInt("user_id");
//			user.getString("firstname");
//			
//			
//		}		
		
	    public List<wrapper> userlist(String username,message_vo msg) throws Exception {
	    	
	    	conn = connectionDB.getConnection();
			Statement stmt = conn.createStatement();
			List<wrapper> list = new ArrayList<wrapper>();
			list.clear();
			
			ResultSet rs = stmt.executeQuery("select firstname from user where username='"+ username +"'");
			
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
			
			ResultSet rs = stmt.executeQuery("select firstname from participants where username='"+ username +"'");
			
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
			
			stmt.executeUpdate("DELETE FROM participants WHERE username='"+ username +"'");
						
			return list;
	    }
       
       public List<wrapper> message(message_vo msg,String username) throws Exception {
   		conn = connectionDB.getConnection();
   		Statement stmt = conn.createStatement();
   		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
   		String sysdate;
   		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		sysdate = dateFormat.format(date);
   		int user_id = 0;
   		String Firstname="";
   		sysdate = dateFormat.format(date);
   		ResultSet user = stmt.executeQuery("select username,user_id,firstname from user where username='" + username + "'");
   		while (user.next()) {
   			username=user.getString("username");
   			user_id = user.getInt("user_id");
   			Firstname=user.getString("firstname");			
   		}		
   		
   	 // insert messages table 
   		String messagequery = ("insert into messages(user_id,firstname,message,time,username,active_ind)values('" + user_id + "','"+ Firstname + "','" + msg.getMessages() +"','" + sysdate + "','"+username+"','1')");
   		
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
       
       public List<wrapper> messages(message_vo msg) throws Exception{
		
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
       
       public List<wrapper> SendMessage(message_vo msg,String username)throws Exception{
    	    conn = connectionDB.getConnection();
			Statement stmt = conn.createStatement();
			String sysdate;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	   		Date date = new Date();
	   		sysdate = dateFormat.format(date);
			List<wrapper> list = new ArrayList<wrapper>();
			list.clear();
			int user_id=0;
			int message_id=0;
			String text="";
			String Firstname="";
			String Lastname="";
			String subject="";
			
			//message table insertion
			
			String message=("insert into messagemail(action_type_code,text,email_ind,active_ind,date_added,subject,to_email_id)values('1','"+msg.getText()+"','1','1','"+sysdate+"','"+msg.getSubject()+"','"+msg.getTo_email_id()+"')");
			stmt.execute(message);
			//get details for message_logmail table
			
			ResultSet rs=stmt.executeQuery("SELECT messagemail.message_id,messagemail.text,messagemail.date_added,messagemail.subject,user.user_id,user.firstname,user.lastname FROM messagemail INNER JOIN user ON user.active_ind=messagemail.active_ind where username='"+username+"'");
			while (rs.next()) {
	   			user_id = rs.getInt("user_id");
	   			Firstname=rs.getString("firstname");			
	   			Lastname=rs.getString("lastname");
	   			message_id=rs.getInt("message_id");
	   			text=rs.getString("text");
	   			subject=rs.getString("subject");
	   		}		
			
			String msg_log=("insert into message_logmail(message_id,user_id,to_email_id,firstname,lastname,message_key,message_text,message_sent_ind,active_ind,date_added,created_by,subject)values('"+message_id+"','"+user_id+"','"+msg.getTo_email_id()+"','"+Firstname+"','"+Lastname+"','1','"+text+"','1','1','"+sysdate+"','"+username+"','"+subject+"')");
			stmt.execute(msg_log);
			
			return list;
		}
       
       public String getMessageById(Integer message_id) throws Exception{
    	   
    	    conn = connectionDB.getConnection();
			Statement stmt = conn.createStatement();
			String json="";
			List<wrapper> list = new ArrayList<wrapper>();
			list.clear();
				
			ResultSet msg_log = stmt.executeQuery("select message_id,message_text,date_added,created_by,to_email_id,subject from message_logmail where message_id='" + message_id + "'");
						
			while (msg_log.next()) {
				wrapper obj = new wrapper();
				
				obj.setMessage_id(msg_log.getInt("message_id"));
				obj.setMessage_text(msg_log.getString("message_text"));
				obj.setDate_added(msg_log.getDate("date_added"));
				obj.setCreated_by(msg_log.getString("created_by"));
				obj.setTo_email_id(msg_log.getString("to_email_id"));
				obj.setSubject(msg_log.getString("subject"));
				list.add(obj);
			}	
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			json = gson.toJson(list);
			return json;
		} 
       

   	public List<wrapper> getUserMessages(String username,message_vo msg) throws Exception{
   		
   		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
					 
		ResultSet rs = stmt.executeQuery("select a.message_text,a.message_id,a.firstname,a.to_email_id,a.date_added,a.created_by,a.subject,b.username from message_logmail a,user b where a.user_id=b.user_id and a.to_email_id='" + username + "'  ORDER BY DATE(a.date_added) DESC,a.date_added DESC");
				
		while(rs.next()){
		
		wrapper obj = new wrapper();
		obj.setUsername(rs.getString("username"));
		obj.setFirstname(rs.getString("firstname"));
		obj.setMessage_text(rs.getString("message_text"));
		obj.setMessage_id(rs.getInt("message_id"));
		obj.setFirstname(rs.getString("firstname"));
		obj.setTo_email_id(rs.getString("to_email_id"));
		obj.setDate_added(rs.getDate("date_added"));
		obj.setCreated_by(rs.getString("created_by"));
		obj.setSubject(rs.getString("subject"));
		list.add(obj);
	   }
		return list;
   	}
   	
   	public String deletemessage(int message_id,String username) throws Exception{
   		
   		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();   		
		String json="";
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
		
		int delete_msg=stmt.executeUpdate("delete from message_logmail where message_logmail.message_id='"+message_id+"'");
		
		
		ResultSet msg_log = stmt.executeQuery("select message_id,message_text,date_added,firstname,created_by,to_email_id,subject from message_logmail where  to_email_id ='"+username+"' ");
		
		while (msg_log.next()) {
			wrapper obj = new wrapper();
			obj.setMessage_id(msg_log.getInt("message_id"));
			obj.setMessage_text(msg_log.getString("message_text"));
			obj.setDate_added(msg_log.getDate("date_added"));
			obj.setCreated_by(msg_log.getString("created_by"));
			obj.setTo_email_id(msg_log.getString("to_email_id"));
			obj.setSubject(msg_log.getString("subject"));
			obj.setFirstname(msg_log.getString("firstname"));
			list.add(obj);
		}	
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		json = gson.toJson(list);
		return json;
   	
   	}
   	
        public List<wrapper> getUserMessagebycreated(String username) throws Exception{
   		
   		conn = connectionDB.getConnection();
		Statement stmt = conn.createStatement();
		List<wrapper> list = new ArrayList<wrapper>();
		list.clear();
					 
		ResultSet rs = stmt.executeQuery("select a.message_text,a.message_id,a.firstname,a.to_email_id,a.date_added,a.created_by,a.subject from message_logmail a,user b where a.user_id=b.user_id and a.created_by='" + username + "'  ORDER BY DATE(a.date_added) DESC,a.date_added DESC");
				
		while(rs.next()){
		
		wrapper obj = new wrapper();
		obj.setFirstname(rs.getString("firstname"));
		obj.setMessage_text(rs.getString("message_text"));
		obj.setMessage_id(rs.getInt("message_id"));
		obj.setFirstname(rs.getString("firstname"));
		obj.setTo_email_id(rs.getString("to_email_id"));
		obj.setDate_added(rs.getDate("date_added"));
		obj.setCreated_by(rs.getString("created_by"));
		obj.setSubject(rs.getString("subject"));
		list.add(obj);
	   }
		
		return list;
   	}


	public List<wrapper> messagedata(String username, message_vo msg) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
