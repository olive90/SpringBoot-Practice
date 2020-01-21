package com.biznovelty.gdicsms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biznovelty.gdicsms.apiclient.SmsReq;
import com.biznovelty.gdicsms.apiclient.SmsResponse;

@RestController
public class SmsRequestController {
	
	@Autowired
	private SmsController smsController;
	
	@PostMapping("/sms")
	public void getRequest(@RequestBody SmsReq smsReq) {
		
		smsController.getClass();
		
		SmsResponse smsResponse = new SmsResponse();
		
		if(smsReq != null) {
			smsResponse.setReceipient(smsReq.getReceipient());
			smsResponse.setMessage(smsReq.getMessage());
		}
		
	}

}
