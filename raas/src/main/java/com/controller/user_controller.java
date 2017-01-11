package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URL;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dao.common_dao;
import com.dao.crtproject_dao;
import com.dao.user_dao;
import com.service.ProposalService;
import com.service.userService;
import com.vo.registration_vo;
import com.vo.skill;
import com.vo.user_vo;

@Controller

public class user_controller {

	@Autowired
	private common_dao comdao;

	@Autowired
	private userService userservice;

	@Autowired
	private user_dao radao;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private Environment env;
    
	@Autowired
	private ProposalService proposalservice;
	
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
	public String registration(Locale locale, registration_vo reg, Model model, Principal principal,
			HttpServletRequest request) throws Exception {
		userservice.registration(reg);
		final String token = UUID.randomUUID().toString();
		userservice.createVerificationTokenForUser(token, reg);

		final SimpleMailMessage email = constructEmailMessage(token, reg, locale, request);
		mailSender.send(email);

		model.addAttribute("view", comdao.role());
		model.addAttribute("view1", comdao.countrydata());
		model.addAttribute("view2", comdao.timezonedata());
		model.addAttribute("view3", comdao.zonedata());
		String username = reg.getEmail();
		model.addAttribute("user", username);
		model.addAttribute("user_id", comdao.getuser_id(username));
		return "/member/membernew";
	}

	//send email
	private final SimpleMailMessage constructEmailMessage(final String token, registration_vo reg, Locale locale,
			HttpServletRequest request) {

		final String recipientAddress = reg.getEmail();
		final String subject = "Registration Confirmation";
		final String email_id = reg.getEmail();

		final String Url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		final String confirmationUrl = Url + "/registrationconfirm?token=" + token + "&" + "email_id=" + email_id;
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText("You registered successfully. We will send you a confirmation message to your email account."
				+ " \r\n" + confirmationUrl);
		email.setFrom(env.getProperty("yakkaytech.world@gmail.com"));
		return email;
	}

	//confirm registration
	@RequestMapping(value = "/registrationconfirm", method = { RequestMethod.GET, RequestMethod.POST })
	public String confirmRegistration(@RequestParam("token") final String token,
			@RequestParam("email_id") final String email_id, registration_vo reg) throws Exception {

		final String gettoken = userservice.gettoken(email_id);
		if (token.equals(gettoken)) {
			userservice.reg_activation(token, reg, email_id);

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
		userservice.resendVerificationTokenForUser(token, reg);

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
	public int userinfo(user_vo ra, Principal principal) throws Exception {
		String userName = ra.getUser();
		userservice.skills(ra, userName);
		return comdao.getuser_id(userName);
	}

	//user dashboard
	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String dashboard(@RequestParam("user_id") int userid, user_vo ra, Model model) throws Exception {
		model.addAttribute("userid", userid);
		return "/dashboard";

	}

	@RequestMapping(value = "/userdetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String userprofile(@RequestParam("user_id") int userid, user_vo ra, Model model, registration_vo reg,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		model.addAttribute("view1", comdao.role());
		model.addAttribute("view2", comdao.countrydata());
		model.addAttribute("view3", comdao.zonedata());
		model.addAttribute("image", comdao.getimage(userid));
		String username = reg.getEmail();
		model.addAttribute("level", comdao.getexplevel());
		model.addAttribute("yearexp", comdao.getyearexp());
		model.addAttribute("username", username);
		model.addAttribute("userdetail", radao.getuserdetails(userid));
		model.addAttribute("userskill", radao.getuserskills(userid));
		return "/userdetail";
	}

	@RequestMapping(value = "/getskills", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public List getMachedNames(@RequestParam("term") String term) throws Exception {

		List matchName = userservice.getuserSkill(term);
		return matchName;
	}

	@RequestMapping(value = "/userupdate", method = RequestMethod.POST)

	public String userupdate(@RequestParam("user_id") int user_id, @RequestParam("file") MultipartFile file,
			registration_vo rvo, user_vo uvo, Model model) throws Exception {
		String fileName = null;
		model.addAttribute("user_id", rvo.getUser_id());
		if (!file.isEmpty()) {
			try {
				final String token = UUID.randomUUID().toString();
				fileName = file.getOriginalFilename();
				long filesize = file.getSize();
				byte[] bytes = file.getBytes();
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(
						"C:/Users/Diya/Documents/workspace-sts-3.7.3.RELEASE/raas/src/main/webapp/resources/common/images/"
								+ token + ".jpg")));

				buffStream.write(bytes);
				buffStream.close();

				userservice.getuserdetails(rvo, uvo, file, token);
				return "redirect:userdetail";
			} catch (Exception e) {
				return "You failed to upload " + fileName + ": " + e.getMessage();
			}

		} else {

			userservice.getuserdetail(rvo, uvo);
			return "redirect:userdetail";
		}

	}
	
	@RequestMapping(value="/saveskill", method = RequestMethod.POST)
    
    public  @ResponseBody String saveskill(@RequestParam("user_id") int user_id,@RequestBody skill[] skills) throws Exception{
          // System.out.println(userid);
       userservice.insertskill(user_id,skills);
       
     return "redirect:userdetail";
       
     }
	
    @RequestMapping(value="/deleteskill", method = RequestMethod.POST)
    
    public  @ResponseBody String deleteskill(@RequestParam("user_id") int user_id,skill skills) throws Exception{
          // System.out.println(userid);
       userservice.deleteskill(user_id,skills);
       
     return "redirect:userdetail";
       
     }
	
	@RequestMapping(value = "/userproposal", method = { RequestMethod.GET, RequestMethod.POST })
	
	public String proposal() throws Exception {
		 int userid=10;
		 proposalservice.getmyproposals(userid);
		
		return "/member/default/proposals.blade";
	}
	
}