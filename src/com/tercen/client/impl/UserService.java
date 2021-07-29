package com.tercen.client.impl;

import com.tercen.model.base.*;
import com.tercen.client.base.*;
import com.tercen.model.impl.*;
import com.tercen.service.ServiceError;

public class UserService extends UserServiceBase {

	public UserSession userSession;

	public UserSession connect2(String domain, String usernameOrEmail, String password) throws ServiceError {
		this.userSession = super.connect2(domain, usernameOrEmail, password);
		this.tercenClient.httpClient.setAuthorization(userSession.token.token);
		return userSession;
	}
}