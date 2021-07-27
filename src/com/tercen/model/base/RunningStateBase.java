package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RunningStateBase extends State {

	public RunningStateBase() {
		super();
	}

	public RunningStateBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.RunningState_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static RunningState createFromJson(LinkedHashMap m) {
		return RunningStateBase.fromJson(m);
	}

	public static RunningState fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.RunningState_CLASS:
			return new RunningState(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class RunningState in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.RunningState_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.RunningState_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}