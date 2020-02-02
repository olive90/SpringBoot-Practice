package com.biznovelty.gdicsms.config;

import org.springframework.beans.factory.annotation.Value;

public class JwtConfig {
	
	@Value("{security.jwt.secret:ABC123DEFBisunessNoveltyLimited2020XYZ321IJK}")
	private String secret;
	@Value("{security.jwt.header:Authorization}")
	private String header;
	@Value("{security.jwt.expiration:#{24*60*60}}")
	private String expiration;
	@Value("{security.jwt.prefix:Gdic}")
	private String prefix;
	
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
