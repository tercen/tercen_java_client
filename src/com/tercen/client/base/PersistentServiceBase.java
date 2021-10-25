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

public class PersistentServiceBase extends HttpClientService<PersistentObject> {

	public URI getBaseUri() {
		return URI.create("api/v1/po");
	}

	String getServiceName() {
		return "PersistentObject";
	}

	LinkedHashMap toJson(PersistentObject object) {
		return object.toJson();
	}

	public PersistentObject fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return PersistentObjectBase.fromJson(m);
		return new PersistentObject(m);
	}

	public List<PersistentObject> findWorkflowByTask(List keys, boolean useFactory) throws ServiceError {
		return findKeys("findWorkflowByTask", keys, useFactory);
	}

	public List<PersistentObject> findDeleted(List keys, boolean useFactory) throws ServiceError {
		return findKeys("findDeleted", keys, useFactory);
	}

	public List<PersistentObject> findByKind(List keys, boolean useFactory) throws ServiceError {
		return findKeys("findByKind", keys, useFactory);
	}

	public Summary summary(String teamOrProjectId) throws ServiceError {
		Summary answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/po" + "/" + "summary");
			LinkedHashMap params = new LinkedHashMap();
			params.put("teamOrProjectId", teamOrProjectId);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = SummaryBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
			}
		} catch (Exception e) {
			onError(e);
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return answer;
	}

}