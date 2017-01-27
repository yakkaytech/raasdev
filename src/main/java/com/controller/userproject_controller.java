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
import com.service.projecttasks_service;
import com.vo.crtproject_vo;

@Controller
public class userproject_controller {

	@Autowired
	private crtproject_dao crtDao;
	
	
	@Autowired
	private projecttasks_service taskGroupService;

	public crtproject_dao getcrtDao() {
		return crtDao;
	}

	public void setcrtDao(crtproject_dao crtDao) {
		this.crtDao = crtDao;
	}

	public projecttasks_service gettaskGroupService() {
		return taskGroupService;
	}

	public void settaskGroupService(projecttasks_service taskGroupService) {
		this.taskGroupService = taskGroupService;
	}

	// display projectlist
	@RequestMapping(value = "/projectlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String projectlist(crtproject_vo crt, Principal principal, Model model, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession(true);
		String userName = principal.getName();
		String username = principal.getName();
		session.setAttribute("user", userName);
		model.addAttribute("userproject", crtDao.getuserproupdate(crt, username));
		return "/project/projectlist";

	}

	@RequestMapping(value = "/check", method = { RequestMethod.GET, RequestMethod.POST })
	public String checkuser(crtproject_vo crt, Principal principal) throws Exception {
		String username = principal.getName();
		crtDao.getuserprojectid(crt, username);
		return "/project/projectlist";

	}

	@RequestMapping(value = "/membernew", method = { RequestMethod.GET, RequestMethod.POST })
	public String membernew(crtproject_vo crt, Principal principal) throws Exception {
		String username = principal.getName();
		crtDao.getuserprojectid(crt, username);
		return "/member/membernew";

	}

	@RequestMapping(value = "/Newmember", method = { RequestMethod.GET, RequestMethod.POST })
	public String Newmember(crtproject_vo crt, Principal principal) throws Exception {
		String username = principal.getName();
		crtDao.getuserprojectid(crt, username);
		return "/member/Newmember";

	}

}
