package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TeamDAO;
import com.dao.projectteam_dao;
import com.service.teamService;
import com.vo.team_vo;
import com.wrapper.wrapper;

@Service
public class teamServiceImpl implements teamService{
	
	@Autowired
	projectteam_dao prjtteam_dao;
	
	@Autowired
	TeamDAO teamdao;
	
	

	public String createteam(int project_id,team_vo team,String token) throws Exception {
		
		return  teamdao.createTeam(project_id,team,token);
	}

	public String addMember() {
		return prjtteam_dao.addMember();
	}

	public String removeMember() {
		return prjtteam_dao.removeMember();
	}

	public String getTeamMembers() {
		return prjtteam_dao.getTeamMembers();
	}

	public String getActiveTeamMembers() {
		return prjtteam_dao.getActiveTeamMembers();
	}

	public void addmember(team_vo team) {
		teamdao.addmember(team);
		
	}

	

}
