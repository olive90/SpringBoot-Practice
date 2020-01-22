package com.biznovelty.gdicsms.apiclient;

import java.net.URLEncoder;

public class SmsReq {
		
		private String username;
		private String password;
		private String action;
		private String timestamp;
		private String url;
		private String receipient = "01798786889";
		private String messagedata = "Hi buddy";
		private String status;
		
		public SmsReq() {
			
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getValuepassword() {
			return password;
		}

		public void setPassword(String valuepassword) {
			this.password = valuepassword;
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
			return "SmsReq [username=" + username + ", password=" + password + ", action=" + action + ", timestamp="
					+ timestamp + ", url=" + url + ", receipient=" + receipient + ", messagedata=" + messagedata + ", status=" + status + "]";
		}
		
}
