package com.tercen.client.base;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import com.tercen.service.ServiceError;
import tercen.tson.*;
import com.tercen.service.HttpClientService;
import com.tercen.model.base.*;
import com.tercen.model.impl.*;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserSecretServiceBase extends HttpClientService<UserSecret> {

	public URI getBaseUri() {
		return URI.create("api/v1/userSecret");
	}

	String getServiceName() {
		return "UserSecret";
	}

	LinkedHashMap toJson(UserSecret object) {
		return object.toJson();
	}

	public UserSecret fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return UserSecretBase.fromJson(m);
		return new UserSecret(m);
	}

	public List<UserSecret> findSecretByUserId(List keys, boolean useFactory) throws ServiceError {
		return findKeys("secret", keys, useFactory);
	}
}