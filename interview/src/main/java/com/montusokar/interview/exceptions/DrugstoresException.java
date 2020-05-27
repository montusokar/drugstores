package com.montusokar.interview.exceptions;

public class DrugstoresException extends Exception {

	private static final long serialVersionUID = -1333511653976093774L;

	public DrugstoresException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

	public DrugstoresException(String errorMessage) {
		super(errorMessage);
	}

}
