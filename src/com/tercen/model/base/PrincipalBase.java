package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PrincipalBase extends BaseObject {

	public String principalId;

	public PrincipalBase() {
		super();
		this.principalId = "";
	}

	public PrincipalBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Principal_CLASS ? m.get(Vocabulary.KIND) : null);
		this.principalId = (String) m.get(Vocabulary.principalId_DP);
	}

	public static Principal createFromJson(LinkedHashMap m) {
		return PrincipalBase.fromJson(m);
	}

	public static Principal fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Principal_CLASS:
			return new Principal(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Principal in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Principal_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Principal_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.principalId_DP, principalId);
		return m;
	}
}