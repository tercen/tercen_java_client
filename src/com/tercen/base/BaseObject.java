package com.tercen.base;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class BaseObject {

	public static LinkedList<LinkedHashMap> objectListToJson(LinkedList<? extends BaseObject> list) {
		LinkedList<LinkedHashMap> jsonList = new LinkedList<LinkedHashMap>();

		for (BaseObject object : list) {
			jsonList.add(object.toJson());
		}

		return jsonList;
	}

	public String subKind;

	public BaseObject(LinkedHashMap m) {

	}

	public BaseObject() {

	}

	public LinkedHashMap toJson() {

		return new LinkedHashMap();
	}

}
