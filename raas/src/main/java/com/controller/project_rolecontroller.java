package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dao.crtproject_dao;
import com.service.projectTasks_service;
import com.vo.crtproject_vo;
import com.vo.feature_vo;
import com.vo.projectRole_vo;
import com.vo.projectTasksgp_vo;

@Controller
@RequestMapping()
public class project_rolecontroller {

	@Autowired
	private crtproject_dao crtdao;

	@Autowired
	private projectTasks_service taskgroupservice;

	public crtproject_dao getCrtdao() {
		return crtdao;
	}

	public void setCrtdao(crtproject_dao crtdao) {
		this.crtdao = crtdao;
	}

	// project role page
	@RequestMapping(value = "/rolegp", method = RequestMethod.GET)
	public ModelAndView projectrole() {
		return new ModelAndView("projectRole", "command", new feature_vo());
	}
	
	// project role page loading information
	@RequestMapping(value = "/projectrole", method = { RequestMethod.GET, RequestMethod.POST })
	public String savegrp(@RequestParam("project_id") int project_id,
			@ModelAttribute("projectRole") projectRole_vo role, crtproject_vo crt, Model model, Principal principal)
			throws Exception {

		String userName = principal.getName();
		model.addAttribute("project_id", taskgroupservice.getproject_id(project_id));
		model.addAttribute("projectname", crtdao.prodetail(crt, userName, project_id));
		model.addAttribute("jobtype", crtdao.jobtype());
		model.addAttribute("frequency", crtdao.frequency_code());
		model.addAttribute("jobdetail", crtdao.getjobdetails(role, project_id));

		return "/project/projectrole";
	}

	
	//project role add member 
	@RequestMapping(value = "/prjtrole_addmember", method = { RequestMethod.GET, RequestMethod.POST })
	public String role(projectRole_vo role, crtproject_vo crt, Model model) throws Exception {

		int project_id = role.getProject_id();
		crtdao.save_addmembers(role, project_id);
		model.addAttribute("jobdetail", crtdao.getjobdetails(role, project_id));
		return "redirect:projectrole?project_id=" + project_id;
	}

	//save and publish jobs 
	@RequestMapping(value = "/savepublish", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String savepublish(projectRole_vo role, crtproject_vo crt, Model model) throws Exception {
		String category_code = role.getCategory_code();

		int project_id = role.getProject_id();
		crtdao.save_and_publish(role, project_id);
		model.addAttribute("jobdetail", crtdao.getjobdetails(role, project_id));
		return "true";
	}

	//project role edit member
	@RequestMapping(value = "/prjtrole_editmember", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editrole(projectRole_vo role, Model model) throws Exception {

		int project_id = role.getProject_id();
		crtdao.edit_addmembers(role);
		model.addAttribute("jobdetail", crtdao.getjobdetails(role, project_id));

		return "true";
	}
     
	//project role edit and publish member
	@RequestMapping(value = "/prjtrole_edit_publishmember", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String editrole_publish(projectRole_vo role, Model model) throws Exception {
		int project_id = role.getProject_id();
		crtdao.prjtrole_edit_publishmember(role);
		model.addAttribute("jobdetail", crtdao.getjobdetails(role, project_id));
		return "true";
	}

	

}
