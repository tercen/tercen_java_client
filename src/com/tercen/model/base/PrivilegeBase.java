package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PrivilegeBase extends BaseObject {

	public String type;

	public PrivilegeBase() {
		super();
		this.type = "";
	}

	public PrivilegeBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Privilege_CLASS ? m.get(Vocabulary.KIND) : null);
		this.type = (String) m.get(Vocabulary.type_DP);
	}

	public static Privilege createFromJson(LinkedHashMap m) {
		return PrivilegeBase.fromJson(m);
	}

	public static Privilege fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Privilege_CLASS:
			return new Privilege(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Privilege in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Privilege_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Privilege_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.type_DP, type);
		return m;
	}
}