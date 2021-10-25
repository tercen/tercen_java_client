package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ApiCallProfileBase extends Profile {

	public int nCalls;

	public ApiCallProfileBase() {
		super();
		this.nCalls = 0;
	}

	public ApiCallProfileBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ApiCallProfile_CLASS ? m.get(Vocabulary.KIND) : null);
		this.nCalls = (int) m.get(Vocabulary.nCalls_DP);
	}

	public static ApiCallProfile createFromJson(LinkedHashMap m) {
		return ApiCallProfileBase.fromJson(m);
	}

	public static ApiCallProfile fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ApiCallProfile_CLASS:
			return new ApiCallProfile(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class ApiCallProfile in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ApiCallProfile_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ApiCallProfile_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.nCalls_DP, nCalls);
		return m;
	}
}