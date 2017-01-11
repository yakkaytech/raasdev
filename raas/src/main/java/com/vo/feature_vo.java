package com.vo;

import java.util.Date;

public class feature_vo {
	
	private int feature_id;
	private String feature_name;
	private int project_id;
	private int tasks_cnt_pergp;
	private String feature_description;
	private String feature_signoff_criteria;
	private String priority_code;
	private String priority_code_name;
	private String key;
	private Date due_date;
	private Date date_added;
	private Date date_modified;
	private int created_by;
	private int updated_by;
	
	
	public feature_vo(){}
	
	
	public feature_vo(int feature_id, String name, int project_id, int tasks_cnt_pergp, String description,
			String signoff_criteria, String priority_code, String priority_code_name, String key, Date due_date,
			Date date_added, Date date_modified, int created_by, int updated_by) {
		super();
		this.feature_id = feature_id;
		this.feature_name = feature_name;
		this.project_id = project_id;
		this.tasks_cnt_pergp = tasks_cnt_pergp;
		this.feature_description = feature_description;
		this.feature_signoff_criteria = feature_signoff_criteria;
		this.priority_code = priority_code;
		this.priority_code_name = priority_code_name;
		this.key = key;
		this.due_date = due_date;
		this.date_added = date_added;
		this.date_modified = date_modified;
		this.created_by = created_by;
		this.updated_by = updated_by;
	}


	
	public int getFeature_id() {
		return feature_id;
	}
	public void setFeature_id(int feature_id) {
		this.feature_id = feature_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getTasks_cnt_pergp() {
		return tasks_cnt_pergp;
	}
	public void setTasks_cnt_pergp(int tasks_cnt_pergp) {
		this.tasks_cnt_pergp = tasks_cnt_pergp;
	}
	
	public String getPriority_code() {
		return priority_code;
	}
	public void setPriority_code(String priority_code) {
		this.priority_code = priority_code;
	}
	public String getPriority_code_name() {
		return priority_code_name;
	}
	public void setPriority_code_name(String priority_code_name) {
		this.priority_code_name = priority_code_name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getDate_added() {
		return date_added;
	}
	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	public Date getDate_modified() {
		return date_modified;
	}
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public int getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}


	public String getFeature_name() {
		return feature_name;
	}


	public void setFeature_name(String feature_name) {
		this.feature_name = feature_name;
	}


	public String getFeature_description() {
		return feature_description;
	}


	public void setFeature_description(String feature_description) {
		this.feature_description = feature_description;
	}


	public String getFeature_signoff_criteria() {
		return feature_signoff_criteria;
	}


	public void setFeature_signoff_criteria(String feature_signoff_criteria) {
		this.feature_signoff_criteria = feature_signoff_criteria;
	}

	
	
	

}
