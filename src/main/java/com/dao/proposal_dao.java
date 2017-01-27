package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vo.proposaltasks_vo;
import com.wrapper.wrapper;

public interface proposal_dao {

	void addTask(proposaltasks_vo taskdetails, MultipartFile file, int project_id, String token, String fileName, long filesize) throws Exception;

	List<wrapper> gettaskdetails(int project_id) throws Exception;

	String getproposalviewdetails(proposaltasks_vo ptv) throws Exception;

	List<wrapper> getproposalfirstviewdetails(int project_id) throws Exception;

	String getfeatureviewdetails(int project_id, proposaltasks_vo taskgp) throws Exception;

	List<wrapper> getteamdetails(int team_id) throws Exception;

	String editproposaltaskdetails(proposaltasks_vo ptv, MultipartFile file) throws Exception;

	int getteam_id(int project_id, String username) throws Exception;

	List<wrapper> getcount(int project_id) throws Exception;

	String get_featurebased_count(int project_id, proposaltasks_vo taskgp) throws Exception;

	List<wrapper> getestimated_hrs() throws Exception;

	List<wrapper> getmyproposals(int userid, int project_id)throws Exception;

	String getmember_rateandcode(int user_id) throws Exception;

	int getprojectid(String token)throws Exception;

	void submit_proposal(int project_id, int team_id) throws Exception;

	List<wrapper> getmyproposals(int userid)throws Exception;

}
