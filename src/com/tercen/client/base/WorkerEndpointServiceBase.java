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

public class WorkerEndpointServiceBase extends HttpClientService<WorkerEndpoint> {

	public URI getBaseUri() {
		return URI.create("api/v1/machine");
	}

	String getServiceName() {
		return "WorkerEndpoint";
	}

	LinkedHashMap toJson(WorkerEndpoint object) {
		return object.toJson();
	}

	public WorkerEndpoint fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return WorkerEndpointBase.fromJson(m);
		return new WorkerEndpoint(m);
	}

	public List<WorkerEndpoint> findWorkerEndpointByOwner(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findWorkerEndpointByOwner", startKey, endKey, limit, skip, descending, useFactory);
	}
}