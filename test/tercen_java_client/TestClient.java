package tercen_java_client;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.junit.Assert;
import org.junit.Test;

import com.tercen.http.AuthHttpClient;
import com.tercen.model.impl.UserSession;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import tercen.tson.TsonError;
import tercen.tson.jtson;

public class TestClient {
	@Test
	public void test_get() throws IOException, InterruptedException {

		AuthHttpClient authClient = new AuthHttpClient();

		Response response = authClient.get(TestUtils.TERCEN_URL, null);

		Assert.assertEquals(response.code(), 200);

	}

	@Test
	public void test_post() throws IOException, InterruptedException {

		AuthHttpClient authClient = new AuthHttpClient();

		Response response = authClient.post(TestUtils.TERCEN_URL, null,
				RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "some body text"));

		Assert.assertEquals(response.code(), 200);

	}

	@Test
	public void test_put() throws IOException, InterruptedException {

		AuthHttpClient authClient = new AuthHttpClient();

		Response response = authClient.put(TestUtils.TERCEN_URL, null,
				RequestBody.create(MediaType.parse("application/json; charset=utf-8"), "some body text"));

		Assert.assertEquals(response.code(), 200);

	}

	@Test
	public void test_signin() throws IOException, InterruptedException, TsonError {

		AuthHttpClient authClient = new AuthHttpClient();

		LinkedHashMap params = new LinkedHashMap();

		params.put("domain", "tercen");
		params.put("usernameOrEmail", "admin");
		params.put("password", "admin");

		byte[] result = jtson.encodeTSON(params);

		Response response = authClient.post(TestUtils.LOCALHOST_CONNECT2_URL, null,
				RequestBody.create(MediaType.parse("application/tson"), result));

		Assert.assertEquals(200, response.code());

		LinkedHashMap map = (LinkedHashMap) jtson.decodeTSON(response.body().bytes());

		UserSession userSession = new UserSession(map);

		System.out.println(userSession.toJson());
		System.out.println(userSession);

	}

}
