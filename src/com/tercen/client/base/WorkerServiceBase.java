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

public class WorkerServiceBase extends HttpClientService<Task> {

	public URI getBaseUri() {
		return URI.create("api/v1/worker");
	}

	String getServiceName() {
		return "Task";
	}

	LinkedHashMap toJson(Task object) {
		return object.toJson();
	}

	public Task fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return TaskBase.fromJson(m);
		return new Task(m);
	}

	public Object exec(Task task) throws ServiceError {
		Object answer = null;
		try {
			Response response;
			URI uri = URI.create("api/v1/worker" + "/" + "exec");
			LinkedHashMap params = new LinkedHashMap();
			params.put("task", task.toJson());
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

	public Object setPriority(double priority) throws ServiceError {
		Object answer = null;
		try {
			Response response;
			URI uri = URI.create("api/v1/worker" + "/" + "setPriority");
			LinkedHashMap params = new LinkedHashMap();
			params.put("priority", priority);
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

	public Object setStatus(String status) throws ServiceError {
		Object answer = null;
		try {
			Response response;
			URI uri = URI.create("api/v1/worker" + "/" + "setStatus");
			LinkedHashMap params = new LinkedHashMap();
			params.put("status", status);
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

	public Object setHeartBeat(int heartBeat) throws ServiceError {
		Object answer = null;
		try {
			Response response;
			URI uri = URI.create("api/v1/worker" + "/" + "setHeartBeat");
			LinkedHashMap params = new LinkedHashMap();
			params.put("heartBeat", heartBeat);
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

	public Worker getState(String all) throws ServiceError {
		Worker answer = null;
		try {
			Response response;
			URI uri = URI.create("api/v1/worker" + "/" + "getState");
			LinkedHashMap params = new LinkedHashMap();
			params.put("all", all);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = WorkerBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
			}
		} catch (Exception e) {
			onError(e);
		}
		return answer;
	}

}