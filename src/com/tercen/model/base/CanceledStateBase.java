package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CanceledStateBase extends State {

	public CanceledStateBase() {
		super();
	}

	public CanceledStateBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.CanceledState_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static CanceledState createFromJson(LinkedHashMap m) {
		return CanceledStateBase.fromJson(m);
	}

	public static CanceledState fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.CanceledState_CLASS:
			return new CanceledState(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class CanceledState in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.CanceledState_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.CanceledState_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}