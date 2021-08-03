package com.contact.book.security.exception;

public class GeneralException extends RuntimeException {

	
	private static final long serialVersionUID = -887922317632736028L;

	/**
	 * default constructor
	 */
	public GeneralException() {
		super();
	}

	/**
	 * @param message
	 */
	public GeneralException(String message) {
		super(message);
	}

}