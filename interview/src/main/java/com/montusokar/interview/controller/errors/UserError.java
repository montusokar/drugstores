package com.montusokar.interview.controller.errors;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class UserError {
	private HttpStatus status;
	private String message;
	private List<String> errors;

	public UserError() {
	}

	public UserError(HttpStatus status, String message, List<String> errors) {
		super();
		this.setStatus(status);
		this.setMessage(message);
		this.setErrors(errors);
	}

	public UserError(HttpStatus status, String message, String error) {
		super();
		this.setStatus(status);
		this.setMessage(message);
		setErrors(Arrays.asList(error));
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
