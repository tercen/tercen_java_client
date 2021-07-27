package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class StorageProfileBase extends Profile {

	public int size;

	public StorageProfileBase() {
		super();
		this.size = 0;
	}

	public StorageProfileBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.StorageProfile_CLASS ? m.get(Vocabulary.KIND) : null);
		this.size = (int) m.get(Vocabulary.size_DP);
	}

	public static StorageProfile createFromJson(LinkedHashMap m) {
		return StorageProfileBase.fromJson(m);
	}

	public static StorageProfile fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.StorageProfile_CLASS:
			return new StorageProfile(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class StorageProfile in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.StorageProfile_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.StorageProfile_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.size_DP, size);
		return m;
	}
}