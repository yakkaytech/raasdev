package com.chat;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class ChatController {
	
    
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(HelloMessage message) throws Exception {
		Date date = new Date();
		String time = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(date);
		return new OutputMessage(message.getFrom(),message.getText(),time);
	}
	
	@MessageMapping("/user")
	@SendTo("/topic/participants")
	public userList user(HelloMessage message) throws Exception {
	    String time = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date());
	    return new userList(message.getFrom(),time);
	}
	
}
