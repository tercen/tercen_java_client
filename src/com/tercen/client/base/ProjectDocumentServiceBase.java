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

public class ProjectDocumentServiceBase extends HttpClientService<ProjectDocument> {

	public URI getBaseUri() {
		return URI.create("api/v1/pd");
	}

	String getServiceName() {
		return "ProjectDocument";
	}

	LinkedHashMap toJson(ProjectDocument object) {
		return object.toJson();
	}

	public ProjectDocument fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return ProjectDocumentBase.fromJson(m);
		return new ProjectDocument(m);
	}

	public List<ProjectDocument> findProjectObjectsByLastModifiedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findProjectObjectsByLastModifiedDate", startKey, endKey, limit, skip, descending,
				useFactory);
	}

	public List<ProjectDocument> findProjectObjectsByFolderAndName(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findProjectObjectsByFolderAndName", startKey, endKey, limit, skip, descending,
				useFactory);
	}

	public List<ProjectDocument> findFileByLastModifiedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findFileByLastModifiedDate", startKey, endKey, limit, skip, descending, useFactory);
	}

	public List<ProjectDocument> findSchemaByLastModifiedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findSchemaByLastModifiedDate", startKey, endKey, limit, skip, descending, useFactory);
	}

	public List<ProjectDocument> findSchemaByOwnerAndLastModifiedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findSchemaByOwnerAndLastModifiedDate", startKey, endKey, limit, skip, descending,
				useFactory);
	}

	public List<ProjectDocument> findFileByOwnerAndLastModifiedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findFileByOwnerAndLastModifiedDate", startKey, endKey, limit, skip, descending,
				useFactory);
	}

	public List<ProjectDocument> findWorkflowBySchema(List keys, boolean useFactory) throws ServiceError {
		return findKeys("findWorkflowBySchema", keys, useFactory);
	}

	public List<ProjectDocument> findWorkflowByOperator(List keys, boolean useFactory) throws ServiceError {
		return findKeys("findWorkflowByOperator", keys, useFactory);
	}

	public List<ProjectDocument> findWorkflowTemplateByOwnerCreatedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findWorkflowTemplateByOwnerCreatedDate", startKey, endKey, limit, skip, descending,
				useFactory);
	}

	public List<ProjectDocument> findWorkflowAppByOwnerCreatedDate(List startKey, List endKey, int limit, int skip,
			boolean descending, boolean useFactory) throws ServiceError {
		return findStartKeys("findWorkflowAppByOwnerCreatedDate", startKey, endKey, limit, skip, descending,
				useFactory);
	}

	public List<FolderDocument> getParentFolders(String documentId) throws ServiceError {
		List<FolderDocument> answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/pd" + "/" + "getParentFolders");
			LinkedHashMap params = new LinkedHashMap();
			params.put("documentId", documentId);
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

	public ProjectDocument clone(String documentId, String projectId) throws ServiceError {
		ProjectDocument answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/pd" + "/" + "clone");
			LinkedHashMap params = new LinkedHashMap();
			params.put("documentId", documentId);
			params.put("projectId", projectId);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = ProjectDocumentBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
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