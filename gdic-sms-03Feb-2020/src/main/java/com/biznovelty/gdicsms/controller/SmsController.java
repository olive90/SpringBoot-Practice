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
import com.biznovelty.gdicsms.smsresource.SmsResource;

@RestController
public class SmsController {

	private String user = "greendelta";
	private String password = "GreenDelta@123";
	private String sid = "GreenDeltaBrand";
	private String csmsid = "123456789";

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SmsResource smsResource;

	SmsReq smsReq = new SmsReq();
	private SmsResponse smsResponse = new SmsResponse();

	private static final Logger log = LoggerFactory.getLogger(GdicSmsApplication.class);

	//Uncomment this line to open the gateway
//	private String baseUri = "https://sms.sslwireless.com/pushapi/dynamic/server.php?";
	
	private String baseUri = "https://api.txtlocal.com/send/?";	//test uri

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder, SmsResource smsResource) {
		return builder.build();
	}

	public SmsResponse getCallApi(String msisdn, String sms_string) throws Exception {

		String uri = baseUri + "msisdn=" + msisdn + "&sms=" + sms_string + "&user=" + user + "&pass=" + password
				+ "&sid=" + sid + "&csmsid=" + csmsid;
		System.out.println(uri);
		RestTemplate restTemplate = new RestTemplate();
		smsResponse = restTemplate.getForObject(uri, SmsResponse.class);
		log.info(smsResponse.toString());
		return smsResponse;
	}

}
