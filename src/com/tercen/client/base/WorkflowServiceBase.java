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

public class WorkflowServiceBase extends HttpClientService<Workflow> {

	public URI getBaseUri() {
		return URI.create("api/v1/workflow");
	}

	String getServiceName() {
		return "Workflow";
	}

	LinkedHashMap toJson(Workflow object) {
		return object.toJson();
	}

	public Workflow fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return WorkflowBase.fromJson(m);
		return new Workflow(m);
	}

	public CubeQuery getCubeQuery(String workflowId, String stepId) throws ServiceError {
		CubeQuery answer = null;
		try {
			Response response;
			URI uri = URI.create("api/v1/workflow" + "/" + "getCubeQuery");
			LinkedHashMap params = new LinkedHashMap();
			params.put("workflowId", workflowId);
			params.put("stepId", stepId);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = CubeQueryBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
			}
		} catch (Exception e) {
			onError(e);
		}
		return answer;
	}

	public Workflow copy(String workflowId) throws ServiceError {
		Workflow answer = null;
		try {
			Response response;
			URI uri = URI.create("api/v1/workflow" + "/" + "copy");
			LinkedHashMap params = new LinkedHashMap();
			params.put("workflowId", workflowId);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = WorkflowBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
			}
		} catch (Exception e) {
			onError(e);
		}
		return answer;
	}

	public Workflow cloneWorkflow(String workflowId, String teamId, String projectId) throws ServiceError {
		Workflow answer = null;
		try {
			Response response;
			URI uri = URI.create("api/v1/workflow" + "/" + "cloneWorkflow");
			LinkedHashMap params = new LinkedHashMap();
			params.put("workflowId", workflowId);
			params.put("teamId", teamId);
			params.put("projectId", projectId);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = WorkflowBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
			}
		} catch (Exception e) {
			onError(e);
		}
		return answer;
	}

}