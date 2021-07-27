package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PairBase extends BaseObject {

	public String key;
	public String value;

	public PairBase() {
		super();
		this.key = "";
		this.value = "";
	}

	public PairBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Pair_CLASS ? m.get(Vocabulary.KIND) : null);
		this.key = (String) m.get(Vocabulary.key_DP);
		this.value = (String) m.get(Vocabulary.value_DP);
	}

	public static Pair createFromJson(LinkedHashMap m) {
		return PairBase.fromJson(m);
	}

	public static Pair fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Pair_CLASS:
			return new Pair(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Pair in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Pair_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Pair_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.key_DP, key);
		m.put(Vocabulary.value_DP, value);
		return m;
	}
}