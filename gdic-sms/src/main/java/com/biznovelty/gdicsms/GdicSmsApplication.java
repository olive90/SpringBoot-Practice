package com.biznovelty.gdicsms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.biznovelty.gdicsms.apiclient.SmsReq;

@SpringBootApplication
public class GdicSmsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(GdicSmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GdicSmsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			SmsReq smsReq = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", SmsReq.class);
			log.info(smsReq.toString());
		};
	}

}
