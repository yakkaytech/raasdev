package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.common_dao;
import com.dao.user_dao;
import com.vo.registration_vo;
import com.vo.user_vo;

@Controller

public class user_Controller {

	@Autowired
	private user_dao radao;

	@Autowired
	private common_dao comdao;

	// @Autowired
	// private crtproject_dao crtpro;

	// registration page

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "/admin/Registerpage";
	}

	// login page

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "/admin/userlogin";

	}

	// forgot password page

	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String newmeber(Model model) {

		return "/admin/forgotpwd";
	}

	// registration successfull redirect to login page
	@RequestMapping(value = "/register", method = { RequestMethod.GET, RequestMethod.POST })
	public String registration(registration_vo reg, Model model) throws Exception {
		radao.registration(reg);
		return "/admin/userlogin";
	}

	// logout page
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		model.addAttribute("message", "Logout SuccessFully");
		return "/admin/userlogin";
	}

	// After successfull login redirect to home page(membernew.jsp)

	// @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	// public String userInfo(Model model, Principal principal) throws Exception
	// {
	//
	// model.addAttribute("view", comdao.tabledata());
	// model.addAttribute("view1", comdao.dropdowndata());
	// model.addAttribute("view2", comdao.timezonedata());
	// model.addAttribute("view3", comdao.zonedata());
	// return "membernew";
	// }

	// redirect to access denied page

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "/common/403Page";
	}

	// submitting the form data to database from home page(membernew.jsp)

	@RequestMapping(value = "/memberskill", method = { RequestMethod.GET, RequestMethod.POST })

	public String userinfo(user_vo ra, Principal principal) throws Exception {

		String userName = principal.getName();

		radao.skills(ra, userName);

		return "/member/membernew";
	}

	// dynamically select the state by selecting the country

	// @RequestMapping(value = "/dropcountry", method = { RequestMethod.GET,
	// RequestMethod.POST })
	// @ResponseBody
	// public String dropcountry(user_vo ra, Model model) throws Exception {
	//
	// return comdao.dropdownstate(ra);
	//
	// }
}
