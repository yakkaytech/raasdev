package com.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.ProposalDAO;
import com.service.ProposalService;
import com.vo.ProposalTasksVO;
import com.vo.projectTasks_vo;
import com.wrapper.wrapper;

@Service
public class ProposalServiceImpl implements ProposalService{
	
	@Autowired
	ProposalDAO proposaldao;

	public void addTask(ProposalTasksVO taskdetails, MultipartFile file, int project_id,String token,String fileName, long filesize) throws Exception {
		proposaldao.addTask(taskdetails,file,project_id,token, fileName,  filesize);
		
	}

	public List<wrapper> gettaskdetails(int project_id) throws Exception {
		return proposaldao.gettaskdetails(project_id);
	}

	public String getproposalviewdetails(ProposalTasksVO ptv) throws Exception {
		return proposaldao.getproposalviewdetails(ptv);
	}

	public List<wrapper> getproposalfirstviewdetails(int project_id) throws Exception {
		return proposaldao.getproposalfirstviewdetails(project_id);
	}

	public String getfeatureviewdetails(int project_id, ProposalTasksVO taskgp) throws Exception {
		return proposaldao.getfeatureviewdetails(project_id,taskgp);
	}

	public List<wrapper> getteamdetails(int team_id) throws Exception {
		return proposaldao.getteamdetails(team_id);
	}

	public String editproposaltaskdetails(ProposalTasksVO ptv, MultipartFile file) throws Exception {
		return proposaldao.editproposaltaskdetails(ptv,file);
	}

	public int getteam_id(int project_id, String username) throws Exception {
		return proposaldao.getteam_id(project_id,username);
	}

	public List<wrapper> getcount(int project_id) throws Exception {
		return proposaldao.getcount(project_id);
	}

	public String get_featurebased_count(int project_id, ProposalTasksVO taskgp) throws Exception {
		return proposaldao.get_featurebased_count(project_id,taskgp);
	}

	public List<wrapper> getestimated_hrs() throws Exception {
		
		return proposaldao.getestimated_hrs();
	}

	public void getmyproposals(int userid) throws Exception {
		// TODO Auto-generated method stub
		proposaldao.getmyproposals(userid);
	}



}
