package com.hsbc.group.tooling.gqep.controller;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Component
@ApiModel(description = "Model For User")
public class Responsemessage
{

	@ApiModelProperty(notes = "Response message to mail", name="message",example = "Mail Send")
	String message;

	
	
	
	public Responsemessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Responsemessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	
	
	
}