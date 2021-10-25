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

public class IssueServiceBase extends HttpClientService<Issue> {

	public URI getBaseUri() {
		return URI.create("api/v1/issue");
	}

	String getServiceName() {
		return "Issue";
	}

	LinkedHashMap toJson(Issue object) {
		return object.toJson();
	}

	public Issue fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return IssueBase.fromJson(m);
		return new Issue(m);
	}

	public List<Issue> findByProjectAndLastModifiedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findByProjectAndLastModifiedDate", startKey, endKey, limit, skip, descending, useFactory);
	}
}