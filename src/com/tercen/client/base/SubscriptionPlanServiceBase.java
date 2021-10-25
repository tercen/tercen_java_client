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

public class SubscriptionPlanServiceBase extends HttpClientService<SubscriptionPlan> {

	public URI getBaseUri() {
		return URI.create("api/v1/subscription");
	}

	String getServiceName() {
		return "SubscriptionPlan";
	}

	LinkedHashMap toJson(SubscriptionPlan object) {
		return object.toJson();
	}

	public SubscriptionPlan fromJson(LinkedHashMap m, boolean useFactory) {
		if (m == null)
			return null;
		if (useFactory)
			return SubscriptionPlanBase.fromJson(m);
		return new SubscriptionPlan(m);
	}

	public List<SubscriptionPlan> findByOwner(List keys, boolean useFactory) throws ServiceError {
		return findKeys("findByOwner", keys, useFactory);
	}

	public List<SubscriptionPlan> findSubscriptionPlanByCheckoutSessionId(List keys, boolean useFactory)
			throws ServiceError {
		return findKeys("checkoutSessionId", keys, useFactory);
	}

	public List<SubscriptionPlan> getSubscriptionPlans(String userId) throws ServiceError {
		List<SubscriptionPlan> answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/subscription" + "/" + "getSubscriptionPlans");
			LinkedHashMap params = new LinkedHashMap();
			params.put("userId", userId);
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

	public List<Plan> getPlans(String userId) throws ServiceError {
		List<Plan> answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/subscription" + "/" + "getPlans");
			LinkedHashMap params = new LinkedHashMap();
			params.put("userId", userId);
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

	public SubscriptionPlan createSubscriptionPlan(String userId, String plan, String successUrl, String cancelUrl)
			throws ServiceError {
		SubscriptionPlan answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/subscription" + "/" + "createSubscriptionPlan");
			LinkedHashMap params = new LinkedHashMap();
			params.put("userId", userId);
			params.put("plan", plan);
			params.put("successUrl", successUrl);
			params.put("cancelUrl", cancelUrl);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = SubscriptionPlanBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
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

	public Object setSubscriptionPlanStatus(String subscriptionPlanId, String status) throws ServiceError {
		Object answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/subscription" + "/" + "setSubscriptionPlanStatus");
			LinkedHashMap params = new LinkedHashMap();
			params.put("subscriptionPlanId", subscriptionPlanId);
			params.put("status", status);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = null;
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

	public SubscriptionPlan updatePaymentMethod(String subscriptionPlanId, String successUrl, String cancelUrl)
			throws ServiceError {
		SubscriptionPlan answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/subscription" + "/" + "updatePaymentMethod");
			LinkedHashMap params = new LinkedHashMap();
			params.put("subscriptionPlanId", subscriptionPlanId);
			params.put("successUrl", successUrl);
			params.put("cancelUrl", cancelUrl);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = SubscriptionPlanBase.fromJson((LinkedHashMap) jtson.decodeTSON(response.body().bytes()));
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

	public Object setUpdatePaymentMethodStatus(String subscriptionPlanId, String status) throws ServiceError {
		Object answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/subscription" + "/" + "setUpdatePaymentMethodStatus");
			LinkedHashMap params = new LinkedHashMap();
			params.put("subscriptionPlanId", subscriptionPlanId);
			params.put("status", status);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = null;
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

	public Object cancelSubscription(String subscriptionPlanId) throws ServiceError {
		Object answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/subscription" + "/" + "cancelSubscription");
			LinkedHashMap params = new LinkedHashMap();
			params.put("subscriptionPlanId", subscriptionPlanId);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = null;
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

	public Object upgradeSubscription(String subscriptionPlanId, String plan) throws ServiceError {
		Object answer = null;
		Response response = null;
		try {
			URI uri = URI.create("api/v1/subscription" + "/" + "upgradeSubscription");
			LinkedHashMap params = new LinkedHashMap();
			params.put("subscriptionPlanId", subscriptionPlanId);
			params.put("plan", plan);
			response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,
					RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)));
			if (response.code() != 200) {
				onResponseError(response);
			} else {

				answer = null;
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