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

public class IssueMessageServiceBase extends HttpClientService<IssueMessage> {

	public URI getBaseUri() {
		return URI.create("api/v1/issue_message");
	}

	String getServiceName() {
		return "IssueMessage";
	}

	LinkedHashMap toJson(IssueMessage object) {
		return object.toJson();
	}

	public IssueMessage fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return IssueMessageBase.fromJson(m);
		return new IssueMessage(m);
	}

	public List<IssueMessage> findByIssueAndLastModifiedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findByIssueAndLastModifiedDate", startKey, endKey, limit, skip, descending, useFactory);
	}
}