package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class GarbageObjectBase extends PersistentObject {

	public GarbageObjectBase() {
		super();
	}

	public GarbageObjectBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.GarbageObject_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static GarbageObject createFromJson(LinkedHashMap m) {
		return GarbageObjectBase.fromJson(m);
	}

	public static GarbageObject fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.GarbageObject_CLASS:
			return new GarbageObject(m);
		case Vocabulary.GarbageTasks_CLASS:
			return new GarbageTasks(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class GarbageObject in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.GarbageObject_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.GarbageObject_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}