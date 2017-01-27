package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dao.common_dao;
import com.dao.user_dao;
import com.service.proposal_service;
import com.service.user_service;
import com.vo.registration_vo;
import com.vo.skill;
import com.vo.user_vo;

@Controller

public class user_controller {

	@Autowired
	private common_dao comDao;
	
	@Autowired
	private user_service userService;

	

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Environment environment;
    
	
	
	 @Autowired
	  private MessageSource messageSource;
	
	// registration page

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "/admin/registerpage";
	}

	// login page

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {

		return "/admin/userlogin";

	}

	// forgot password page

	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String newmeber() {

		return "/admin/forgotpwd";
	}

	// registration successfull redirect to login page
	@RequestMapping(value = "/register", method = { RequestMethod.GET, RequestMethod.POST })
	public String registration(Locale locale, registration_vo reg, Model model,
			HttpServletRequest request) throws Exception {
		userService.registration(reg);
		final String token = UUID.randomUUID().toString();
		userService.createVerificationTokenForUser(token, reg);

		final SimpleMailMessage email = constructEmailMessage(token, reg, locale, request);
		mailSender.send(email);

		model.addAttribute("role", comDao.getrole());
		model.addAttribute("country", comDao.getcountrydata());
		model.addAttribute("timezone", comDao.gettimezonedata());
		model.addAttribute("zonedata", comDao.getzonedata());
		String username = reg.getEmail();
		model.addAttribute("user", username);
		model.addAttribute("user_id", comDao.getuser_id(username));
		return "/member/membernew";
	}

	//send email
	private final SimpleMailMessage constructEmailMessage(final String token, registration_vo reg, Locale locale,
			HttpServletRequest request) {

		final String recipientAddress = reg.getEmail();
		final String subject = messageSource.getMessage("message.register", null, Locale.US);
		final String email_id = reg.getEmail();

		final String Url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		final String confirmationUrl = Url + "/registrationconfirm?token=" + token + "&" + "email_id=" + email_id;
		 final String message = messageSource.getMessage("message.regSucc", null, Locale.US);
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message+ " \r\n" + confirmationUrl);
		email.setFrom(environment.getProperty("support.email"));
		return email;
	}

	//confirm registration
	@RequestMapping(value = "/registrationconfirm", method = { RequestMethod.GET, RequestMethod.POST })
	public String confirmRegistration(@RequestParam("token") final String token,
			@RequestParam("email_id") final String email_id, registration_vo reg) throws Exception {

		final String gettoken = userService.gettoken(email_id);
		if (token.equals(gettoken)) {
			userService.reg_activation(token, reg, email_id);

			return "/admin/registrationconfirm";

		} else {

			return "/admin/resendregistrationtoken";
		}
	}

	//resend token
	@RequestMapping(value = "/resendRegistrationToken", method = { RequestMethod.GET, RequestMethod.POST })
	public String resendRegistrationToken(Locale locale, registration_vo reg, HttpServletRequest request)
			throws Exception {

		final String token = UUID.randomUUID().toString();
		userService.resendVerificationTokenForUser(token, reg);

		final SimpleMailMessage email = constructEmailMessage(token, reg, locale, request);
		mailSender.send(email);

		return "/admin/resendToken";

	}

	// logout page
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		model.addAttribute("message", "Logout SuccessFully");
		return "/admin/userlogin";
	}
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
	@ResponseBody
	public int userinfo(user_vo ra) throws Exception {
		String userName = ra.getUser();
		userService.skills(ra, userName);
		return comDao.getuser_id(userName);
	}

	//user dashboard
	@RequestMapping(value = "/userdashboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String dashboard(@RequestParam("user_id") int userid, Model model) throws Exception {
		model.addAttribute("userid", userid);
		return "/dashboard";

	}
	
	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String dashboard(Model model,Principal principal) throws Exception{

		String username=principal.getName();
	    model.addAttribute("userid", comDao.getuser_id(username));
		return "/member/layout/memberheader";
    }


	// userprofile
		@RequestMapping(value = "/userdetail", method = { RequestMethod.GET, RequestMethod.POST })
		public String userprofile(@RequestParam("user_id") int userid, Model model, registration_vo reg) throws Exception {
			String username = reg.getEmail();
			model.addAttribute("role", comDao.getrole());
			model.addAttribute("country", comDao.getcountrydata());
			model.addAttribute("zone", comDao.getzonedata());
			model.addAttribute("image", comDao.getimage(userid));
			model.addAttribute("level", comDao.getexplevel());
			model.addAttribute("yearexp", comDao.getyearexp());
			model.addAttribute("username", username);
			model.addAttribute("userdetail", userService.getuserdetails(userid));
			model.addAttribute("userrole", userService.getuserrole(userid));
			model.addAttribute("userskill", userService.getuserSkills(userid));
			

			return "/userdetail";
		}

		// getskills
		@RequestMapping(value = "/getskills", method = { RequestMethod.GET, RequestMethod.POST })
		@ResponseBody
		public List getMachedNames(@RequestParam("term") String term) throws Exception {
			List matchName = userService.getuserSkill(term);
			return matchName;
		}

		// user details update
		@RequestMapping(value = "/userupdate", method = RequestMethod.POST)
		@ResponseBody
		public String userupdate(@RequestParam("user_id") int user_id, @RequestParam("file") MultipartFile file,
				registration_vo rvo, user_vo uvo, Model model) throws Exception {
			String fileName = null;
			model.addAttribute("user_id", rvo.getUser_id());
	       
	         if (!file.isEmpty()) {
				try {
					final String token = UUID.randomUUID().toString();
					System.out.println(token);
					fileName = file.getOriginalFilename();
					long filesize = file.getSize();
					byte[] bytes = file.getBytes();
					BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(
							new File("C:/Users/Diya/Documents/workspace-sts-3.7.3.RELEASE/raas/src/main/webapp/resources/common/images/"
									+ token + ".jpg")));
					buffStream.write(bytes);
					buffStream.close();
					userService.getuserdetails(rvo, uvo, file, token);
					
					return "redirect:userdetail";
				} catch (Exception e) {
					return "You failed to upload " + fileName + ": " + e.getMessage();
					
				}

			} else {
                
				userService.getuserdetail(rvo, uvo);
				return "redirect:userdetail";
				
			}
	        }
		

		// save skills
		@RequestMapping(value = "/saveskill", method = RequestMethod.POST)
		@ResponseBody
		public String saveskill(@RequestParam("user_id") int user_id, @RequestBody skill[] skills,skill skill) throws Exception {
			userService.insertskill(user_id, skills,skill);
	   
			return "redirect:userdetail";
		}
}