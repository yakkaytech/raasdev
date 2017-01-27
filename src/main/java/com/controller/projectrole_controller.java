package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.crtproject_dao;
import com.service.projecttasks_service;
import com.vo.crtproject_vo;
import com.vo.feature_vo;
import com.vo.projectrole_vo;

@Controller
@RequestMapping()
public class projectrole_controller {

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

	// project role page
	@RequestMapping(value = "/rolegp", method = RequestMethod.GET)
	public ModelAndView projectrole() {
		return new ModelAndView("projectRole", "command", new feature_vo());
	}
	
	// project role page loading information
	@RequestMapping(value = "/projectrole", method = { RequestMethod.GET, RequestMethod.POST })
	public String savegrp(@RequestParam("project_id") int project_id,
			@ModelAttribute("projectrole") projectrole_vo role, crtproject_vo crt, Model model, Principal principal)
			throws Exception {

		String userName = principal.getName();
		model.addAttribute("project_id", taskGroupService.getproject_id(project_id));
		model.addAttribute("projectname", crtDao.prodetail(crt, userName, project_id));
		model.addAttribute("jobtype", crtDao.jobtype());
		model.addAttribute("frequency", crtDao.frequency_code());
		model.addAttribute("jobdetail", crtDao.getjobdetails(role, project_id));

		return "/project/projectrole";
	}

	
	//project role add member 
	@RequestMapping(value = "/prjtrole_addmember", method = { RequestMethod.GET, RequestMethod.POST })
	public String role(projectrole_vo role,  Model model) throws Exception {

		int project_id = role.getProject_id();
		crtDao.save_addmembers(role, project_id);
		model.addAttribute("jobdetail", crtDao.getjobdetails(role, project_id));
		return "redirect:projectrole?project_id=" + project_id;
	}

	//save and publish jobs 
	@RequestMapping(value = "/savepublish", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String savepublish(projectrole_vo role, Model model) throws Exception {

		int project_id = role.getProject_id();
		crtDao.save_and_publish(role, project_id);
		model.addAttribute("jobdetail", crtDao.getjobdetails(role, project_id));
		return "true";
	}

	//project role edit member
	@RequestMapping(value = "/prjtrole_editmember", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editrole(projectrole_vo role, Model model) throws Exception {
		int project_id = role.getProject_id();
		crtDao.edit_addmembers(role);
		model.addAttribute("jobdetail", crtDao.getjobdetails(role, project_id));

		return "true";
	}
     
	//project role edit and publish member
	@RequestMapping(value = "/prjtrole_edit_publishmember", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editrole_publish(projectrole_vo role, Model model) throws Exception {
		int project_id = role.getProject_id();
		crtDao.prjtrole_edit_publishmember(role);
		model.addAttribute("jobdetail", crtDao.getjobdetails(role, project_id));
		return "true";
	}

	

}
