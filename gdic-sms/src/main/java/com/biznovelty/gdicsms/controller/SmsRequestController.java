package com.biznovelty.gdicsms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biznovelty.gdicsms.apiclient.SmsReq;
import com.biznovelty.gdicsms.apiclient.SmsResponse;

@RestController
public class SmsRequestController {
	
	@Autowired
	private SmsController smsController;
	
	@PostMapping("/sms")
	public void getRequest() {
		
		SmsReq smsReq = new SmsReq();
//		smsReq.getReceipient();
//		smsReq.getMessagedata();
		
		SmsResponse smsResponse = new SmsResponse();
		
		if(smsReq != null) {
			smsResponse.setReceipient(smsReq.getReceipient());
			smsResponse.setMessagedata(smsReq.getMessagedata());
		}
		System.out.println(smsResponse);
	}

}
