package com.tylerejohnson.beans;

public class Message {
	
	private String message;
	
	public Message() {
		
	}
	
	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.getMessage();
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + "]";
	}
}
