package com.biznovelty.gdicsms.service;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.biznovelty.gdicsms.apiclient.MailReq;
import com.biznovelty.gdicsms.apiclient.MailResponse;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import io.jsonwebtoken.io.IOException;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Configuration config;
	
	private static final Logger log = LoggerFactory.getLogger(EmailService.class);

	public MailResponse sendEmail(MailReq request, Map<String, Object> model)
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, java.io.IOException {
		MailResponse response = new MailResponse();
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			// set Media Type
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			// add attachment
//			helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

			Template t = config.getTemplate("email-template.html");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			helper.setTo(request.getTo());
//			helper.setText(html, true);		//Uncomment if you want to send email template and comment the 2nd line
			helper.setText(request.getPlaintext_message());		//for sending simple plaintext message
			helper.setSubject(request.getSubject());
			helper.setFrom(request.getFrom());
			javaMailSender.send(message);

			response.setMessage("Mail send to: " + request.getTo());
			response.setStatus(Boolean.TRUE);
			log.info(response.toString());
		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail sending failure: " + e.getMessage());
			response.setStatus(Boolean.FALSE);
			log.info(response.toString());
		}
		return response;
	}

}
