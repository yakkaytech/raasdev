package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.message_dao;
import com.service.message_service;
import com.vo.message_vo;
import com.wrapper.wrapper;


@Controller
public class message_controller {
	
	@Autowired
    private message_dao messagedao;
    
	@Autowired
	private message_service messageservice;
	
	@RequestMapping(value = "/chat", method = {RequestMethod.GET, RequestMethod.POST })
	public String chatPage(message_vo msg,Model model,Principal principal,HttpServletRequest request,String userName) throws Exception {
				
		HttpSession session = request.getSession(true);
		String username = principal.getName();
		session.setAttribute("username", username);
		model.addAttribute("user", messagedao.userlist(username,msg));
		model.addAttribute("messages",messagedao.messages(msg));
	  	
        return "/chat";                
    }	
	
	@RequestMapping(value = "/conversations", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String messages(message_vo msg, Model model,HttpServletRequest request,String userName,Principal principal) throws Exception {
		HttpSession session = request.getSession(true);
		String username = principal.getName();
		session.setAttribute("username", username);			
		model.addAttribute("messages",messagedao.message(msg,username));
		
		return "true";	
	}
	
	@RequestMapping(value = "/typing", method = {RequestMethod.GET, RequestMethod.POST })
	public String typing(Model model,Principal principal,HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		String username = principal.getName();
		session.setAttribute("user", username);
		return "/typing";
	}
	
	@RequestMapping(value = "/messages", method = {RequestMethod.GET, RequestMethod.POST })
    public String getmessages(Model model,Principal principal,message_vo msg,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession(true);
		String username=principal.getName();
		session.setAttribute("username", username);
		model.addAttribute("usermessage",messageservice.getUserMessages(username,msg));
		return "/mail";
	}
	
	@RequestMapping(value = "/messageview", method = {RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
	public String viewmessage(Model model,message_vo msg) throws Exception{
				
	    int message_id=msg.getMessage_id();
		model.addAttribute("viewmsgbyId", messageservice.getMessageById(message_id));
		return messageservice.getMessageById(message_id);
	}
	
	@RequestMapping(value = "/send", method = {RequestMethod.GET, RequestMethod.POST })
    public String initmessage(Model model,Principal principal,message_vo msg) throws Exception{
		String username=principal.getName();				
	   messageservice.SendMessage(msg, username);
		return "redirect:messages";
	}
	
	
	@RequestMapping(value = "/sendmsg", method = {RequestMethod.GET, RequestMethod.POST })
    public String sendmessage(Model model,Principal principal,message_vo msg) throws Exception{
		String username=principal.getName();				
		model.addAttribute("usermessage",messageservice.getUserMessagebycreated(username));
		return "/mail";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String deletemessage(@RequestParam("message_id") int message_id,message_vo msg,Model model,Principal principal) throws Exception{
		
		String username=principal.getName();
		
		return messageservice.deletemessage(message_id,username);
	}
	
	    
}
