package org.grace.tutorial.ods.service;

import org.springframework.messaging.Message;

public class RejectErrorFilterService {

	 public boolean accept(Message<?> message){
		 if (message.getPayload().toString().isEmpty())
			 return false;
		 return true;
		 
	 }
}
