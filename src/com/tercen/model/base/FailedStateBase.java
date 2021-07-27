package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class FailedStateBase extends State {

	public String error;
	public String reason;

	public FailedStateBase() {
		super();
		this.error = "";
		this.reason = "";
	}

	public FailedStateBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.FailedState_CLASS ? m.get(Vocabulary.KIND) : null);
		this.error = (String) m.get(Vocabulary.error_DP);
		this.reason = (String) m.get(Vocabulary.reason_DP);
	}

	public static FailedState createFromJson(LinkedHashMap m) {
		return FailedStateBase.fromJson(m);
	}

	public static FailedState fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.FailedState_CLASS:
			return new FailedState(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class FailedState in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.FailedState_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.FailedState_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.error_DP, error);
		m.put(Vocabulary.reason_DP, reason);
		return m;
	}
}