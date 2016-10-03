package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.common_dao;
import com.dao.crtproject_dao;
import com.service.projectTasks_service;
import com.vo.crtproject_vo;
import com.vo.projectTasksgp_vo;

@Controller

public class user_projectcontroller {

	@Autowired
	private crtproject_dao crtdao;
	@Autowired
	private projectTasks_service taskgroupservice;

	public crtproject_dao getCrtdao() {
		return crtdao;
	}

	public void setCrtdao(crtproject_dao crtdao) {
		this.crtdao = crtdao;
	}

	public projectTasks_service getTaskgroupservice() {
		return taskgroupservice;
	}

	public void setTaskgroupservice(projectTasks_service taskgroupservice) {
		this.taskgroupservice = taskgroupservice;
	}

	@RequestMapping(value = "/projectlist", method = { RequestMethod.GET, RequestMethod.POST })

	public String projectlist(crtproject_vo crt, Principal principal, Model model) throws Exception {

		String username = principal.getName();
		model.addAttribute("userproject", crtdao.getuserproupdate(crt, username));
		return "/project/projectlist";

	}

	@RequestMapping(value = "/check", method = { RequestMethod.GET, RequestMethod.POST })

	public String checkuser(crtproject_vo crt, Principal principal, Model model) throws Exception {

		String username = principal.getName();
		crtdao.getuserprojectid(crt, username);
		return "/project/projectlist";

	}

}
