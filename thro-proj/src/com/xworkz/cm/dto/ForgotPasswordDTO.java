package com.xworkz.cm.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.xworkz.cm.controller.ForgotPasswordController;




public class ForgotPasswordDTO implements Serializable{
	
	private String email;
	
	private static final Logger logger = Logger.getLogger(ForgotPasswordController.class);

	

	public ForgotPasswordDTO() {
		logger.info("created \t" + this.getClass().getSimpleName());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ForgotDTO [email=" + email + "]";
	}

	public ForgotPasswordDTO(String email) {
		this.email = email;
	}

}
