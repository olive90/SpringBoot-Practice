package com.biznovelty.gdicsms.apiclient;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MailReq {
	
	@NotNull
	private String to;
	@NotNull
	private String from;
	@NotNull
	@Size(min=5, message="Subject should have at least 5 characters")
	private String subject;
	@NotNull
	@Size(min=10, message="Message should have at least 10 characters")
	private String plaintext_message;

	public MailReq() {
		super();
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPlaintext_message() {
		return plaintext_message;
	}

	public void setPlaintext_message(String plaintext_message) {
		this.plaintext_message = plaintext_message;
	}

	@Override
	public String toString() {
		return "MailReq [to=" + to + ", from=" + from + ", subject=" + subject + ", plaintext_message="
				+ plaintext_message + "]";
	}

}
