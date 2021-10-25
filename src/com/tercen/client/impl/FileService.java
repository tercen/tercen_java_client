package com.tercen.client.impl;

import com.tercen.model.base.*;

import java.io.IOException;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Stream;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MultipartBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tercen.client.base.*;
import com.tercen.model.impl.*;
import com.tercen.service.ServiceError;

import tercen.tson.TsonError;
import tercen.tson.jtson;

public class FileService extends FileServiceBase {
	public FileDocument upload(FileDocument file, byte[] bytes) throws ServiceError {

//	public FileDocument upload(FileDocument file, Stream<List> bytes) throws ServiceError {

		FileDocument answer = null;

		try {
			String uri = getServiceUri(getBaseUri()).toString() + "/upload";

			String json = new ObjectMapper().writeValueAsString(List.of(file.toJson()));

			MultipartBody.Builder builder = new MultipartBody.Builder()
					.addPart(MultipartBody.create(MediaType.parse("application/json"), json))
					.addPart(MultipartBody.create(MediaType.parse("application/octet-stream"), bytes));

			Response response = tercenClient.httpClient.post(uri, null, builder.build());

			if (response.code() != 200) {
				onResponseError(response);
			} else {
				LinkedHashMap<?, ?> map = (LinkedHashMap<?, ?>) jtson.decodeTSON(response.body().bytes());

				answer = this.fromJson(map, true);
			}
		} catch (IOException | TsonError | InterruptedException e) {
			onError(e);
		}

		return answer;

	}

	public FileDocument append(FileDocument file, byte[] bytes) throws ServiceError {

//		public FileDocument upload(FileDocument file, Stream<List> bytes) throws ServiceError {

		FileDocument answer = null;

		try {
			String uri = getServiceUri(getBaseUri()).toString() + "/append";

			String json = new ObjectMapper().writeValueAsString(List.of(file.toJson()));

			MultipartBody.Builder builder = new MultipartBody.Builder()
					.addPart(MultipartBody.create(MediaType.parse("application/json"), json))
					.addPart(MultipartBody.create(MediaType.parse("application/octet-stream"), bytes));

			Response response = tercenClient.httpClient.post(uri, null, builder.build());

			if (response.code() != 200) {
				onResponseError(response);
			} else {
				LinkedHashMap<?, ?> map = (LinkedHashMap<?, ?>) jtson.decodeTSON(response.body().bytes());

				answer = this.fromJson(map, true);
			}
		} catch (IOException | TsonError | InterruptedException e) {
			onError(e);
		}

		return answer;

	}

	public byte[] download(String fileDocumentId) throws ServiceError {

		byte[] answer = null;

		try {

			LinkedHashMap<String, String> params = new LinkedHashMap<String, String>();
			params.put("fileDocumentId", fileDocumentId);

			String json = new ObjectMapper().writeValueAsString(params);

			LinkedHashMap<String, String> queryParameters = new LinkedHashMap<String, String>();
			queryParameters.put("params", json);

			String uri = addQueryParameters(URI.create(getServiceUri(getBaseUri()).toString() + "/download"),
					queryParameters).toString();

			Response response = tercenClient.httpClient.get(uri, null);

			if (response.code() != 200) {
				onResponseError(response);
			} else {
				answer = response.body().bytes();
			}
		} catch (IOException e) {
			onError(e);
		}

		return answer;
	}
}