package com.biznovelty.gdicsms;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.biznovelty.gdicsms.apiclient.MailReq;
import com.biznovelty.gdicsms.controller.EmailController;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateNotFoundException;

class TestEmailApi {
	
	EmailController emailController = new EmailController();
	MailReq req = new MailReq();
	
	@Test
	public void testMailRequest() {
		assertEquals(getClass(), req.toString());
	}

	@Test
	public void testSendEmail() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
		
		assertEquals(getClass(), emailController.sendEmail(req));
		
	}

}
