package com.controller;

import java.security.Principal;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.common_dao;
import com.service.memberrequest_service;
import com.vo.memberRequest_vo;
import com.wrapper.wrapper;

@Controller
public class memberrequest_controller {

	@Autowired
	private memberrequest_service memberRequestService;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private Environment environment;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private common_dao comDao;

	
	//send memberrequest
	@RequestMapping(value = "/member_req", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public  String memberrequest(Locale locale, memberRequest_vo req, Model model, Principal principal,
			HttpServletRequest request) throws Exception {
		
		
		
		
		
		String username = principal.getName();
		model.addAttribute("user", username);
		int user_id = comDao.getuser_id(username);
		List<wrapper> newlist = memberRequestService.getmessage();
		int message_id = newlist.get(0).getMessage_id();
		final String token = UUID.randomUUID().toString();
	final String result = memberRequestService.createVerificationTokenForUser(token, req, user_id);
	
		final SimpleMailMessage email = constructEmailMessage(token, principal, req, locale, request);
		if(result == "true"){
		mailSender.send(email);
		}
		return result;
	}
    //send email
	private final SimpleMailMessage constructEmailMessage(final String token, Principal principal, memberRequest_vo req,
			Locale locale, HttpServletRequest request) throws Exception {
		
		String username = principal.getName();
		int user_id = comDao.getuser_id(username);
		final String recipientAddress = req.getEmail();
		final String subject =  messageSource.getMessage("message.register", null, Locale.US);
		final String email_id = req.getEmail();

		List<wrapper> newlist = memberRequestService.getmessage();
		int message_id = newlist.get(0).getMessage_id();
		String message = newlist.get(0).getMessage();

		final String Url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		final String confirmationUrl = Url + "/registrationConfirm?token=" + token + "&" + "email_id=" + email_id;
		// final String messages = messageSource.getMessage("greeting",
		// null,messages);
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message + " \r\n" + confirmationUrl);
		email.setFrom(environment.getProperty("support.email"));
		memberRequestService.saveemailcopy(email, email_id, user_id, message_id);
		return email;
	}

}
