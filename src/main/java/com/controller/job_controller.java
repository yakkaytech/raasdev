package com.controller;

import java.security.Principal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.common_dao;
import com.service.proposal_service;
import com.service.feature_service;
import com.service.job_service;
import com.service.projecttasks_service;
import com.service.team_service;
import com.vo.projectrole_vo;
import com.vo.projecttasks_vo;
import com.vo.team_vo;

@Controller
public class job_controller {

	@Autowired
	private job_service jobService;

	@Autowired
	private team_service teamsService;

	@Autowired
	private projecttasks_service taskGroupService;

	@Autowired
	private feature_service featureSetsService;
	
	@Autowired
	private common_dao comDao;
	
	@Autowired
	private proposal_service proposalService;

	
	//job page loading information
	@RequestMapping(value = "/jobs", method = { RequestMethod.GET, RequestMethod.POST })
	public String job(projectrole_vo prv, Model model) throws Exception {
		
		model.addAttribute("alljobs", jobService.getAllJobs(prv));
		jobService.getJobById();

		return "/job/jobs";

	}
    
	@RequestMapping(value = "/new", method = { RequestMethod.GET, RequestMethod.POST })
	public String teamdetails() throws Exception {

		teamsService.addMember();
		teamsService.removeMember();
		teamsService.getTeamMembers();
		teamsService.getActiveTeamMembers();

		return "/job/jobs";
	}

	
	//jobdetail loading information
	@RequestMapping(value = "/jobdetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String jobdetail(@RequestParam("project_id") int project_id, projectrole_vo prv, Model model,
			Principal principal) throws Exception {

		String username = principal.getName();
		int userid=comDao.getuser_id(username);
		model.addAttribute("project", proposalService.getmyproposals(userid,project_id));
		model.addAttribute("user_id", jobService.getuserid(username));
		model.addAttribute("project_id", taskGroupService.getproject_id(project_id));
		model.addAttribute("projectdetails", jobService.getprojectdetails(prv, project_id));
		model.addAttribute("feature", featureSetsService.getfeaturesets(project_id));
		model.addAttribute("availableroles", jobService.getavailableroles(prv, project_id));

		return "/job/jobdetail";
	}

	@RequestMapping(value = "/validmember", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String validmember(@RequestParam("project_id") int project_id,team_vo team) throws Exception {
		return teamsService.checkvalidmember(team,project_id);
	}
	
	//create projectteam 
	@RequestMapping(value = "/team", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody 
	public String createteam(@RequestParam("project_id") int project_id, team_vo team) throws Exception {


		final String token = UUID.randomUUID().toString();
		return teamsService.createteam(project_id, team, token);
	}
    //addmember into team
	@RequestMapping(value = "/addmember", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String member(team_vo team) throws Exception {
		teamsService.addmember(team);
		return "true";
	}

}
