package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.common_dao;
import com.dao.crtproject_dao;
import com.dao.message_dao;
import com.service.taskstatus_service;
import com.service.feature_service;
import com.service.projecttasks_service;
import com.vo.crtproject_vo;
import com.vo.feature_vo;
import com.vo.message_vo;
import com.vo.projecttasks_vo;
import com.vo.user_vo;

@Controller
@RequestMapping("/crt")
public class crtproject_controller {

	@Autowired
	private crtproject_dao crtDao;

	@Autowired
	private common_dao comDao;

	@Autowired
	private message_dao messageDao;

	@Autowired
	private projecttasks_service taskGroupService;

	@Autowired
	private taskstatus_service taskStatusService;

	@Autowired
	private feature_service featureSetsService;


	// project register page
	@RequestMapping(value = "/taskgrp", method = RequestMethod.GET)
	public ModelAndView group() {
		return new ModelAndView("tasks", "command", new feature_vo());
	}

	
	@RequestMapping("/tasks")
	public ModelAndView viewgrp() {
		return new ModelAndView("tasks", "list", new feature_vo());
	}

	@RequestMapping(value = "/editgrp", method = RequestMethod.GET)
	public ModelAndView editgroup() {
		return new ModelAndView("tasks", "command", new feature_vo());
	}

	@RequestMapping(value = "/savetaskgrp", method = { RequestMethod.GET, RequestMethod.POST })
	public String savegrp(@RequestParam("project_id") int project_id, @ModelAttribute("tasks") feature_vo tasks,
			crtproject_vo crt, Principal principal, Model model) throws Exception {

		String username = principal.getName();
		taskGroupService.saveptaskgroup(tasks, project_id, username);
		return "redirect:tasks?project_id=" + project_id;
	}

	@RequestMapping(value = "/editvalueload", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editloadgrp( @RequestParam("task_group_id") int feature_id,
			Model model) throws Exception {

		model.addAttribute("editdetails", taskGroupService.loadeditgroup(feature_id));

		return taskGroupService.loadeditgroup(feature_id);
	}

	@RequestMapping(value = "/edittaskgrp", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editgrp(@RequestParam("project_id") int project_id, @ModelAttribute("tasks") feature_vo tasks) throws Exception {
		return taskGroupService.editptaskgroup(tasks, project_id);
	}

	@RequestMapping(value = "/proregis", method = RequestMethod.GET)
	public String projectPage() {
		return "projectregister";
	}

	
	//planning board page
	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public String tasksPage(@RequestParam("project_id") int project_id, crtproject_vo crt,
			Model model, Principal principal) throws Exception {
		String userName = principal.getName();
		model.addAttribute("project_id", taskGroupService.getproject_id(project_id));
		model.addAttribute("projectname", crtDao.prodetail(crt, userName, project_id));
		model.addAttribute("taskgroup", featureSetsService.gettaskgroup(project_id));
		model.addAttribute("tasktype", taskGroupService.gettasktype());
		model.addAttribute("tasksize", taskGroupService.gettasksize());
		model.addAttribute("priority_code", taskGroupService.getpriority_code());
		model.addAttribute("taskdetails", taskGroupService.gettaskdetails(project_id));
		model.addAttribute("teamdetail", taskGroupService.getteamfirstviewdetails(project_id));
		model.addAttribute("signof", taskGroupService.getuserrole(userName));
		return "/project/tasks";
	}

	//project header
	@RequestMapping(value = "/projectheader", method = { RequestMethod.GET, RequestMethod.POST })
	public String projectheader(Principal principal, String userName) throws Exception {
		taskGroupService.getUsername(principal, userName);

		return "/layout/projectheader";
	}

	
	
	@RequestMapping(value = "/tasks", method = { RequestMethod.POST })
	public String savetaskgroup(@RequestParam("project_id") int project_id, feature_vo taskgp, 
			 Principal principal) throws Exception {

		String username = principal.getName();

		taskGroupService.saveptaskgroup(taskgp, project_id, username);
		return "redirect:tasks?project_id=" + project_id;
	}

	//get tasks
	@RequestMapping(value = "/detailtasks", method = RequestMethod.GET)
	public String gettasks(@RequestParam("project_id") int project_id,
			@RequestParam(value = "file", required = false, defaultValue = "anonymous") MultipartFile file,
			projecttasks_vo tasks) throws Exception {

		return "forward:tasks?project_id=" + project_id;
	}

	//save tasks
	@RequestMapping(value = "/detailtasks", method = RequestMethod.POST)
	public String singleSave(@RequestParam("project_id") int project_id,
			@RequestParam(value = "file") MultipartFile file, projecttasks_vo taskdetails, 
			Model model, Principal principal) throws Exception {

		String fileName = null;
		String username = principal.getName();
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
						"C:/Users/Diya/Documents/workspace-sts-3.7.3.RELEASE/raas/src/main/webapp/resources/common/file/"
								+ fileName)));
				buffStream.write(bytes);
				buffStream.close();
				taskStatusService.taskCreatedActivity(taskdetails, file, project_id, username);

				return "redirect:tasks?project_id=" + project_id;

			} catch (Exception e) {
				return "You failed to upload " + fileName + ": " + e.getMessage();
			}

		} else {
			fileName = null;
			taskStatusService.taskCreatedActivity(taskdetails, file, project_id, username);
			return "redirect:tasks?project_id=" + project_id;

		}

	}

	@RequestMapping(value = "/editviewtask", method = RequestMethod.GET)
	public String geteditviewtasks(@RequestParam("project_id") int project_id) throws Exception {
		return "forward:tasks?project_id=" + project_id;
	}

	@RequestMapping(value = "/editviewtask", method = RequestMethod.POST)
	@ResponseBody
	public String editviewSave(@RequestParam("project_id") int project_id, projecttasks_vo ptv,
			@RequestParam(value = "file") MultipartFile file, Model model) throws Exception {
		String fileName = null;
		project_id = ptv.getProject_id();
		fileName = file.getOriginalFilename();
		byte[] bytes = file.getBytes();
		
		System.out.println("hai");
		
		BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
				"C:/Users/Diya/Documents/workspace-sts-3.7.3.RELEASE/raas/src/main/webapp/resources/common/file/"
						+ fileName)));
		buffStream.write(bytes);
		buffStream.close();
		taskGroupService.edittaskdetails(ptv, file);
	//	model.addAttribute("teamdetail", taskGroupService.gettaskviewbaseddetails(ptv));
		return "true";
	}

	@RequestMapping(value = "/edittask", method = RequestMethod.GET)
	public String getedittasks(@RequestParam("task_id") String task_id)
			throws Exception {

		return "forward:taskdetail?task_id=" + task_id;
	}

	@RequestMapping(value = "/edittask", method = RequestMethod.POST)
	public String editSave(projecttasks_vo ptv, @RequestParam(value = "file") MultipartFile file, Model model)
			throws Exception {

		String fileName = null;
		int task_id = ptv.getTask_id();
		try {
			fileName = file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
					"C:/Users/Diya/Documents/workspace-sts-3.7.3.RELEASE/raas/src/main/webapp/resources/common/file"+ fileName)));
			buffStream.write(bytes);
			buffStream.close();
			taskGroupService.edittaskdetails(ptv, file);

			model.addAttribute("taskview", taskGroupService.gettaskviewbaseddetails(ptv));
			return "redirect:taskdetail?task_id=" + task_id;
		} catch (Exception e) {
			return "You failed to upload " + fileName + ": " + e.getMessage();
		}

	}

	@RequestMapping(value = "/taskgpview", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String taskgpview(@RequestParam("project_id") int project_id, projecttasks_vo taskgp)
			throws Exception {

		return taskGroupService.gettaskgpviewdetails(project_id, taskgp);
	}
	//get feature based taskdetails
	@RequestMapping(value = "/taskgpbaseddetails", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String gettaskgpbaseddetails(@RequestParam("project_id") int project_id, projecttasks_vo taskgp, Model model)
			throws Exception {
		
		return taskGroupService.gettaskgpbaseddetails(taskgp);
	}
	
//	@RequestMapping(value = "/edtsk", method = { RequestMethod.GET, RequestMethod.POST })
//	@ResponseBody
//	public String editTask(projecttasks_vo edtsk) throws Exception {
//		return taskGroupService.editTask(edtsk);
//	}

	// page loading information
	@RequestMapping(value = "/projectInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public String userInfo(Model model) throws Exception {
		model.addAttribute("role", comDao.getrole());
		model.addAttribute("country", comDao.getcountrydata());
		model.addAttribute("timezone", comDao.gettimezonedata());
		model.addAttribute("statezone", comDao.getzonedata());
		model.addAttribute("projecttype", crtDao.projecttype());
		model.addAttribute("skill", crtDao.skill());
		model.addAttribute("timeline", crtDao.timeline());
		return "projectregister";
	}

	// After successfull login redirect to home page(createproject.jsp)
	@RequestMapping(value = "/projectregis", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String projectinfo(crtproject_vo crt, Principal principal) throws Exception {
		String userName = principal.getName();
		crtDao.proregister(crt, userName);
		return "true";
	}

	// dynamically select the state by selecting the country
	@RequestMapping(value = "/dropcountry", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String dropcountry(user_vo ra) throws Exception {
		return comDao.dropdownstate(ra);
	}

	//taskdetail page
	@RequestMapping(value = "/taskdetail", method = RequestMethod.GET)
	public String taskdetail(projecttasks_vo ptv, Model model)
			throws Exception {
		model.addAttribute("tasktype", taskGroupService.gettasktype());
		model.addAttribute("tasksize", taskGroupService.gettasksize());
		model.addAttribute("taskview", taskGroupService.gettaskviewbaseddetails(ptv));
		return "/project/taskdetail";
	}

	//taskdetail update
	@RequestMapping(value = "/taskdetail?task_id= {value:.+}", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String taskupdetail(projecttasks_vo ptv) throws Exception {
		taskGroupService.getupdatetaskdetail(ptv);
		int task_id = ptv.getTask_id();

		return "/project/taskdetail?task_id=" + task_id;
	}

	//file download
	@RequestMapping(value = "/download/{value:.+}", method = RequestMethod.GET)
	public void filedownload(HttpServletRequest request, HttpServletResponse response, @PathVariable String value) {

		try {
			String file = value;
			File uFile = new File("D:/Attachmentssave/", file);
			int fSize = (int) uFile.length();
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(uFile));
			String mimetype = "application/pdf";
			response.setBufferSize(fSize);
			response.setContentType(mimetype);
			response.setHeader("Content-Disposition", "attachment; filename=\"" + file + "\"");
			response.setContentLength(fSize);
			FileCopyUtils.copy(in, response.getOutputStream());
			in.close();
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//projectdetail page loading information
	@RequestMapping(value = "/projectdetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String projectdetailPage(Model model, crtproject_vo crt, Principal principal)
			throws Exception {
		String userName = principal.getName();

		int project_id = crt.getProject_id();
		taskGroupService.getproject_id(project_id);
		model.addAttribute("project_id", taskGroupService.getproject_id(project_id));
		model.addAttribute("projectname", crtDao.prodetail(crt, userName, project_id));
		model.addAttribute("country", comDao.getcountrydata());
		model.addAttribute("timezone", comDao.gettimezonedata());
		model.addAttribute("statezone", comDao.getzonedata());
		model.addAttribute("projecttype", crtDao.projecttype());
		model.addAttribute("timeline", crtDao.timeline());
		return "/project/projectdetail";
	}
	//projectdetail page update 
	@RequestMapping(value = "/updateproject", method = { RequestMethod.GET, RequestMethod.POST })
	public String projectdetail(crtproject_vo crt, Model model, Principal principal) throws Exception {

		String userName = principal.getName();
		int project_id = crt.getProject_id();
		crtDao.getprojectupdate(crt);
		model.addAttribute("projectname", crtDao.prodetail(crt, userName, project_id));
		model.addAttribute("project_id", taskGroupService.getproject_id(project_id));
		model.addAttribute("country", comDao.getcountrydata());
		model.addAttribute("timezone", comDao.gettimezonedata());
		model.addAttribute("statezone", comDao.getzonedata());
		model.addAttribute("projecttype", crtDao.projecttype());
		return "/project/projectdetail";
	}

	@RequestMapping(value = "/deletetaskgp", method = { RequestMethod.GET, RequestMethod.POST })
	public String deletegroup(@RequestParam("taskgrpid") int feature_id, @RequestParam("project_id") int project_id
			) throws Exception {

		taskGroupService.deletedetails(feature_id);
		return "redirect:tasks?project_id=" + project_id;

	}
    //index
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String index() throws Exception {
		return "/layout/index.blade";
	}

	//taskready status
	@RequestMapping(value = "/taskready", method = { RequestMethod.GET, RequestMethod.POST })
	public String readytowork(projecttasks_vo ptv ) throws Exception {

	//	taskStatusService.taskreadyactivity(ptv);
		return "taskStatusService.taskreadyactivity(ptv)";

	}

	//teamview
	@RequestMapping(value = "/teamview", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String teamview(projecttasks_vo ptv) throws Exception {
	//	model.addAttribute("teamview", taskGroupService.getteamviewdetails(ptv));
		return taskGroupService.getteamviewdetails(ptv);
	}

	//chat
	@RequestMapping(value = "/chat", method = { RequestMethod.GET, RequestMethod.POST })
	public String chatPage(message_vo msg, Model model, Principal principal, HttpServletRequest request,
			String userName) throws Exception {
		HttpSession session = request.getSession(true);
		String username = principal.getName();
		session.setAttribute("username", username);
		model.addAttribute("user", messageDao.userlist(username, msg));
		model.addAttribute("messages", messageDao.messages(msg));

		return "/chat";

	}
    //chat messages load
	@RequestMapping(value = "/messages", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String messages(message_vo msg, Model model, HttpServletRequest request, String userName,
			Principal principal) throws Exception {
		HttpSession session = request.getSession(true);
		String username = principal.getName();
		session.setAttribute("username", username);
		model.addAttribute("messages", messageDao.message(msg, username));
		return "true";
	}
    //chat messages typing
	@RequestMapping(value = "/typing", method = { RequestMethod.GET, RequestMethod.POST })
	public String typing(Model model, Principal principal, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String username = principal.getName();
		session.setAttribute("user", username);
		return "/typing";
	}

}