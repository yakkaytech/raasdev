package com.vo;

import java.util.Date;

public class projectrole_vo {
	
	private int project_role_id;
	private int project_id;
	private int role_id;
	private String name;
	private String additional_desc;
	private int rate;
	private int rate_min;
	private int rate_max;
	private int frequency_code;
	private int hours_per_occurrence;
	private int ror_code;
	private int ror_occurrence_nbr;
	private Date ror_end_date;
	private Date date_added;
	private String jobname;
	private String jobtype;
	private String category_code;
	private String category_name;
	
	
	
	
	
	
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
	public String getJobtype() {
		return jobtype;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public int getProject_role_id() {
		return project_role_id;
	}
	public void setProject_role_id(int project_role_id) {
		this.project_role_id = project_role_id;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdditional_desc() {
		return additional_desc;
	}
	public void setAdditional_desc(String additional_desc) {
		this.additional_desc = additional_desc;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getRate_min() {
		return rate_min;
	}
	public void setRate_min(int rate_min) {
		this.rate_min = rate_min;
	}
	public int getRate_max() {
		return rate_max;
	}
	public void setRate_max(int rate_max) {
		this.rate_max = rate_max;
	}
	public int getFrequency_code() {
		return frequency_code;
	}
	public void setFrequency_code(int frequency_code) {
		this.frequency_code = frequency_code;
	}
	public int getHours_per_occurrence() {
		return hours_per_occurrence;
	}
	public void setHours_per_occurrence(int hours_per_occurrence) {
		this.hours_per_occurrence = hours_per_occurrence;
	}
	public int getRor_code() {
		return ror_code;
	}
	public void setRor_code(int ror_code) {
		this.ror_code = ror_code;
	}
	public int getRor_occurrence_nbr() {
		return ror_occurrence_nbr;
	}
	public void setRor_occurrence_nbr(int ror_occurrence_nbr) {
		this.ror_occurrence_nbr = ror_occurrence_nbr;
	}
	public Date getRor_end_date() {
		return ror_end_date;
	}
	public void setRor_end_date(Date ror_end_date) {
		this.ror_end_date = ror_end_date;
	}
	public Date getDate_added() {
		return date_added;
	}
	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}
	
	
	
	

}
