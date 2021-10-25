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

public class CranLibraryServiceBase extends HttpClientService<RLibrary> {

	public URI getBaseUri() {
		return URI.create("api/v1/rlib");
	}

	String getServiceName() {
		return "RLibrary";
	}

	LinkedHashMap toJson(RLibrary object) {
		return object.toJson();
	}

	public RLibrary fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return RLibraryBase.fromJson(m);
		return new RLibrary(m);
	}

	public List<RLibrary> findByOwner(List keys, boolean useFactory) throws ServiceError {
		return findKeys("findByOwner", keys, useFactory);
	}

	public List<RLibrary> findByFileId(List keys, boolean useFactory) throws ServiceError {
		return findKeys("findByFileId", keys, useFactory);
	}

	public List<RLibrary> findByOwnerNameVersion(List startKey, List endKey, int limit, int skip, boolean descending,
			boolean useFactory) throws ServiceError {
		return findStartKeys("findByOwnerNameVersion", startKey, endKey, limit, skip, descending, useFactory);
	}
}