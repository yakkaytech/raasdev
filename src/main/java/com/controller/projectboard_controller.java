package com.controller;

import java.security.Principal;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.crtproject_dao;
import com.service.feature_service;
import com.service.projecttasks_service;
import com.vo.crtproject_vo;
import com.vo.feature_vo;

@Controller
@RequestMapping()
public class projectboard_controller {

	@Autowired
	private projecttasks_service taskGroupService;

	@Autowired
	private crtproject_dao crtDao;

	@Autowired
	private feature_service featureSetsService;
	
	
	 @Autowired
	    private MessageSource messageSource;

	// dashboard page loading information
	@RequestMapping(value = "/projectboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String dashboard(@RequestParam("project_id") int project_id, crtproject_vo crt, Model model,
			Principal principal) throws Exception {
		String userName = principal.getName();
		model.addAttribute("projectname", crtDao.prodetail(crt, userName, project_id));
		model.addAttribute("project_id", taskGroupService.getproject_id(project_id));
		model.addAttribute("prioritycode", taskGroupService.getpriority_code());
		model.addAttribute("feature", featureSetsService.getfeaturesets(project_id));
		return "/project/project_board";
	}

	// add features in dashboard
	@RequestMapping(value = "/addfeature", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String addfeature(@RequestParam("project_id") int project_id, feature_vo ptv, Principal principal)
			throws Exception {
		String userName = principal.getName();
		final String token = UUID.randomUUID().toString();
		return featureSetsService.addfeature(ptv, userName, token, project_id);
	}

	// display features for edit
	@RequestMapping(value = "/featureeditload", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editloadgrp(@RequestParam("feature_id") int feature_id) throws Exception {

		// model.addAttribute("editdetails",
		// featureSetsService.loadeditgroup(feature_id));
		return taskGroupService.loadeditgroup(feature_id);
	}

	// edit feature
	@RequestMapping(value = "/edittaskgrp", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editfeature(@RequestParam("project_id") int project_id, @ModelAttribute("tasks") feature_vo tasks)
			throws Exception {
		return featureSetsService.managefeature(tasks, project_id);
	}

	// remove feature
	@RequestMapping(value = "/deletefeatures", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String deletefeature(@RequestParam("feature_id") int feature_id, @RequestParam("project_id") int project_id)
			throws Exception {
		return featureSetsService.removefeature(feature_id, project_id);

	}

}
