package com.service;

import java.util.List;

import com.vo.message_vo;
import com.wrapper.wrapper;

public interface message_service {

	void messageactivity(message_vo msg, String username) throws Exception;

	public List<wrapper> messagedata(String username, message_vo msg) throws Exception;

}
