package br.com.ctrft.security.dto;

import java.util.Date;

public class PayloadDados {

	private String issuer;
	private Date issuerAt;
	private Date expiration;
	private String Subject;

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Date getIssuerAt() {
		return issuerAt;
	}

	public void setIssuerAt(Date issuerAt) {
		this.issuerAt = issuerAt;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

}
