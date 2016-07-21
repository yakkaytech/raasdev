package com.controller;



import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.common_dao;
import com.dao.crtproject_dao;
import com.vo.crtproject_vo;
import com.vo.user_vo;




@Controller
@RequestMapping("/crt")
public class crtproject_controller {

	
	@Autowired
	private crtproject_dao crtdao;
	
	@Autowired
	private common_dao comdao;
	
	// project register page

			@RequestMapping(value = "/proregis", method = RequestMethod.GET)
			public String projectPage(Model model) {

				return "projectRegister";
				
			}
			
			@RequestMapping(value = "/task", method = RequestMethod.GET)
			public String taskPage(Model model) {

				return "taskboard";
				
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
			
		@RequestMapping(value = "/projectregis", method = { RequestMethod.GET, RequestMethod.POST })

		public String projectinfo(crtproject_vo crt,Principal principal) throws Exception {
           
			String userName = principal.getName();

		crtdao.proregister(crt,userName);

			return "projectRegister";
		}
		// dynamically select the state by selecting the country

		@RequestMapping(value = "/dropcountry", method = { RequestMethod.GET, RequestMethod.POST })
		@ResponseBody
		public String dropcountry(user_vo ra, Model model) throws Exception {

			return comdao.dropdownstate(ra);

		}

}


