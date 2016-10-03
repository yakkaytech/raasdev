package com.wrapper;

<<<<<<< HEAD
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class wrapper {

	private String checkbox;
	private String name;
	private String des;
=======

public class wrapper {

	private String checkbox ;
	private String name ;
	private String des ;
>>>>>>> raasmain
	private String country_name;
	private String state_name;
	private int state_id;
	private int timezone_id;
	private String timezone_name;
	private int country_id;
	private String iso_code_2;
	private String project_type;
	private int project_id;
<<<<<<< HEAD
	private String task_group_name;
	private int task_group_id;
	private String task_type_name;
	private int task_type_id;
	private String task_size_name;
	private int task_size_hrs;
	private Integer task_id;
	private String task_name;
	private String task_size_code;
	private String task_description;
	private String task_signoff_criteria;
	private String task_status;
	private String task_AssignedTo;
	private int tasks_cnt_pergp;
	private Date date_begin;
	private Date date_end;
	private int doc_id;
	private String file_name;
	private String project_name;
	private String project_desc;
	private int user_id;
	private int project_type_id;
	private String project_type_name;
	private int role_id;
	private String role_name;
	private String category_code;
	private String category_name;
	private String jobtype;
	private String jobname;
	private String job_desc;
	private int rate;
	private int rate_min;
	private int rate_max;
	private Date ror_enddate;
	private String Frequency;
	private int no_of_occurrence;
	private int project_role_id;
	
	

	public int getProject_role_id() {
		return project_role_id;
	}

	public void setProject_role_id(int project_role_id) {
		this.project_role_id = project_role_id;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getProject_type_name() {
		return project_type_name;
	}

	public void setProject_type_name(String project_type_name) {
		this.project_type_name = project_type_name;
	}

	public int getProject_type_id() {
		return project_type_id;
	}

	public void setProject_type_id(int project_type_id) {
		this.project_type_id = project_type_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_desc() {
		return project_desc;
	}

	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}
=======
	

	
	

>>>>>>> raasmain

	public String getProject_type() {
		return project_type;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public int getProject_id() {
		return project_id;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public String getIso_code() {
		return iso_code_2;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setIso_code(String iso_code_2) {
		this.iso_code_2 = iso_code_2;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public int getCountry_id() {
		return country_id;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public int getTimezone_id() {
		return timezone_id;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setTimezone_id(int timezone_id) {
		this.timezone_id = timezone_id;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public String getTimezone_name() {
		return timezone_name;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setTimezone_name(String timezone_name) {
		this.timezone_name = timezone_name;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public String getState_name() {
		return state_name;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public int getState_id() {
		return state_id;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

<<<<<<< HEAD
=======


>>>>>>> raasmain
	public String getCountry_name() {
		return country_name;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getCheckbox() {
		return checkbox;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public String getName() {
		return name;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setName(String name) {
		this.name = name;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public String getDes() {
		return des;
	}

<<<<<<< HEAD
=======

>>>>>>> raasmain
	public void setDes(String des) {
		this.des = des;
	}

<<<<<<< HEAD
	public wrapper() {

	}

	public void settask_group_name(String task_group_name) {

		this.task_group_name = task_group_name;
		// TODO Auto-generated method stub
		System.out.println("inside set task" + task_group_name);

	}

	public String gettask_group_name() {
		return task_group_name;
	}

	public void settask_group_id(int task_group_id) {
		this.task_group_id = task_group_id;
		System.out.println("inside set task" + task_group_name);

	}

	public Integer gettask_group_id() {
		return task_group_id;
	}

	public void settask_type_name(String task_type_name) {
		this.task_type_name = task_type_name;

	}

	public String gettask_type_name() {
		return task_type_name;
	}

	public void setTask_type_id(int task_type_id) {
		this.task_type_id = task_type_id;
	}

	public Integer getTask_type_id() {
		return task_type_id;
	}

	public void settask_size_hrs(int task_size_hrs) {
		this.task_size_hrs = task_size_hrs;

	}

	public Integer gettask_size_hrs() {
		return task_size_hrs;
	}

	public void settask_id(Integer task_id) {
		this.task_id = task_id;

	}

	public Integer gettask_id() {
		return task_id;
	}

	public void settask_name(String task_name) {
		this.task_name = task_name;

	}

	public String gettask_name() {
		return task_name;
	}

	public void settask_description(String task_description) {
		this.task_description = task_description;

	}

	public String gettask_description() {
		return task_description;
	}

	public String getIso_code_2() {
		return iso_code_2;
	}

	public void setIso_code_2(String iso_code_2) {
		this.iso_code_2 = iso_code_2;
	}

	public String getTask_group_name() {
		return task_group_name;
	}

	public void setTask_group_name(String task_group_name) {
		this.task_group_name = task_group_name;
	}

	public int getTask_size_hrs() {
		return task_size_hrs;
	}

	public void setTask_size_hrs(int task_size_hrs) {
		this.task_size_hrs = task_size_hrs;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public String getTask_signoff_criteria() {
		return task_signoff_criteria;
	}

	public void setTask_signoff_criteria(String task_signoff_criteria) {
		this.task_signoff_criteria = task_signoff_criteria;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public String getTask_AssignedTo() {
		return task_AssignedTo;
	}

	public void setTask_AssignedTo(String task_AssignedTo) {
		this.task_AssignedTo = task_AssignedTo;
	}

	public String getTask_size_name() {
		return task_size_name;
	}

	public void setTask_size_name(String task_size_name) {
		this.task_size_name = task_size_name;
	}

	public String gettask_size_code() {
		return task_size_code;
	}

	public void settask_size_code(String task_size_code) {
		this.task_size_code = task_size_code;
	}

	public void settasks_cnt_pergp(int tasks_cnt_pergp) {
		this.tasks_cnt_pergp = tasks_cnt_pergp;

	}

	public Integer gettasks_cnt_pergp() {
		return tasks_cnt_pergp;
	}

	public Date getDate_begin() {
		return date_begin;
	}

	public void setDate_begin(Date date_begin) {
		this.date_begin = date_begin;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public int getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public int getRate_min() {
		return rate_min;
	}

	public void setRate_min(int rate_min) {
		this.rate_min = rate_min;
	}

	public Date getRor_enddate() {
		return ror_enddate;
	}

	public void setRor_enddate(Date ror_enddate) {
		this.ror_enddate = ror_enddate;
	}

	public String getFrequency() {
		return Frequency;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getJob_desc() {
		return job_desc;
	}

	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getRate_max() {
		return rate_max;
	}

	public void setRate_max(int rate_max) {
		this.rate_max = rate_max;
	}

	public void setFrequency(String frequency) {
		Frequency = frequency;
	}

	public int getNo_of_occurrence() {
		return no_of_occurrence;
	}

	public void setNo_of_occurrence(int no_of_occurrence) {
		this.no_of_occurrence = no_of_occurrence;
	}
    
	
=======

	public wrapper() {

	}

>>>>>>> raasmain
}
