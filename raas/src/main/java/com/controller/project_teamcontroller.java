package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dao.crtproject_dao;
import com.dao.projectteam_dao;
import com.service.TaskStatusService;
import com.service.featureService;
import com.service.jobService;
import com.service.projectTasks_service;
import com.service.teamService;
import com.vo.crtproject_vo;
import com.vo.feature_vo;
import com.vo.projectRole_vo;
import com.vo.projectTasks_vo;
import com.vo.projectTasksgp_vo;

@Controller
public class project_teamcontroller {

	@Autowired
	private projectteam_dao prjtteam_dao;

	@Autowired
	private crtproject_dao crtdao;

	@Autowired
	private projectTasks_service taskgroupservice;

	@Autowired
	private TaskStatusService taskStatusService;

	
	// team board page loading information
	@RequestMapping(value = "/teamboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String teamboard(@RequestParam("project_id") int project_id, feature_vo ptv, crtproject_vo crt, Model model,
			Principal principal) throws Exception {
		String userName = principal.getName();
		model.addAttribute("tasktype", taskgroupservice.gettasktype());
		model.addAttribute("project_id", taskgroupservice.getproject_id(project_id));
		model.addAttribute("projectname", crtdao.prodetail(crt, userName, project_id));
		model.addAttribute("teamdetail", taskgroupservice.getteamfirstddetails(project_id));
		model.addAttribute("teamboard", taskgroupservice.getteambrddetails(project_id));
		model.addAttribute("Inprogress", taskgroupservice.getteaminpdetails(project_id));
		model.addAttribute("completed", taskgroupservice.getteamcmpdetails(project_id));
		model.addAttribute("signoff", taskgroupservice.getteamsignoffdetails(project_id));
		model.addAttribute("signof", taskgroupservice.getuserrole(userName));
		return "/project/teamboard";
	}

	//team view
	@RequestMapping(value = "/teamview", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String teamview(projectTasks_vo ptv, crtproject_vo crt, Model model) throws Exception {
		model.addAttribute("tasktype", taskgroupservice.gettasktype());
		model.addAttribute("teamview", taskgroupservice.getteamviewdetails(ptv));
		return taskgroupservice.getteamviewdetails(ptv);
	}

	//change status to taskinprogress
	@RequestMapping(value = "/taskInprogress", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String Inprogress(projectTasks_vo ptv, Model model) throws Exception {
		int project_id = ptv.getProject_id();
		taskStatusService.taskInprogressactivity(ptv);
		model.addAttribute("teamboard", taskgroupservice.getteambrddetails(project_id));
		return "true";
	}
	//change status to taskcompleted
	@RequestMapping(value = "/taskcompleted", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String completed(projectTasks_vo ptv, Model model) throws Exception {
		int project_id = ptv.getProject_id();
		taskStatusService.taskcompletedactivity(ptv);
		model.addAttribute("teamboard", taskgroupservice.getteambrddetails(project_id));
		return "true";

	}
	//change status to tasksignedoff
	@RequestMapping(value = "/tasksignedoff", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String signedoff(projectTasks_vo ptv, Model model) throws Exception {
		int project_id = ptv.getProject_id();

		taskStatusService.tasksignedoffactivity(ptv);
		model.addAttribute("teamboard", taskgroupservice.getteambrddetails(project_id));

		return "true";

	}

	
	//getedit tasks in temaboard
	@RequestMapping(value = "/editviewteam", method = RequestMethod.GET)
	public String geteditviewtasks(@RequestParam("project_id") int project_id, @RequestParam("task_id") String task_id,
			projectTasks_vo tasks, Model model) throws Exception {
		return "forward:teamboard?project_id=" + project_id;

	}

	//saveedit tasks in temaboard
	@RequestMapping(value = "/editviewteam", method = RequestMethod.POST)
	public String editviewSave(@RequestParam("project_id") int project_id, projectTasks_vo ptv,
			@RequestParam(value = "file") MultipartFile file, Model model) throws Exception {
		String fileName = null;
		project_id = ptv.getProject_id();
		int task_id = ptv.getTask_id();

		fileName = file.getOriginalFilename();
		long filesize = file.getSize();
		byte[] bytes = file.getBytes();
		BufferedOutputStream buffStream = new BufferedOutputStream(
				new FileOutputStream(new File("D:/Attachmentssave/" + fileName)));
		buffStream.write(bytes);
		buffStream.close();
		taskgroupservice.edittaskdetails(ptv, file);
		return "redirect:teamboard?project_id=" + project_id;
	}
}
