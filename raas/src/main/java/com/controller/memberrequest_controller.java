package com.controller;

import java.security.Principal;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.common_dao;
import com.service.memberRequestService;
import com.vo.memberRequest_vo;
import com.vo.registration_vo;
import com.wrapper.wrapper;

@Controller
public class memberrequest_controller {

	@Autowired
	private memberRequestService memberrequest_service;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private Environment env;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private common_dao comdao;

	
	//send memberrequest
	@RequestMapping(value = "/member_req", method = { RequestMethod.GET, RequestMethod.POST })
	public String memberrequest(Locale locale, memberRequest_vo req, Model model, Principal principal,
			HttpServletRequest request) throws Exception {
		String username = principal.getName();
		model.addAttribute("user", username);
		int user_id = comdao.getuser_id(username);
		List<wrapper> newlist = memberrequest_service.getmessage();
		int message_id = newlist.get(0).getMessage_id();
		final String token = UUID.randomUUID().toString();
		System.out.println(token);
		memberrequest_service.createVerificationTokenForUser(token, req, user_id);
		final SimpleMailMessage email = constructEmailMessage(token, principal, req, locale, request);
		mailSender.send(email);
		return "/job/proposal";
	}
    //send email
	private final SimpleMailMessage constructEmailMessage(final String token, Principal principal, memberRequest_vo req,
			Locale locale, HttpServletRequest request) throws Exception {
		String username = principal.getName();
		int user_id = comdao.getuser_id(username);
		final String recipientAddress = req.getEmail();
		final String subject = "Registration Confirmation";
		final String email_id = req.getEmail();
		final String from = "yakkaytech.world@gmail.com";

		List<wrapper> newlist = memberrequest_service.getmessage();
		int message_id = newlist.get(0).getMessage_id();
		String message = newlist.get(0).getMessage();

		System.out.println("message" + message + "  " + message_id);
		System.out.println(this.messageSource.getMessage("greeting", null, "Default greeting", null));
		final String Url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();
		final String confirmationUrl = Url + "/registrationConfirm?token=" + token + "&" + "email_id=" + email_id;
		// final String messages = messageSource.getMessage("greeting",
		// null,messages);
		// System.out.println("messages"+messages);
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message + " \r\n" + confirmationUrl);
		email.setFrom(env.getProperty("yakkaytech.world@gmail.com"));
		memberrequest_service.saveemailcopy(email, email_id, from, user_id, message_id);
		return email;
	}

}
