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

import com.service.featureService;
import com.service.jobService;
import com.service.projectTasks_service;
import com.service.teamService;
import com.vo.projectRole_vo;
import com.vo.projectTasks_vo;
import com.vo.team_vo;

@Controller
public class job_controller {

	@Autowired
	private jobService jobservice;

	@Autowired
	private teamService teamservice;

	@Autowired
	private projectTasks_service taskgroupservice;

	@Autowired
	private featureService featuresetsservice;

	
	//job page loading information
	@RequestMapping(value = "/jobs", method = { RequestMethod.GET, RequestMethod.POST })
	public String job(projectRole_vo prv, Model model) throws Exception {
		
		model.addAttribute("alljobs", jobservice.getAllJobs(prv));
		jobservice.getJobById();

		return "/job/jobs";

	}
    
	@RequestMapping(value = "/new", method = { RequestMethod.GET, RequestMethod.POST })
	public String teamdetails(projectTasks_vo ptv, Model model) throws Exception {

		teamservice.addMember();
		teamservice.removeMember();
		teamservice.getTeamMembers();
		teamservice.getActiveTeamMembers();

		return "/job/jobs";
	}

	
	//jobdetail loading information
	@RequestMapping(value = "/jobdetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String jobdetail(@RequestParam("project_id") int project_id, projectRole_vo prv, Model model,
			Principal principal) throws Exception {

		String username = principal.getName();
		model.addAttribute("user_id", jobservice.getuserid(username));
		model.addAttribute("project_id", taskgroupservice.getproject_id(project_id));
		model.addAttribute("pro_details", jobservice.getprojectdetails(prv, project_id));
		model.addAttribute("feature", featuresetsservice.getfeaturesets(project_id));
		model.addAttribute("available_roles", jobservice.getavailableroles(prv, project_id));

		return "/job/jobdetail";
	}

	//create projectteam 
	@RequestMapping(value = "/team", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody 
	public String createteam(@RequestParam("project_id") int project_id, team_vo team, Model model) throws Exception {


		final String token = UUID.randomUUID().toString();
		return teamservice.createteam(project_id, team, token);
	}
    //addmember into team
	@RequestMapping(value = "/addmember", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String member(team_vo team, Model model) throws Exception {

		final String token = UUID.randomUUID().toString();
		teamservice.addmember(team);
		return "true";
	}

}
