package com.service;

import java.util.List;

import com.vo.team_vo;
import com.wrapper.wrapper;

public interface teamService {

	String createteam(int project_id, team_vo team, String token) throws Exception;

	String addMember();

	String removeMember();

	String getTeamMembers();

	String getActiveTeamMembers();

	void addmember(team_vo team);

}
