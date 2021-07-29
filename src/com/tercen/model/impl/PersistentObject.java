package com.tercen.model.impl;

import com.tercen.model.base.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PersistentObject extends PersistentObjectBase {

	public PersistentObject() {
		super();
		this.isDeleted = false;
	}

	public PersistentObject(LinkedHashMap m) {
		super(m);
	}
}