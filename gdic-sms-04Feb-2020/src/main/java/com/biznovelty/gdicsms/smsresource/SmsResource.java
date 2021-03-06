package com.biznovelty.gdicsms.smsresource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biznovelty.gdicsms.apiclient.SmsReq;
import com.biznovelty.gdicsms.apiclient.SmsResponse;
import com.biznovelty.gdicsms.controller.SmsController;

@RestController
public class SmsResource {

	@RequestMapping(value = "/sms", method = {RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD})
	public SmsResponse getRequest(@Validated @RequestBody SmsReq smsReq) throws Exception {

		SmsResponse smsResponse = new SmsResponse();

		if (smsReq != null) {
			SmsController contr = new SmsController();
			smsResponse = contr.getCallApi(smsReq.getReceipient(), smsReq.getMessage());
		}
		return smsResponse;

	}

}
