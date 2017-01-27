package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.vo.team_vo;
import com.wrapper.wrapper;

public interface team_dao {

	String createTeam(int project_id, team_vo team, String token) throws Exception;

	void addmember(team_vo team) throws Exception;

	List<wrapper> getteamstatus(int project_id, int team_id) throws Exception;

	String checkvalidmember(team_vo team, int project_id) throws Exception;

}
