package com.vo;

import java.util.List;

public class projectTasksgp_vo {
	
	private String task_group_name;
	private int task_group_id;
	private int project_id;
	private int tasks_cnt_pergp;
	
	public projectTasksgp_vo(){}

	@Override
	public String toString() {
		return "projectTasks_vo [task_group_name=" + task_group_name + "]";
	}

	public projectTasksgp_vo(String task_group_name) {
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
	};
	
	

}
