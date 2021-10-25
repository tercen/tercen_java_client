package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PendingStateBase extends State {

	public PendingStateBase() {
		super();
	}

	public PendingStateBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.PendingState_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static PendingState createFromJson(LinkedHashMap m) {
		return PendingStateBase.fromJson(m);
	}

	public static PendingState fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.PendingState_CLASS:
			return new PendingState(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class PendingState in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.PendingState_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.PendingState_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}