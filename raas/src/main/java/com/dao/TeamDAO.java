package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.vo.team_vo;
import com.wrapper.wrapper;

public interface TeamDAO {

	String createTeam(int project_id, team_vo team, String token) throws Exception;

	void addmember(team_vo team);

}
