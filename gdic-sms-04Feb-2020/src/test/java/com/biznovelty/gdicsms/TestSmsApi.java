package com.biznovelty.gdicsms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.biznovelty.gdicsms.controller.SmsController;

class TestSmsApi {
	
	SmsController smsController = new SmsController();

	@Test
	public void testCallApi() throws Exception {
		assertEquals(getClass(), smsController.getCallApi("01798786889", "Hello brother"));
	}

}
