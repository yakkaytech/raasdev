package com.vo;

import java.util.List;

public class user_vo {

	public user_vo() {

	}

	private String Breif_education;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBreif_education() {
		return Breif_education;
	}

	public void setBreif_education(String breif_education) {
		Breif_education = breif_education;
	}

	private String topskill;
	private String select2_Country;
	private String select2_StateZone;
	private String select2_TimeZone;
	private String idRate;
	private String select2_Hour;
	private List<Integer> checkboxes;
	private String dropstate;

<<<<<<< HEAD
	public String getDropstate() {
		return dropstate;
	}

	public void setDropstate(String dropstate) {
		this.dropstate = dropstate;
	}

	public user_vo(String breif_education, String description, String topskill, String select2_Country,
			String select2_StateZone, String select2_TimeZone, String idRate, String select2_Hour,
			List<Integer> checkboxes) {
=======



	public String getDropstate() {
		return dropstate;
	}
	public void setDropstate(String dropstate) {
		this.dropstate = dropstate;
	}	
		
	

  
	

	

	

	

	public user_vo(String breif_education, String description, String topskill, String select2_Country,
			String select2_StateZone, String select2_TimeZone, String idRate, String select2_Hour, List<Integer> checkboxes) {
>>>>>>> raasmain
		super();
		Breif_education = breif_education;
		this.description = description;
		this.topskill = topskill;
		this.select2_Country = select2_Country;
		this.select2_StateZone = select2_StateZone;
		this.select2_TimeZone = select2_TimeZone;
		this.idRate = idRate;
		this.select2_Hour = select2_Hour;
		this.checkboxes = checkboxes;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "user_vo [Breif_education=" + Breif_education + ", description=" + description + ", topskill=" + topskill
				+ ", select2_Country=" + select2_Country + ", select2_StateZone=" + select2_StateZone
=======
		return "user_vo [Breif_education=" + Breif_education + ", description=" + description + ", topskill="
				+ topskill + ", select2_Country=" + select2_Country + ", select2_StateZone=" + select2_StateZone
>>>>>>> raasmain
				+ ", select2_TimeZone=" + select2_TimeZone + ", idRate=" + idRate + ", select2_Hour=" + select2_Hour
				+ ", checkboxes=" + checkboxes + "]";
	}

	public List<Integer> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(List<Integer> checkboxes) {
		this.checkboxes = checkboxes;
	}

	public String getTopskill() {
		return topskill;
	}

	public void setTopskill(String topskill) {
		this.topskill = topskill;
	}

	public String getSelect2_Country() {
		return select2_Country;
	}

	public void setSelect2_Country(String select2_Country) {
		this.select2_Country = select2_Country;
	}

	public String getSelect2_StateZone() {
		return select2_StateZone;
	}

	public void setSelect2_StateZone(String select2_StateZone) {
		this.select2_StateZone = select2_StateZone;
	}

	public String getSelect2_TimeZone() {
		return select2_TimeZone;
	}

	public void setSelect2_TimeZone(String select2_TimeZone) {
		this.select2_TimeZone = select2_TimeZone;
	}

	public String getIdRate() {
		return idRate;
	}

	public void setIdRate(String idRate) {
		this.idRate = idRate;
	}

	public String getSelect2_Hour() {
		return select2_Hour;
	}

	public void setSelect2_Hour(String select2_Hour) {
		this.select2_Hour = select2_Hour;
	}

}