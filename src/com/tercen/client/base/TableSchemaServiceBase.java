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

public class TableSchemaServiceBase extends HttpClientService<Schema> {

	public URI getBaseUri() {
		return URI.create("api/v1/schema");
	}

	String getServiceName() {
		return "Schema";
	}

	LinkedHashMap toJson(Schema object) {
		return object.toJson();
	}

	public Schema fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return SchemaBase.fromJson(m);
		return new Schema(m);
	}

	public List<Schema> findByQueryHash(List keys, boolean useFactory) throws ServiceError {
		return findKeys("findByQueryHash", keys, useFactory);
	}

	public List<Schema> findSchemaByDataDirectory(List startKey, List endKey, int limit, int skip, boolean descending,
			boolean useFactory) throws ServiceError {
		return findStartKeys("findSchemaByDataDirectory", startKey, endKey, limit, skip, descending, useFactory);
	}

	public Table select(String tableId, List<String> cnames, int offset, int limit) throws ServiceError {
		Table answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/schema" + "/" + "select");
			LinkedHashMap params = new LinkedHashMap();
			params.put("tableId", tableId);
			params.put("cnames", cnames);
			params.put("offset", offset);
			params.put("limit", limit);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = TableBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
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

	public Table selectPairwise(String tableId, List<String> cnames, int offset, int limit) throws ServiceError {
		Table answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/schema" + "/" + "selectPairwise");
			LinkedHashMap params = new LinkedHashMap();
			params.put("tableId", tableId);
			params.put("cnames", cnames);
			params.put("offset", offset);
			params.put("limit", limit);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = TableBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
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