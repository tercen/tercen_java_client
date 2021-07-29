package com.tercen.http;

import java.io.IOException;
import java.net.URI;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;

public class AuthHttpClient {
	private String authorization = "";
	OkHttpClient client;

	public AuthHttpClient() {
		authorization = "";
		client = new OkHttpClient();
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public Response get(String url, LinkedHashMap<String, String> headers) throws IOException {

		Request.Builder builder = new Request.Builder().get().url(url);

		if (!authorization.isEmpty()) {
			builder.header("authorization", authorization);
		}

		if (headers != null) {
			for (Entry<String, String> entry : headers.entrySet()) {
				builder.header(entry.getKey(), entry.getValue());
			}
		}

		Request request = builder.build();

		Response response = client.newCall(request).execute();

		return response;
	}

	public Response post(String url, LinkedHashMap<String, String> headers, RequestBody requestBody)
			throws IOException, InterruptedException {

		Request.Builder builder = new Request.Builder().post(requestBody).url(url);

		if (!authorization.isEmpty()) {
			builder.header("authorization", authorization);
		}

		if (headers != null) {
			for (Entry<String, String> entry : headers.entrySet()) {
				builder.header(entry.getKey(), entry.getValue());
			}
		}

		Request request = builder.build();

		Response response = client.newCall(request).execute();

		return response;
	}

	public Response put(String url, LinkedHashMap<String, String> headers, RequestBody requestBody)
			throws IOException, InterruptedException {

		Request.Builder builder = new Request.Builder().put(requestBody).url(url);

		if (!authorization.isEmpty()) {
			builder.header("authorization", authorization);
		}

		if (headers != null) {
			for (Entry<String, String> entry : headers.entrySet()) {
				builder.header(entry.getKey(), entry.getValue());
			}
		}

		Request request = builder.build();

		Response response = client.newCall(request).execute();

		return response;
	}

	public Response delete(String url, LinkedHashMap<String, String> headers) throws IOException {

		Request.Builder builder = new Request.Builder().delete().url(url);

		if (!authorization.isEmpty()) {
			builder.header("authorization", authorization);
		}

		if (headers != null) {
			for (Entry<String, String> entry : headers.entrySet()) {
				builder.header(entry.getKey(), entry.getValue());
			}
		}

		Request request = builder.build();

		Response response = client.newCall(request).execute();

		return response;
	}

}
