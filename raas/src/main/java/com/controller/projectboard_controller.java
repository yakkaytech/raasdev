package com.controller;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.crtproject_dao;
import com.dao.projectteam_dao;
import com.service.TaskStatusService;
import com.service.jobService;
import com.service.projectTasks_service;
import com.service.featureService;
import com.service.teamService;
import com.vo.crtproject_vo;
import com.vo.feature_vo;
import com.vo.projectRole_vo;
import com.vo.projectTasksgp_vo;
import com.wrapper.wrapper;

@Controller
@RequestMapping()
public class projectboard_controller {

	@Autowired
	private projectTasks_service taskgroupservice;

	@Autowired
	private crtproject_dao crtdao;

	@Autowired
	private featureService featuresetsservice;

	
	//dashboard page loading information
	@RequestMapping(value = "/projectboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String dashboard(@RequestParam("project_id") int project_id, crtproject_vo crt, Model model,
			Principal principal) throws Exception {
		String userName = principal.getName();
		model.addAttribute("projectname", crtdao.prodetail(crt, userName, project_id));
		model.addAttribute("project_id", taskgroupservice.getproject_id(project_id));
		model.addAttribute("priority_code", taskgroupservice.getpriority_code());
		model.addAttribute("feature", featuresetsservice.getfeaturesets(project_id));
		return "/project/project_board";
	}

	//add features in dashboard
	@RequestMapping(value = "/addfeature", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String addfeature(@RequestParam("project_id") int project_id, crtproject_vo crt, feature_vo ptv, Model model,
			Principal principal) throws Exception {
		String userName = principal.getName();
		final String token = UUID.randomUUID().toString();
		return featuresetsservice.addfeature(ptv, userName, token, project_id);
	}

	//display features for edit
	@RequestMapping(value = "/featureeditload", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editloadgrp(@RequestParam("project_id") int project_id, @RequestParam("feature_id") int feature_id,
			Model model, feature_vo tasksgp) throws Exception {

		model.addAttribute("editdetails", featuresetsservice.loadeditgroup(feature_id));
		return taskgroupservice.loadeditgroup(feature_id);
	}

	//edit feature
	@RequestMapping(value = "/edittaskgrp", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editfeature(@RequestParam("project_id") int project_id, @ModelAttribute("tasks") feature_vo tasks,
			crtproject_vo crt, Principal principal, Model model) throws Exception {
		return featuresetsservice.managefeature(tasks, project_id);
	}
    //remove feature
	@RequestMapping(value = "/deletefeatures", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String deletefeature(@RequestParam("feature_id") int feature_id, @RequestParam("project_id") int project_id,
			crtproject_vo crt, Model model) throws Exception {
		model.addAttribute("project_id", taskgroupservice.getproject_id(project_id));
		return featuresetsservice.removefeature(feature_id, project_id);

	}

}
