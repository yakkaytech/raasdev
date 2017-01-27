package com.vo;

import java.util.Date;

public class proposaltasks_vo {
	
	
	private int task_id;
	private int team_id;
	private int feature_id;
	private int task_type_id;
	private int owner_member_id;
	private String task_name;
	private String description;
	private String signoff_criteria;
	private int estimated_hours;
	private Date due_date;
	private int sort_order;
	private String size_code;
	private String token;
	private Date date_added;
	private int attachment_id;
	private int project_id;
	
	public proposaltasks_vo(){
		
		
	};
	
	
	public proposaltasks_vo(int task_id, int team_id, int feature_id, int task_type_id, int owner_member_id,
			String task_name, String description, int estimated_hours, Date due_date, int sort_order, String size_code,
			String token, Date date_added, int attachment_id) {
		super();
		this.task_id = task_id;
		this.team_id = team_id;
		this.feature_id = feature_id;
		this.task_type_id = task_type_id;
		this.owner_member_id = owner_member_id;
		this.task_name = task_name;
		this.description = description;
		this.estimated_hours = estimated_hours;
		this.due_date = due_date;
		this.sort_order = sort_order;
		this.size_code = size_code;
		this.token = token;
		this.date_added = date_added;
		this.attachment_id = attachment_id;
	}
	
	
	
	public int getProject_id() {
		return project_id;
	}


	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}


	public String getSignoff_criteria() {
		return signoff_criteria;
	}


	public void setSignoff_criteria(String signoff_criteria) {
		this.signoff_criteria = signoff_criteria;
	}


	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public int getFeature_id() {
		return feature_id;
	}
	public void setFeature_id(int feature_id) {
		this.feature_id = feature_id;
	}
	public int getTask_type_id() {
		return task_type_id;
	}
	public void setTask_type_id(int task_type_id) {
		this.task_type_id = task_type_id;
	}
	public int getOwner_member_id() {
		return owner_member_id;
	}
	public void setOwner_member_id(int owner_member_id) {
		this.owner_member_id = owner_member_id;
	}
	public String getTask_name() {
		return task_name;
	}
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getEstimated_hours() {
		return estimated_hours;
	}
	public void setEstimated_hours(int estimated_hours) {
		this.estimated_hours = estimated_hours;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	public String getSize_code() {
		return size_code;
	}
	public void setSize_code(String size_code) {
		this.size_code = size_code;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getDate_added() {
		return date_added;
	}
	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	public int getAttachment_id() {
		return attachment_id;
	}
	public void setAttachment_id(int attachment_id) {
		this.attachment_id = attachment_id;
	}

}
