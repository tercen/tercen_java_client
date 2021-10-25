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

public class DocumentServiceBase extends HttpClientService<Document> {

	public URI getBaseUri() {
		return URI.create("api/v1/d");
	}

	String getServiceName() {
		return "Document";
	}

	LinkedHashMap toJson(Document object) {
		return object.toJson();
	}

	public Document fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return DocumentBase.fromJson(m);
		return new Document(m);
	}

	public List<Document> findProjectByOwnersAndName(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findProjectByOwnersAndName", startKey, endKey, limit, skip, descending, useFactory);
	}

	public List<Document> findProjectByOwnersAndCreatedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findProjectByOwnersAndCreatedDate", startKey, endKey, limit, skip, descending,
				useFactory);
	}

	public List<Document> findWorkflowByTagOwnerCreatedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findWorkflowByTagOwnerCreatedDate", startKey, endKey, limit, skip, descending,
				useFactory);
	}

	public List<Document> findOperatorByOwnerLastModifiedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findOperatorByOwnerLastModifiedDate", startKey, endKey, limit, skip, descending,
				useFactory);
	}

	public List<Document> findOperatorByCreatedDate(List startKey, List endKey, int limit, int skip, boolean descending,
			boolean useFactory) throws ServiceError {
		return findStartKeys("findOperatorByCreatedDate", startKey, endKey, limit, skip, descending, useFactory);
	}

	public SearchResult search(String query, int limit, boolean useFactory, String bookmark) throws ServiceError {
		SearchResult answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/d" + "/" + "search");
			LinkedHashMap params = new LinkedHashMap();
			params.put("query", query);
			params.put("limit", limit);
			params.put("useFactory", useFactory);
			params.put("bookmark", bookmark);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = SearchResultBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
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

	public List<Operator> getTercenOperatorLibrary(int offset, int limit) throws ServiceError {
		List<Operator> answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/d" + "/" + "getTercenOperatorLibrary");
			LinkedHashMap params = new LinkedHashMap();
			params.put("offset", offset);
			params.put("limit", limit);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = null; // not impl
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

	public List<Document> getTercenWorkflowLibrary(int offset, int limit) throws ServiceError {
		List<Document> answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/d" + "/" + "getTercenWorkflowLibrary");
			LinkedHashMap params = new LinkedHashMap();
			params.put("offset", offset);
			params.put("limit", limit);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = null; // not impl
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

	public List<Document> getTercenAppLibrary(int offset, int limit) throws ServiceError {
		List<Document> answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/d" + "/" + "getTercenAppLibrary");
			LinkedHashMap params = new LinkedHashMap();
			params.put("offset", offset);
			params.put("limit", limit);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = null; // not impl
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