package com.vo;

import java.util.Date;
import java.util.List;

public class projecttasksgp_vo {
	
	private String task_group_name;
	private int task_group_id;
	private int project_id;
	private int tasks_cnt_pergp;
	private String taskgp_description;
	private String priority_code;
	private String priority_code_name;
	private String taskgp_signoff_criteria;
	private Date date_added;
	private Date date_modified;
	private int created_by;
	private int updated_by;
	
	
	
	
	public projecttasksgp_vo(){}

	@Override
	public String toString() {
		return "projectTasks_vo [task_group_name=" + task_group_name + "]";
	}

	public projecttasksgp_vo(String task_group_name) {
		super();
		this.task_group_name = task_group_name;
	}

	public String gettask_group_name() {
		return task_group_name;
		
	}

	public void settask_group_name(String task_group_name) {
		this.task_group_name = task_group_name;
	}

	public int gettask_group_id() {
		return task_group_id;
	}

	public void settask_group_id(int task_group_id) {
		this.task_group_id = task_group_id;
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

	public String getTaskgp_description() {
		return taskgp_description;
	}

	public void setTaskgp_description(String taskgp_description) {
		this.taskgp_description = taskgp_description;
	}

	public String getPriority_code() {
		return priority_code;
	}

	public void setPriority_code(String priority_code) {
		this.priority_code = priority_code;
	}

	public String getTaskgp_signoff_criteria() {
		return taskgp_signoff_criteria;
	}

	public void setTaskgp_signoff_criteria(String taskgp_signoff_criteria) {
		this.taskgp_signoff_criteria = taskgp_signoff_criteria;
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

	public String getPriority_code_name() {
		return priority_code_name;
	}

	public void setPriority_code_name(String priority_code_name) {
		this.priority_code_name = priority_code_name;
	};
	
	

}
