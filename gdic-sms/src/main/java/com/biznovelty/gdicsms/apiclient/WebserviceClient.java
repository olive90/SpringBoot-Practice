package com.biznovelty.gdicsms.apiclient;

import org.apache.catalina.WebResource;
import org.springframework.http.MediaType;

import ch.qos.logback.core.net.server.Client;

public class WebserviceClient {
	
	public static SmsResponse getSmsResponse(SmsReq smsReq)
	{
		try {
			
			//HttpAuthenticationFeature auth = HttpAuthenticationFeature.basic("admin", password);

			Client client = Client.create();

			WebResource webResource = client.resource("https://gturnquist-quoters.cfapps.io/api/random");

		//	QuotationInfoReq quotationInfoReq=new QuotationInfoReq();
			//quotationInfoReq.setDefult();

			SmsResponse response = webResource.type(MediaType.APPLICATION_JSON).header("Authorization", "Basic ")
			   .post(SmsResponse.class, smsReq);
			
//			System.out.println(response.getStatus());
//
//			if (response.getStatus() != 200) {
//				throw new RuntimeException("Failed : HTTP error code : "
//				     + response.getStatus());
//			}

			System.out.println("Output from Server .... \n");
			SmsResponse output = response.getEntity(SmsResponse.class);
			System.out.println(output);
			return output;

		  } catch (Exception e) {

			e.printStackTrace();
			return null;

		  }
	}

}
