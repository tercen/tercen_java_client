package com.tercen.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.tercen.client.base.TercenClientBase;
import com.tercen.model.base.PersistentObjectBase;

import tercen.tson.TsonError;
import tercen.tson.jtson;

public class HttpClientService<T extends PersistentObjectBase> {
	public TercenClientBase tercenClient;

	public URI getBaseUri() {
		return URI.create("api/v1/empty");
	}

	public URI getServiceUri(URI baseServiceUri) {
		return tercenClient.tercenURI.resolve(baseServiceUri);
	}

	public void onResponseError(Response response) throws ServiceError {
		for (String name : response.headers().names()) {
			System.out.println(name + " " + response.header(name));
		}
		if (response.header("content-type").equals("application/tson")) {
			try {
				throw new ServiceError(jtson.decodeTSON(response.body().bytes()));
			} catch (TsonError | IOException e) {
				throw new ServiceError(e);
			}
		}

		try {
			throw new ServiceError(response.code(), "unknown", response.body().string());
		} catch (IOException e) {
			throw new ServiceError(response.code(), "unknown", "unknown");
		}
	}

	public void onError(Exception e) throws ServiceError {
		throw new ServiceError(e.toString());
	}

	public T fromJson(LinkedHashMap<?, ?> m, boolean useFactory) {
		return null;
	}

	public T get(String id) throws ServiceError {
		LinkedHashMap<String, String> queryParameters = new LinkedHashMap<String, String>();
		queryParameters.put("id", id);
		queryParameters.put("useFactory", "true");

		T answer = null;
		Response response = null;

		try {
			String uri = addQueryParameters(getServiceUri(getBaseUri()), queryParameters).toString();

			response = tercenClient.httpClient.get(uri, null);
			if (response.code() != 200) {

				onResponseError(response);
			} else {
				LinkedHashMap<?, ?> map = (LinkedHashMap<?, ?>) jtson.decodeTSON(response.body().bytes());

				answer = this.fromJson(map, true);
			}
		} catch (IOException | TsonError e) {
			onError(e);
		} finally {
			if (response != null) {
				response.close();
			}
		}

		return answer;
	}

	public T create(T object) throws ServiceError {

		T answer = null;
		Response response = null;

		try {
			String uri = getServiceUri(getBaseUri()).toString();

			response = tercenClient.httpClient.put(uri, null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(object.toJson())));

			if (response.code() != 200) {
				onResponseError(response);
			} else {
				LinkedHashMap<?, ?> map = (LinkedHashMap<?, ?>) jtson.decodeTSON(response.body().bytes());

				answer = this.fromJson(map, true);
			}
		} catch (IOException | TsonError | InterruptedException e) {
			onError(e);
		} finally {
			if (response != null) {
				response.close();
			}
		}

		return answer;
	}

	public String update(T object) throws ServiceError {

		String rev = null;
		Response response = null;

		try {
			String uri = getServiceUri(getBaseUri()).toString();

			response = tercenClient.httpClient.post(uri, null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(object.toJson())));

			if (response.code() != 200) {
				onResponseError(response);
			} else {
				List<?> list = (List<?>) jtson.decodeTSON(response.body().bytes());

				rev = (String) list.get(0);

				object.rev = rev;
			}
		} catch (IOException | TsonError | InterruptedException e) {
			onError(e);
		} finally {
			if (response != null) {
				response.close();
			}
		}

		return rev;
	}

	public void delete(String id, String rev) throws ServiceError {
		LinkedHashMap<String, String> queryParameters = new LinkedHashMap<String, String>();
		queryParameters.put("id", id);
		queryParameters.put("rev", rev);

		Response response = null;

		try {
			String uri = addQueryParameters(getServiceUri(getBaseUri()), queryParameters).toString();

			response = tercenClient.httpClient.delete(uri, null);

			if (response.code() != 200) {
				onResponseError(response);
			}
		} catch (IOException e) {
			onError(e);
		} finally {
			if (response != null) {
				response.close();
			}
		}

	}

	public URI addQueryParameters(URI uri, LinkedHashMap<String, String> queryParameters)
			throws UnsupportedEncodingException {
		if (queryParameters.isEmpty()) {
			return uri;
		}

		StringBuffer sb = new StringBuffer(uri.toString());
		sb.append("?");

		for (Entry<String, String> entry : queryParameters.entrySet()) {
			sb.append(URLEncoder.encode(entry.getKey(), java.nio.charset.StandardCharsets.UTF_8.toString()));
			sb.append("=");
			sb.append(URLEncoder.encode(entry.getValue(), java.nio.charset.StandardCharsets.UTF_8.toString()));
			sb.append("&");
		}

		// remove last &
		String str = sb.toString();
		str = str.substring(0, str.length() - 1);

		return URI.create(str);

	}

	public List<T> findStartKeys(String viewName, List startKey, List endKey, int limit, int skip, boolean descending,
			boolean useFactory) throws ServiceError {

		ArrayList<T> answer = new ArrayList<T>();
		LinkedHashMap<String, String> queryParameters = new LinkedHashMap<String, String>();
		queryParameters.put("useFactory", "" + useFactory);

		Response response = null;

		try {
			String uri = addQueryParameters(URI.create(getServiceUri(getBaseUri()).toString() + "/" + viewName),
					queryParameters).toString();

			LinkedHashMap query = new LinkedHashMap();
			query.put("startKey", startKey);
			query.put("endKey", endKey);
			query.put("limit", limit);
			query.put("skip", skip);
			query.put("descending", descending);

			response = tercenClient.httpClient.post(uri, null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(query)));

			if (response.code() != 200) {
				onResponseError(response);
			} else {
				List<LinkedHashMap> list = (List<LinkedHashMap>) jtson.decodeTSON(response.body().bytes());

				for (LinkedHashMap map : list) {
					answer.add(fromJson(map, useFactory));
				}

			}

		} catch (IOException | InterruptedException | TsonError e) {
			onError(e);
		} finally {
			if (response != null) {
				response.close();
			}
		}

		return answer;

	}

	public List<T> findKeys(String viewName, List keys, boolean useFactory) throws ServiceError {
		ArrayList<T> answer = new ArrayList<T>();
		LinkedHashMap<String, String> queryParameters = new LinkedHashMap<String, String>();
		queryParameters.put("useFactory", "" + useFactory);

		Response response = null;

		try {
			String uri = addQueryParameters(URI.create(getServiceUri(getBaseUri()).toString() + "/" + viewName),
					queryParameters).toString();

			response = tercenClient.httpClient.post(uri, null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(keys)));

			if (response.code() != 200) {
				onResponseError(response);
			} else {
				List<LinkedHashMap> list = (List<LinkedHashMap>) jtson.decodeTSON(response.body().bytes());

				for (LinkedHashMap map : list) {
					answer.add(fromJson(map, useFactory));
				}

			}

		} catch (IOException | InterruptedException | TsonError e) {
			onError(e);
		} finally {
			if (response != null) {
				response.close();
			}
		}

		return answer;

	}
}
