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
import com.service.taskstatus_service;
import com.service.feature_service;
import com.service.job_service;
import com.service.projecttasks_service;
import com.service.team_service;
import com.vo.crtproject_vo;
import com.vo.feature_vo;
import com.vo.projectrole_vo;
import com.vo.projecttasks_vo;
import com.vo.projecttasksgp_vo;

@Controller
public class projectteam_controller {

	@Autowired
	private projectteam_dao projectTeamDao;

	@Autowired
	private crtproject_dao crtDao;

	@Autowired
	private projecttasks_service taskGroupService;

	@Autowired
	private taskstatus_service taskStatusService;

	
	// team board page loading information
	@RequestMapping(value = "/teamboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String teamboard(@RequestParam("project_id") int project_id,  crtproject_vo crt, Model model,
			Principal principal) throws Exception {
		String userName = principal.getName();
		model.addAttribute("tasktype", taskGroupService.gettasktype());
		model.addAttribute("project_id", taskGroupService.getproject_id(project_id));
		model.addAttribute("projectname", crtDao.prodetail(crt, userName, project_id));
		model.addAttribute("teamdetail", taskGroupService.getteamfirstddetails(project_id));
		model.addAttribute("teamboard", taskGroupService.getteambrddetails(project_id));
		model.addAttribute("Inprogress", taskGroupService.getteaminpdetails(project_id));
		model.addAttribute("completed", taskGroupService.getteamcmpdetails(project_id));
		model.addAttribute("signoff", taskGroupService.getteamsignoffdetails(project_id));
		model.addAttribute("signof", taskGroupService.getuserrole(userName));
		return "/project/teamboard";
	}

	//team view
	@RequestMapping(value = "/teamview", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String teamview(projecttasks_vo ptv,  Model model) throws Exception {
		model.addAttribute("tasktype", taskGroupService.gettasktype());
	//	model.addAttribute("teamview", taskGroupService.getteamviewdetails(ptv));
		return taskGroupService.getteamviewdetails(ptv);
	}

	//change status to taskinprogress
	@RequestMapping(value = "/taskInprogress", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String Inprogress(projecttasks_vo ptv, Model model) throws Exception {
		int project_id = ptv.getProject_id();
		taskStatusService.taskInprogressactivity(ptv);
		model.addAttribute("teamboard", taskGroupService.getteambrddetails(project_id));
		return "true";
	}
	//change status to taskcompleted
	@RequestMapping(value = "/taskcompleted", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String completed(projecttasks_vo ptv, Model model) throws Exception {
		int project_id = ptv.getProject_id();
		taskStatusService.taskcompletedactivity(ptv);
		model.addAttribute("teamboard", taskGroupService.getteambrddetails(project_id));
		return "true";

	}
	//change status to tasksignedoff
	@RequestMapping(value = "/tasksignedoff", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String signedoff(projecttasks_vo ptv, Model model) throws Exception {
		int project_id = ptv.getProject_id();

		taskStatusService.tasksignedoffactivity(ptv);
		model.addAttribute("teamboard", taskGroupService.getteambrddetails(project_id));

		return "true";

	}

	
	//getedit tasks in temaboard
	@RequestMapping(value = "/editviewteam", method = RequestMethod.GET)
	public String geteditviewtasks(@RequestParam("project_id") int project_id) throws Exception {
		return "forward:teamboard?project_id=" + project_id;

	}

	//saveedit tasks in temaboard
	@RequestMapping(value = "/editviewteam", method = RequestMethod.POST)
	public String editviewSave(@RequestParam("project_id") int project_id, projecttasks_vo ptv,
			@RequestParam(value = "file") MultipartFile file) throws Exception {
		String fileName = null;
		project_id = ptv.getProject_id();
		fileName = file.getOriginalFilename();
		byte[] bytes = file.getBytes();
		BufferedOutputStream buffStream = new BufferedOutputStream(
				new FileOutputStream(new File("D:/Attachmentssave/" + fileName)));
		buffStream.write(bytes);
		buffStream.close();
		taskGroupService.edittaskdetails(ptv, file);
		return "redirect:teamboard?project_id=" + project_id;
	}
}
