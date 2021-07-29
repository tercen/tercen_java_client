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

public class GarbageCollectorServiceBase extends HttpClientService<GarbageObject> {

	public URI getBaseUri() {
		return URI.create("api/v1/gc");
	}

	String getServiceName() {
		return "GarbageObject";
	}

	LinkedHashMap toJson(GarbageObject object) {
		return object.toJson();
	}

	public GarbageObject fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return GarbageObjectBase.fromJson(m);
		return new GarbageObject(m);
	}

}