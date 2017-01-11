package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.vo.feature_vo;
import com.vo.projectTasksgp_vo;
import com.wrapper.wrapper;

public interface feature_dao {

	List<wrapper> getfeaturesets(int project_id) throws Exception;

	String addfeature(feature_vo ptv, String userName, String token, int project_id) throws Exception;


	String loadeditgroup(int feature_id) throws  Exception;

	String managefeature(feature_vo tasks, int project_id) throws Exception;

	String removefeature(int feature_id, int project_id) throws Exception;

	List<wrapper> getfeaturepro_sets(int project_id) throws Exception;

}
