package com.biznovelty.gdicsms.apiclient;

import java.net.URLEncoder;

public class SmsResponse {
	
	private String username;
	private String password;
	private String action;
	private String timestamp;
	private String url;
	private String receipient = "01798786889";
	private String messagedata = "Hi Buddy";
	private String status;
	
	public SmsResponse() {
		
	}

	public SmsResponse(String username, String password, String action, String timestamp, String url, String receipient,
			String messagedata, String status) {
		super();
		this.username = username;
		this.password = password;
		this.action = action;
		this.timestamp = timestamp;
		this.url = url;
		this.receipient = receipient;
		this.messagedata = messagedata;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getReceipient() {
		return receipient;
	}

	public void setReceipient(String receipient) {
		this.receipient = receipient;
	}

	public String getMessagedata() {
		return URLEncoder.encode(messagedata);
	}

	public void setMessagedata(String messagedata) {
		this.messagedata = messagedata;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SmsResponse [username=" + username + ", password=" + password + ", action=" + action + ", timestamp="
				+ timestamp + ", url=" + url + ", receipient=" + receipient + ", messagedata=" + messagedata + ", status=" + status + "]";
	}
	
}
