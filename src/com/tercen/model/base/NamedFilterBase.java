package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class NamedFilterBase extends Filter {

	public String name;

	public NamedFilterBase() {
		super();
		this.name = "";
	}

	public NamedFilterBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.NamedFilter_CLASS ? m.get(Vocabulary.KIND) : null);
		this.name = (String) m.get(Vocabulary.name_DP);
	}

	public static NamedFilter createFromJson(LinkedHashMap m) {
		return NamedFilterBase.fromJson(m);
	}

	public static NamedFilter fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.NamedFilter_CLASS:
			return new NamedFilter(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class NamedFilter in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.NamedFilter_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.NamedFilter_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		return m;
	}
}