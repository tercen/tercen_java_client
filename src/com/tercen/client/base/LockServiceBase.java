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

public class LockServiceBase extends HttpClientService<Lock> {

	public URI getBaseUri() {
		return URI.create("api/v1/lock");
	}

	String getServiceName() {
		return "Lock";
	}

	LinkedHashMap toJson(Lock object) {
		return object.toJson();
	}

	public Lock fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return LockBase.fromJson(m);
		return new Lock(m);
	}

	public Lock lock(String name, int wait) throws ServiceError {
		Lock answer = null;
		try {
			Response response;
			URI uri = URI.create("api/v1/lock" + "/" + "lock");
			LinkedHashMap params = new LinkedHashMap();
			params.put("name", name);
			params.put("wait", wait);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = LockBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
			}
		} catch (Exception e) {
			onError(e);
		}
		return answer;
	}

	public Object releaseLock(Lock lock) throws ServiceError {
		Object answer = null;
		try {
			Response response;
			URI uri = URI.create("api/v1/lock" + "/" + "releaseLock");
			LinkedHashMap params = new LinkedHashMap();
			params.put("lock", lock.toJson());
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = null;
			}
		} catch (Exception e) {
			onError(e);
		}
		return answer;
	}

}