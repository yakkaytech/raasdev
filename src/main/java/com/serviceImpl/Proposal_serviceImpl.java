package com.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.proposal_dao;
import com.service.proposal_service;
import com.vo.proposaltasks_vo;
import com.vo.projecttasks_vo;
import com.wrapper.wrapper;

@Service
public class Proposal_serviceImpl implements proposal_service{
	
	@Autowired
	proposal_dao proposalDao;

	public void addTask(proposaltasks_vo taskdetails, MultipartFile file, int project_id,String token,String fileName, long filesize) throws Exception {
		proposalDao.addTask(taskdetails,file,project_id,token, fileName,  filesize);
		
	}

	public List<wrapper> gettaskdetails(int project_id) throws Exception {
		return proposalDao.gettaskdetails(project_id);
	}

	public String getproposalviewdetails(proposaltasks_vo ptv) throws Exception {
		return proposalDao.getproposalviewdetails(ptv);
	}

	public List<wrapper> getproposalfirstviewdetails(int project_id) throws Exception {
		return proposalDao.getproposalfirstviewdetails(project_id);
	}

	public String getfeatureviewdetails(int project_id, proposaltasks_vo taskgp) throws Exception {
		return proposalDao.getfeatureviewdetails(project_id,taskgp);
	}

	public List<wrapper> getteamdetails(int team_id) throws Exception {
		return proposalDao.getteamdetails(team_id);
	}

	public String editproposaltaskdetails(proposaltasks_vo ptv, MultipartFile file) throws Exception {
		return proposalDao.editproposaltaskdetails(ptv,file);
	}

	public int getteam_id(int project_id, String username) throws Exception {
		return proposalDao.getteam_id(project_id,username);
	}

	public List<wrapper> getcount(int project_id) throws Exception {
		return proposalDao.getcount(project_id);
	}

	public String get_featurebased_count(int project_id, proposaltasks_vo taskgp) throws Exception {
		return proposalDao.get_featurebased_count(project_id,taskgp);
	}

	public List<wrapper> getestimated_hrs() throws Exception {
		
		return proposalDao.getestimated_hrs();
	}

	public List<wrapper>getmyproposals(int userid,int project_id) throws Exception {
		return proposalDao.getmyproposals(userid,project_id);
	}

	public String getmember_rateandcode(int user_id) throws Exception {
		return proposalDao.getmember_rateandcode(user_id);
	}

	public int getprojectid(String token) throws Exception {
		return proposalDao.getprojectid(token);
	}

	public void submit_proposal(int project_id, int team_id) throws Exception {
		proposalDao.submit_proposal(project_id,team_id);
		
	}

	public List<wrapper> getmyproposals(int userid) throws Exception {
		// TODO Auto-generated method stub
		return proposalDao.getmyproposals(userid);
	}


}
