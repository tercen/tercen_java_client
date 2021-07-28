package com.tercen.base;

import java.util.LinkedHashMap;
import java.util.ArrayList;

public class BaseObject {

	public static ArrayList<LinkedHashMap> objectListToJson(ArrayList<? extends BaseObject> list) {
		ArrayList<LinkedHashMap> jsonList = new ArrayList<LinkedHashMap>();

		if (list == null)
			return jsonList;
		for (BaseObject object : list) {
			if (object != null) {
				jsonList.add(object.toJson());
			}
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
