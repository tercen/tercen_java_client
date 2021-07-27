package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class LockBase extends PersistentObject {

	public String name;

	public LockBase() {
		super();
		this.name = "";
	}

	public LockBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Lock_CLASS ? m.get(Vocabulary.KIND) : null);
		this.name = (String) m.get(Vocabulary.name_DP);
	}

	public static Lock createFromJson(LinkedHashMap m) {
		return LockBase.fromJson(m);
	}

	public static Lock fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Lock_CLASS:
			return new Lock(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Lock in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Lock_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Lock_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		return m;
	}
}