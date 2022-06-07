package com.example.controller.form;

import javax.validation.constraints.NotBlank;

public class LoginForm {
	
	@NotBlank
	private String logId;
	
	@NotBlank
	private String pass;

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
}