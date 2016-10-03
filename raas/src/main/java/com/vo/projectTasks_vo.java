package com.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class projectTasks_vo {
	
	private Integer task_id;
	private Integer task_group_id;
	private int task_type_id;
	private String task_type_name;
	private String task_name;
	private String description;
	private String signoff_criteria;
	private String size_code;
	private String task_AssignedTO;
	private String status;
	private String task_size_name;
	private String task_size_code;
	private String token;
	private Date date_added;
	private Date date_begin;
	private Date date_end;
	private Integer estimated_hours;
	private Integer role_id;
	private int project_id;
	private int doc_id;
	private MultipartFile file;
	private String file_name;
	private String fileSize;
	private String fileType;
	private byte[] bytes;
	
	
	
	
	
	public projectTasks_vo(){}	
	
	@Override
	public String toString() {
		return "projectTasks_vo [task_id=" + task_id + ", task_group_id=" + task_group_id + ", task_type_id="
				+ task_type_id + ", task_type_name=" + task_type_name + ", task_name=" + task_name + ", description="
				+ description + ", signoff_criteria=" + signoff_criteria + ", size_code=" + size_code
				+ ", task_size_name=" + task_size_name + ", task_size_code=" + task_size_code + ", token=" + token
				+ ", date_added=" + date_added + ", date_begin=" + date_begin + ", date_end=" + date_end
				+ ", estimated_hours=" + estimated_hours + ", role_id=" + role_id + ", project_id=" + project_id + "]";
	}
	
	

	public int getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public Integer gettask_group_id() {
		return task_group_id;
	}

	public void settask_group_id(Integer task_group_id) {
		this.task_group_id = task_group_id;
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

	public String getSignoff_criteria() {
		return signoff_criteria;
	}

	public void setSignoff_criteria(String signoff_criteria) {
		this.signoff_criteria = signoff_criteria;
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

	public Integer getEstimated_hours() {
		return estimated_hours;
	}

	public void setEstimated_hours(Integer estimated_hours) {
		this.estimated_hours = estimated_hours;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public int gettask_type_id() {
		return task_type_id;
	}

	public void settask_type_id(int task_type_id) {
		this.task_type_id = task_type_id;
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

	public String gettask_type_name() {
		return task_type_name;
	}

	public void settask_type_name(String task_type_name) {
		this.task_type_name = task_type_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTask_AssignedTO() {
		return task_AssignedTO;
	}

	public void setTask_AssignedTO(String task_AssignedTO) {
		this.task_AssignedTO = task_AssignedTO;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
    
	
}
