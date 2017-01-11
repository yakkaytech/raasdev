package com.vo;

import java.util.Date;

public class memberRequest_vo {
	
	
	private int request_id;
	private int team_id;
	private String firstname;
	private String lastname;
	private String email;
	private int team_key;
	private int request_key;
	private int user_id;
	private int project_role_id;
	private int rate;
	private int frequency_code;
	private int hours_per_occurrence;
	private int ror_code;
	private int ror_occurrence_nbr; 
	private Date ror_end_date;
	private Date date_added;
	private int project_id;
	
	
	
	public memberRequest_vo() {
	};

	
	
	
	public memberRequest_vo(int request_id, int team_id, String firstname, String lastname, int team_key,
			int request_key, int user_id, int project_role_id, int rate, int frequency_code, int hours_per_occurrence,
			int ror_code, int ror_occurrence_nbr, Date ror_end_date, Date date_added) {
		super();
		this.request_id = request_id;
		this.team_id = team_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.team_key = team_key;
		this.request_key = request_key;
		this.user_id = user_id;
		this.project_role_id = project_role_id;
		this.rate = rate;
		this.frequency_code = frequency_code;
		this.hours_per_occurrence = hours_per_occurrence;
		this.ror_code = ror_code;
		this.ror_occurrence_nbr = ror_occurrence_nbr;
		this.ror_end_date = ror_end_date;
		this.date_added = date_added;
	}
	
	
	
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getTeam_key() {
		return team_key;
	}
	public void setTeam_key(int team_key) {
		this.team_key = team_key;
	}
	public int getRequest_key() {
		return request_key;
	}
	public void setRequest_key(int request_key) {
		this.request_key = request_key;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProject_role_id() {
		return project_role_id;
	}
	public void setProject_role_id(int project_role_id) {
		this.project_role_id = project_role_id;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	
	
	

}
