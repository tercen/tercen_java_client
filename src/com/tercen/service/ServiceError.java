package com.tercen.service;

import java.util.LinkedHashMap;

public class ServiceError extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	{statusCode: 400, error: Project.name.not.available, reason: The name is already in use, please choose another name.}

	int statusCode;
	String error;
	String reason;

	public ServiceError(String reason) {
		super(reason);

		this.statusCode = -42;
		this.error = "unknown";
		this.reason = reason;
	}

	public ServiceError(Exception error) {
		super(error.getMessage());

		this.statusCode = 500;
		this.error = "unknown";
		this.reason = error.getMessage();
	}

	public ServiceError(Object json) {
		super("");
		this.statusCode = -42;
		this.error = "unknown";
		this.reason = json.toString();

		if (json instanceof LinkedHashMap) {
			LinkedHashMap map = (LinkedHashMap) json;

			if (map.get("statusCode") != null && (Integer.class.isInstance(map.get("statusCode")))) {
				this.statusCode = (int) map.get("statusCode");
			}

			if (map.get("error") != null) {
				this.error = map.get("error").toString();

			}

			if (map.get("reason") != null) {
				this.reason = map.get("reason").toString();

			}

		}

	}

	public ServiceError(int statusCode, String error, String reason) {
		super(reason);

		this.statusCode = statusCode;
		this.error = error;
		this.reason = reason;
	}

	public String toString() {
		return "ServiceError(statusCode : " + statusCode + " -- error : " + error + " -- reason : " + reason + ")";
	}
}
