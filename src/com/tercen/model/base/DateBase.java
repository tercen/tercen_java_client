package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class DateBase extends BaseObject {

	public String value;

	public DateBase() {
		super();
		this.value = "";
	}

	public DateBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Date_CLASS ? m.get(Vocabulary.KIND) : null);
		this.value = (String) m.get(Vocabulary.value_DP);
	}

	public static Date createFromJson(LinkedHashMap m) {
		return DateBase.fromJson(m);
	}

	public static Date fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Date_CLASS:
			return new Date(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Date in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Date_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Date_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.value_DP, value);
		return m;
	}
}