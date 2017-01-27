package com.vo;

import java.util.Date;

public class team_vo {
	
	
	
	private int team_id;
	private int project_id;
	private String team_name;
	private int member_id;
	private int rate;
	private String key;
	private String user_id;
	private int active_ind;
	private int assigned_ind;
	private int user_group_id;
	private Date date_added;
	
	public team_vo() {
	};
	
	public team_vo(int team_id, int project_id, String team_name, int member_id, int rate, String key, String user_id,
			int active_ind, int assigned_ind, int user_group_id, Date date_added) {
		super();
		this.team_id = team_id;
		this.project_id = project_id;
		this.team_name = team_name;
		this.member_id = member_id;
		this.rate = rate;
		this.key = key;
		this.user_id = user_id;
		this.active_ind = active_ind;
		this.assigned_ind = assigned_ind;
		this.user_group_id = user_group_id;
		this.date_added = date_added;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getActive_ind() {
		return active_ind;
	}
	public void setActive_ind(int active_ind) {
		this.active_ind = active_ind;
	}
	public int getAssigned_ind() {
		return assigned_ind;
	}
	public void setAssigned_ind(int assigned_ind) {
		this.assigned_ind = assigned_ind;
	}
	public int getUser_group_id() {
		return user_group_id;
	}
	public void setUser_group_id(int user_group_id) {
		this.user_group_id = user_group_id;
	}
	public Date getDate_added() {
		return date_added;
	}
	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	
	
	
	

}
