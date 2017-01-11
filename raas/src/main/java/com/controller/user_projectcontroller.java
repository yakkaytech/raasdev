package com.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.crtproject_dao;
import com.service.projectTasks_service;
import com.vo.crtproject_vo;

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

	// display projectlist
	@RequestMapping(value = "/projectlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String projectlist(crtproject_vo crt, Principal principal, Model model, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession(true);
		String userName = principal.getName();
		String username = principal.getName();
		session.setAttribute("user", userName);
		model.addAttribute("userproject", crtdao.getuserproupdate(crt, username));
		return "/project/projectlist";

	}

	@RequestMapping(value = "/check", method = { RequestMethod.GET, RequestMethod.POST })
	public String checkuser(crtproject_vo crt, Principal principal, Model model) throws Exception {
		String username = principal.getName();
		crtdao.getuserprojectid(crt, username);
		return "/project/projectlist";

	}

	@RequestMapping(value = "/membernew", method = { RequestMethod.GET, RequestMethod.POST })
	public String membernew(crtproject_vo crt, Principal principal, Model model) throws Exception {
		String username = principal.getName();
		crtdao.getuserprojectid(crt, username);
		return "/member/membernew";

	}

	@RequestMapping(value = "/Newmember", method = { RequestMethod.GET, RequestMethod.POST })
	public String Newmember(crtproject_vo crt, Principal principal, Model model) throws Exception {
		String username = principal.getName();
		crtdao.getuserprojectid(crt, username);
		return "/member/Newmember";

	}

}
