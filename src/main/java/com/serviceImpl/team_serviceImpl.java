package com.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.team_dao;
import com.dao.projectteam_dao;
import com.service.team_service;
import com.vo.team_vo;
import com.wrapper.wrapper;

@Service
public class team_serviceImpl implements team_service{
	
	@Autowired
	projectteam_dao projectteamDao;
	
	@Autowired
	team_dao teamDao;
	
	

	public String createteam(int project_id,team_vo team,String token) throws Exception {
		
		return  teamDao.createTeam(project_id,team,token);
	}

	public String addMember() {
		return projectteamDao.addMember();
	}

	public List<wrapper>  getteamstatus(int project_id, int team_id) throws Exception {
	  int flag=0;
	  List<wrapper> list=new ArrayList<wrapper>();
	  String status_code = teamDao.getteamstatus(project_id,team_id).get(0).getStatus_code();
	  wrapper obj = new wrapper();
      if(status_code.equals("O")){
          flag=0;
          obj.setStatusflag(flag);
          
      }else if(status_code.equals("S")){
          flag=1;
          obj.setStatusflag(flag);
          
      }
      list.add(obj);
      return list;
	}

	
	
	public String removeMember() {
		return projectteamDao.removeMember();
	}

	public String getTeamMembers() {
		return projectteamDao.getTeamMembers();
	}

	public String getActiveTeamMembers() {
		return projectteamDao.getActiveTeamMembers();
	}

	public void addmember(team_vo team) throws Exception {
		teamDao.addmember(team);
		
	}

	public String checkvalidmember(team_vo team, int project_id) throws Exception {
		
		return teamDao.checkvalidmember(team,project_id);
	}

	
	

}
