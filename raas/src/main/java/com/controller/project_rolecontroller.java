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
import com.vo.crtproject_vo;
import com.vo.projectRole_vo;
import com.vo.projectTasksgp_vo;



@Controller
@RequestMapping()
public class project_rolecontroller {
	
	@Autowired
	private crtproject_dao crtdao;

	public crtproject_dao getCrtdao() {
		return crtdao;
	}

	public void setCrtdao(crtproject_dao crtdao) {
		this.crtdao = crtdao;
	}
	
	
	// project role page
		@RequestMapping(value = "/rolegp", method = RequestMethod.GET)
		public ModelAndView projectrole() {
			return new ModelAndView("projectRole", "command", new projectTasksgp_vo());
		}
		
		@RequestMapping(value = "/projectrole", method = { RequestMethod.GET, RequestMethod.POST })
		public String savegrp( @ModelAttribute("projectRole") projectRole_vo role,crtproject_vo crt, Model model) throws Exception {
			
			int project_id = crt.getProject_id();
			
			
			model.addAttribute("jobtype", crtdao.jobtype());
			model.addAttribute("frequency",crtdao.frequency_code());
			model.addAttribute("jobdetail",crtdao.getjobdetails(role,project_id));
			
			return "/project/projectRole";
		}
		
		@RequestMapping(value = "/prjtrole_addmember", method = { RequestMethod.GET, RequestMethod.POST })
		@ResponseBody
		public String role( @ModelAttribute("projectRole") projectRole_vo role,crtproject_vo crt, Model model) throws Exception {
			
			System.out.println("Add Members");
			int project_id = role.getProject_id();
			 crtdao.save_addmembers(role,project_id);
			model.addAttribute("jobdetail",crtdao.getjobdetails(role,project_id));
			return "true";
		}
		
		@RequestMapping(value = "/prjtrole_editmember", method = { RequestMethod.GET, RequestMethod.POST } )
		@ResponseBody
		public String editrole( projectRole_vo role, Model model) throws Exception {
			int project_id = role.getProject_id();
			crtdao.edit_addmembers(role);
			
			return "true";
		}

}
