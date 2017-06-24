package com.smalik.sample;

public class Payload {
	
	private String name;
	private String message;
	
	public Payload() { }
	public Payload(String name, String message) {
		this.name = name;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
