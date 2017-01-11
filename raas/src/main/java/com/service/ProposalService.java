package com.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vo.ProposalTasksVO;
import com.vo.projectTasks_vo;
import com.wrapper.wrapper;

public interface ProposalService {

	void addTask(ProposalTasksVO taskdetails, MultipartFile file, int project_id, String token, String fileName,
			long filesize) throws Exception;

	List<wrapper> gettaskdetails(int project_id) throws Exception;

	String getproposalviewdetails(ProposalTasksVO ptv) throws Exception;

	List<wrapper> getproposalfirstviewdetails(int project_id) throws Exception;

	String getfeatureviewdetails(int project_id, ProposalTasksVO taskgp) throws Exception;

	List<wrapper> getteamdetails(int project_id) throws Exception;

	String editproposaltaskdetails(ProposalTasksVO ptv, MultipartFile file) throws Exception;

	int getteam_id(int project_id, String username) throws Exception;

	List<wrapper> getcount(int project_id) throws Exception;

	String get_featurebased_count(int project_id, ProposalTasksVO taskgp) throws Exception;

	List<wrapper> getestimated_hrs() throws Exception;

	void getmyproposals(int userid)throws Exception;

}
