package com.biznovelty.gdicsms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biznovelty.gdicsms.apiclient.MailReq;
import com.biznovelty.gdicsms.apiclient.MailResponse;
import com.biznovelty.gdicsms.service.EmailService;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateNotFoundException;

@RestController
public class EmailController {

	@Autowired
	private EmailService service;

	@RequestMapping(value = "/sendemail", method = {RequestMethod.POST, RequestMethod.OPTIONS})
	public MailResponse sendEmail(@Validated @RequestBody MailReq request)
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
		Map<String, Object> model = new HashMap<>();
		model.put("location", "Dhaka,Bangladesh");
		return service.sendEmail(request, model);
	}

}
