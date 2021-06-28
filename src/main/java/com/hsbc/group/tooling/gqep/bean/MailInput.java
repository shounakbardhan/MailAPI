package com.hsbc.group.tooling.gqep.bean;

import org.springframework.stereotype.Component;

@Component
public class MailInput
{

	private String tomail;
	private String frommail;
	private String subject;
	private String body;
	private String cc;
	
	
	
	
	
	public MailInput() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public MailInput(String tomail, String frommail, String subject, String body) {
		super();
		this.tomail = tomail;
		this.frommail = frommail;
		this.subject = subject;
		this.body = body;
	}

	
	

	public String getCc() {
		return cc;
	}


	public void setCc(String cc) {
		this.cc = cc;
	}


	public String getTomail() {
		return tomail;
	}
	public void setTomail(String tomail) {
		this.tomail = tomail;
	}
	public String getFrommail() {
		return frommail;
	}
	public void setFrommail(String frommail) {
		this.frommail = frommail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
}