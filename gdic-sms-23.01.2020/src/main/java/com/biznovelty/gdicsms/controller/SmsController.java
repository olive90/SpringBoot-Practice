package com.biznovelty.gdicsms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.biznovelty.gdicsms.GdicSmsApplication;
import com.biznovelty.gdicsms.apiclient.SmsReq;
import com.biznovelty.gdicsms.apiclient.SmsResponse;
import com.biznovelty.gdicsms.controller.smsresource.SmsResource;

@RestController
public class SmsController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SmsResource smsResource;

	SmsReq smsReq = new SmsReq();
	private SmsResponse smsResponse = new SmsResponse();

	private static final Logger log = LoggerFactory.getLogger(GdicSmsApplication.class);

//	private String uri = "https://sms.sslwireless.com/pushapi/dynamic/server.php?msisdn="+msisdn+"&sms="+sms_string+
//						"&user=greendelta&pass=GreenDelta@123&sid=GreenDeltaBrand&csmsid=123456789";

//	private String baseUri = "https://sms.sslwireless.com/pushapi/dynamic/server.php?";
	private String baseUri = "https://api.txtlocal.com/send/?";

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder, SmsResource smsResource) {
		return builder.build();
	}

	public SmsResponse getCallApi(String msisdn, String sms_string) throws Exception {

		String uri = baseUri + "&numbers=" + msisdn + "&message=" + sms_string;
		RestTemplate restTemplate = new RestTemplate();
		smsResponse = restTemplate.getForObject(uri, SmsResponse.class);
			log.info(smsResponse.toString());
		return smsResponse;
	}

}
