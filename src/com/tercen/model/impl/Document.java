package com.tercen.model.impl;

import com.tercen.model.base.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Document extends DocumentBase {

	public Document() {
		super();
		this.isPublic = false;
	}

	public Document(LinkedHashMap m) {
		super(m);
	}
}