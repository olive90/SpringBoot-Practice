package com.biznovelty.gdicsms.apiclient;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SmsReq {
		
		private String username;
		private String password;
		private String action;
		private String timestamp;
		private String url;
		@NotNull
		@Size(min=11, message="Receipient should have at least 11 numbers")
		private String receipient;
		@Size(min=5, message="Message should have at least 5 characters")
		private String message;
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

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
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
					+ timestamp + ", url=" + url + ", receipient=" + receipient + ", message=" + message + ", status=" + status + "]";
		}
		
}
