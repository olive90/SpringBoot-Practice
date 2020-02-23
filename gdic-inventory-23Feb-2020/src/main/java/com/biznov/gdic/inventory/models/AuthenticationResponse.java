package com.biznov.gdic.inventory.models;

import org.springframework.http.HttpStatus;

public class AuthenticationResponse {

	private String jwt;
	
	private HttpStatus status;

	public AuthenticationResponse(String jwt, HttpStatus status) {
		super();
		this.jwt = jwt;
		this.status = status;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [jwt=" + jwt + ", status=" + status + "]";
	}

}
