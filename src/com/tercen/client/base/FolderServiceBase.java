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

public class FolderServiceBase extends HttpClientService<FolderDocument> {

	public URI getBaseUri() {
		return URI.create("api/v1/folder");
	}

	String getServiceName() {
		return "FolderDocument";
	}

	LinkedHashMap toJson(FolderDocument object) {
		return object.toJson();
	}

	public FolderDocument fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return FolderDocumentBase.fromJson(m);
		return new FolderDocument(m);
	}

	public List<FolderDocument> findFolderByParentFolderAndName(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findFolderByParentFolderAndName", startKey, endKey, limit, skip, descending, useFactory);
	}

	public FolderDocument getOrCreate(String projectId, String path) throws ServiceError {
		FolderDocument answer = null;
		try {
			Response response;
			URI uri = URI.create("api/v1/folder" + "/" + "getOrCreate");
			LinkedHashMap params = new LinkedHashMap();
			params.put("projectId", projectId);
			params.put("path", path);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = FolderDocumentBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
			}
		} catch (Exception e) {
			onError(e);
		}
		return answer;
	}

}