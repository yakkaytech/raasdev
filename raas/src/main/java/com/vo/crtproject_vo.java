package com.vo;

import java.util.List;

public class crtproject_vo {

	private String project_type;
	private String project_name;
	private String project_desc;
	private String skill;
	private List<Integer> checkboxes;
	private List<String> names;
	private List<Integer> quantity;
	private String country;
	private String zone;
	private String timezone;
	private int project_id;

	public crtproject_vo() {
	};

	@Override
	public String toString() {
		return "crtproject_vo [project_type=" + project_type + ", project_name=" + project_name + ", skill=" + skill
				+ ",names=" + names + ", quantity=" + quantity + ",country=" + country + ",zone=" + zone + ", timezone="
				+ timezone + ", checkboxes=" + checkboxes + "]";
	}

	public crtproject_vo(String project_type, String project_name, String project_desc, String skill,
			List<Integer> checkboxes, List<String> names, List<Integer> quantity, String country, String zone,
			String timezone) {
		super();
		this.project_type = project_type;
		this.project_name = project_name;
		this.project_desc = project_desc;
		this.skill = skill;
		this.checkboxes = checkboxes;
		this.names = names;
		this.quantity = quantity;
		this.country = country;
		this.zone = zone;
		this.timezone = timezone;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public String getProject_type() {
		return project_type;
	}

	public void setProject_type(String project_type) {
		this.project_type = project_type;
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

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public List<Integer> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(List<Integer> checkboxes) {
		this.checkboxes = checkboxes;
	}

	public List<Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
}
