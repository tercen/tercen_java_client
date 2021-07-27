package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RunningDependentStateBase extends State {

	public RunningDependentStateBase() {
		super();
	}

	public RunningDependentStateBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.RunningDependentState_CLASS ? m.get(Vocabulary.KIND)
						: null);
	}

	public static RunningDependentState createFromJson(LinkedHashMap m) {
		return RunningDependentStateBase.fromJson(m);
	}

	public static RunningDependentState fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.RunningDependentState_CLASS:
			return new RunningDependentState(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class RunningDependentState in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.RunningDependentState_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.RunningDependentState_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}