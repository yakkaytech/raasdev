package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
import com.service.projectTasks_service;
import com.vo.OutputMessage;
import com.vo.TaskDetails;
import com.vo.crtproject_vo;
import com.vo.message_vo;
import com.vo.projectTasks_vo;
import com.vo.projectTasksgp_vo;
import com.vo.user_vo;

@Controller
@RequestMapping("/crt")
public class crtproject_controller {

	@Autowired
	private crtproject_dao crtdao;

	@Autowired
	private common_dao comdao;

	@Autowired
	private projectTasks_service taskgroupservice;

	// project register page
	@RequestMapping(value = "/taskgrp", method = RequestMethod.GET)
	public ModelAndView group() {
		return new ModelAndView("tasks", "command", new projectTasksgp_vo());
	}

	@RequestMapping("/tasks")
	public ModelAndView viewgrp() {
		// List<wrapper> list=taskgroupservice.gettaskgroup();
		return new ModelAndView("tasks", "list", new projectTasks_vo());

	}

	@RequestMapping(value = "/editgrp", method = RequestMethod.GET)
	public ModelAndView editgroup() {
		return new ModelAndView("tasks", "command", new projectTasksgp_vo());
	}

	@RequestMapping(value = "/savetaskgrp", method = { RequestMethod.GET, RequestMethod.POST })

	public String savegrp(@RequestParam("project_id") int project_id, @ModelAttribute("tasks") projectTasksgp_vo tasks,
			crtproject_vo crt, Principal principal, Model model) throws Exception {
		taskgroupservice.saveptaskgroup(tasks, project_id);
		return "redirect:tasks?project_id=" + project_id;
	}

	@RequestMapping(value = "/edittaskgrp", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editgrp(@RequestParam("project_id") int project_id, @ModelAttribute("tasks") projectTasksgp_vo tasks,
			crtproject_vo crt, Principal principal, Model model) throws Exception {
		//taskgroupservice.editptaskgroup(tasks, project_id);
		
		
		return taskgroupservice.editptaskgroup(tasks, project_id);
	}
	
	
	@RequestMapping(value = "/proregis", method = RequestMethod.GET)
	public String projectPage(Model model) {
		return "projectRegister";

	}

	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public String tasksPage(@RequestParam("project_id") int project_id, projectTasksgp_vo taskgp, crtproject_vo crt,
			Model model, Principal principal) throws Exception {
		String userName = principal.getName();
		taskgp.setProject_id(project_id);
		model.addAttribute("update", taskgroupservice.getproject_id(project_id));
		model.addAttribute("projectvo", crtdao.prodetail(crt, userName, project_id));
		model.addAttribute("taskgroup", taskgroupservice.gettaskgroup(project_id));
		model.addAttribute("tasktype", taskgroupservice.gettasktype());
		model.addAttribute("tasksize", taskgroupservice.gettasksize());
		model.addAttribute("taskdetails", taskgroupservice.gettaskdetails(project_id));
		return "/project/tasks";
	}

	@RequestMapping(value = "/projectheader", method = { RequestMethod.GET, RequestMethod.POST })
	public String projectheader(Principal principal, Model model, String userName) throws Exception {
		taskgroupservice.getUsername(principal, userName);
		
		return "/layout/projectheader";
	}
	
	@RequestMapping(value = "/tasks", method = { RequestMethod.POST })
	public String savetaskgroup(@RequestParam("project_id") int project_id, projectTasksgp_vo taskgp, crtproject_vo crt,
			Model model, Principal principal) throws Exception {
		taskgroupservice.saveptaskgroup(taskgp, project_id);
		return "redirect:tasks?project_id=" + project_id;
	}

	@RequestMapping(value = "/detailtasks", method = RequestMethod.GET)
	public String gettasks(@RequestParam("project_id") int project_id, projectTasks_vo tasks, Model model)
			throws Exception {
		return "forward:/tasks?project_id=" + project_id;
	}

	@RequestMapping(value = "/detailtasks", method = RequestMethod.POST)
	public String singleSave(@RequestParam("project_id") int project_id, @RequestParam("file") MultipartFile file,
			projectTasks_vo taskdetails, Model model) throws Exception {
		String fileName = null;
		
		System.out.println("insert tasks");
		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				long filesize = file.getSize();
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(
						new FileOutputStream(new File("D:/Attachmentssave/" + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				taskgroupservice.saveptaskdetails(taskdetails, file, project_id);

				return "redirect:tasks?project_id=" + project_id;

			} catch (Exception e) {
				return "You failed to upload " + fileName + ": " + e.getMessage();
			}
		} else {
			return "Unable to upload. File is empty.";
		}
	}
	@RequestMapping(value = "/edittask", method = RequestMethod.GET)
	public String getedittasks(@RequestParam("task_id") String task_id, projectTasks_vo tasks, Model model)
			throws Exception {
		
		return "forward:taskdetail?task_id=" + task_id;   	
		}
	
	@RequestMapping(value = "/edittask", method = RequestMethod.POST)
	public String editSave(projectTasks_vo ptv,@RequestParam(value="file") MultipartFile file, Model model) throws Exception {
		System.out.println("Inside edittask");
		String fileName = null;
		System.out.println("testfiles"+ptv.getTask_id());
	    int task_id = ptv.getTask_id();
			try {		
				fileName = file.getOriginalFilename();
			long filesize = file.getSize();
			byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(
						new FileOutputStream(new File("D:/Attachmentssave/" + fileName)));
				buffStream.write(bytes);
				buffStream.close();
				taskgroupservice.edittaskdetails(ptv,file);
				
				model.addAttribute("taskview", taskgroupservice.gettaskviewbaseddetails(ptv));
				return "redirect:taskdetail?task_id=" + task_id;
			} catch (Exception e) {
				return "You failed to upload " + fileName + ": " + e.getMessage();
			}
		
		}
	
	@RequestMapping(value = "/taskgpbaseddetails", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String gettaskgpbaseddetails(projectTasks_vo taskgp) throws Exception {
		return taskgroupservice.gettaskgpbaseddetails(taskgp);
	}

	@RequestMapping(value = "/edtsk", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editTask(projectTasks_vo edtsk) throws Exception {
		return taskgroupservice.editTask(edtsk);
	}

	// page loading information
	@RequestMapping(value = "/projectInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) throws Exception {

		model.addAttribute("views1", comdao.tabledata());
		model.addAttribute("views2", comdao.dropdowndata());
		model.addAttribute("views3", comdao.timezonedata());
		model.addAttribute("views4", comdao.zonedata());
		model.addAttribute("views5", crtdao.projecttype());
		return "projectRegister";
	}
	
	// After successfull login redirect to home page(createproject.jsp)
	@RequestMapping(value = "/projectregis", method =  { RequestMethod.GET,RequestMethod.POST } )
	@ResponseBody
	public String projectinfo(crtproject_vo crt, Principal principal,Model model) throws Exception {
		String userName = principal.getName();
		crtdao.proregister(crt, userName);
		int project_id = crt.getProject_id();
		System.out.println(project_id);
		System.out.println("redirect:tasks?project_id=" + project_id);
		
		return "true";
	}
	// dynamically select the state by selecting the country
	@RequestMapping(value = "/dropcountry", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String dropcountry(user_vo ra, Model model) throws Exception {
		return comdao.dropdownstate(ra);
	}

	@RequestMapping(value = "/taskdetail", method = RequestMethod.GET)
	public String taskdetail(@RequestParam("task_id") String task_id, projectTasks_vo ptv, Model model)
			throws Exception {
		model.addAttribute("tasktype", taskgroupservice.gettasktype());
		model.addAttribute("tasksize", taskgroupservice.gettasksize());
		model.addAttribute("taskview", taskgroupservice.gettaskviewbaseddetails(ptv));
		return "/project/taskdetail";
	}

	@RequestMapping(value = "/taskdetail?task_id= {value:.+}" , method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String taskupdetail(projectTasks_vo ptv, Model model) throws Exception {
		taskgroupservice.getupdatetaskdetail(ptv);
		int task_id = ptv.getTask_id();
		
		return "/project/taskdetail?task_id=" + task_id;
	}

	@RequestMapping(value = "/download/{value:.+}", method = RequestMethod.GET)
	public void filedownload(HttpServletRequest request, HttpServletResponse response, @PathVariable String value,
			projectTasks_vo getFile) {

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

	// page loading information
	@RequestMapping(value = "/projectdetail", method = {RequestMethod.GET,RequestMethod.POST})
	public String projectdetailPage(Model model,crtproject_vo crt, projectTasksgp_vo taskgp, Principal principal)
			throws Exception {
		String userName = principal.getName();
	
		
         int project_id =crt.getProject_id();
       
		taskgroupservice.getproject_id(project_id);
		
		model.addAttribute("projectvo", crtdao.prodetail(crt, userName, project_id));
		model.addAttribute("views2", comdao.dropdowndata());
		model.addAttribute("views3", comdao.timezonedata());
		model.addAttribute("views4", comdao.zonedata());
		model.addAttribute("views5", crtdao.projecttype());
		return "/project/projectdetail";
	}

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(message_vo message) throws Exception {
		String time = new SimpleDateFormat("HH:mm").format(new Date());
		// return new OutputMessage(message.getFrom(), message.getText(), time);
		return new OutputMessage(message.getFrom(), message.getText(), time);
	}

	@RequestMapping(value = "/updateproject", method = { RequestMethod.GET, RequestMethod.POST })
	public String projectdetail(crtproject_vo crt, Model model,Principal principal) throws Exception {
		
		String userName =principal.getName();
		 int project_id =crt.getProject_id();
		crtdao.getprojectupdate(crt);
		model.addAttribute("projectvo", crtdao.prodetail(crt, userName, project_id));
		model.addAttribute("views2", comdao.dropdowndata());
		model.addAttribute("views3", comdao.timezonedata());
		model.addAttribute("views4", comdao.zonedata());
		model.addAttribute("views5", crtdao.projecttype());
		return "/project/projectdetail";
	}
	
	@RequestMapping(value = "/deletetaskgp", method = {RequestMethod.GET ,RequestMethod.POST} )
	public String deletegroup(@RequestParam("task_group_id") int task_group_id,
			@RequestParam("project_id") int project_id,crtproject_vo crt, Model model) throws Exception {
		
		taskgroupservice.deletedetails(task_group_id);
		return  "redirect:tasks?project_id=" + project_id;
	
	}
	

	
}