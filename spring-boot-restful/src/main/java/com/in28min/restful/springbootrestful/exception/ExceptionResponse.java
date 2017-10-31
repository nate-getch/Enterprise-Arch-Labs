package com.in28min.restful.springbootrestful.exception;

import java.util.Date;

/*
standard exception with defined structure 
*/

public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;
	
	ExceptionResponse(Date timestamp,String message,String details ){
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
}
