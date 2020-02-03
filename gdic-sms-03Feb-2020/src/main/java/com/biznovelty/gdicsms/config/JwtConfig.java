package com.biznovelty.gdicsms.config;

import org.springframework.stereotype.Component;

@Component
public class JwtConfig {

	private String secret = "ABC123DEFBisunessNoveltyLimited2020XYZ321IJK";

	private String header = "Authorization";

	private String expiration = "24*60*60";

	private String prefix = "Gdic";

	public JwtConfig() {
		super();
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public String toString() {
		return "JwtConfig [secret=" + secret + ", header=" + header + ", expiration=" + expiration + ", prefix="
				+ prefix + "]";
	}

}
