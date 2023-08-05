package com.files.filesystem.exceptions;

public class FileException extends Exception {
	
	private String message;
	private Throwable th;

	public FileException(String message, Throwable th) {
		super(message, th);
		this.message = message;
		this.th = th;
	}

	public String getMessage() {
		return message;
	}

	public Throwable getException() {
		return th;
	}
}
