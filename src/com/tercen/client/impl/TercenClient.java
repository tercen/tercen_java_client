package com.tercen.client.impl;

import com.tercen.service.HttpClientService;
import com.tercen.model.impl.*;

import java.net.URI;

import com.tercen.client.base.*;

public class TercenClient extends TercenClientBase {

	public TercenClient() {
		super();
		tercenURI = URI.create("https://tercen.com");
	}

	public TercenClient(String uri) {
		super();
		tercenURI = URI.create(uri);
	}
}
