package com.biznovelty.gdicsms.controller;

import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.biznovelty.gdicsms.GdicSmsApplication;
import com.biznovelty.gdicsms.apiclient.SmsReq;
import com.biznovelty.gdicsms.apiclient.SmsResponse;

@RestController
public class SmsController {

	@Autowired
	RestTemplate restTemplate;
	
	SmsReq smsReq = new SmsReq();
	SmsResponse smsResponse = new SmsResponse();

	private static final Logger log = LoggerFactory.getLogger(GdicSmsApplication.class);

//	private String msisdn = "01798786889";
//	private String sms_string = "HI Buddy";
	private String apiKey = "apikey=" + "oc049B+8HAk-r8mWJziExn3r8JXWNlZooSos7eWFT9";
//	private String message = "&message=" + "This is your message";
	private String sender = "&sender=" + "Olive Hasan";
//	private String numbers = "&numbers=" + "01798786889";

//	private String uri = "https://sms.sslwireless.com/pushapi/dynamic/server.php?msisdn="+msisdn+"&sms="+URLEncoder.encode(sms_string)+
//						"&user=biznovelty&pass=123456@123&sid=biznoveltybrand&csmsid=123456789";

	private String uri = "https://api.txtlocal.com/send/?" + apiKey + "&numbers=" + smsResponse.getReceipient() + "&message=" + smsResponse.getMessagedata() + sender;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			SmsResponse smsResponse = restTemplate.getForObject(uri, SmsResponse.class);
			log.info(smsResponse.toString());
		};
	}

}
