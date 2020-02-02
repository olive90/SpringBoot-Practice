package com.biznovelty.gdicsms.smsresource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biznovelty.gdicsms.apiclient.SmsReq;
import com.biznovelty.gdicsms.apiclient.SmsResponse;
import com.biznovelty.gdicsms.controller.SmsController;
import com.biznovelty.gdicsms.models.AuthenticationRequest;
import com.biznovelty.gdicsms.models.AuthenticationResponse;
import com.biznovelty.gdicsms.service.MyUserDetailsService;
import com.biznovelty.gdicsms.util.JwtUtil;

@RestController
public class SmsResource {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	private static final Logger log = LoggerFactory.getLogger(SmsResource.class);

	@PostMapping("/sms")
	public SmsResponse getRequest(@Validated @RequestBody SmsReq smsReq) throws Exception {

		SmsResponse smsResponse = new SmsResponse();

		if (smsReq != null) {
			SmsController contr = new SmsController();
			smsResponse = contr.getCallApi(smsReq.getReceipient(), smsReq.getMessage());
		}
		return smsResponse;

	}

	@RequestMapping(value = "/authenticate", method = {RequestMethod.POST, RequestMethod.OPTIONS})
	public ResponseEntity<?> creatAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorect username or password", e);
		}

		final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.genearteToken(userDetails);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Authorization", jwt);

		log.info(jwt);

		return ResponseEntity.ok().headers(responseHeaders).body(new AuthenticationResponse(jwt));
	}

}
