package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class StateBase extends BaseObject {

	public StateBase() {
		super();
	}

	public StateBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.State_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static State createFromJson(LinkedHashMap m) {
		return StateBase.fromJson(m);
	}

	public static State fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.State_CLASS:
			return new State(m);
		case Vocabulary.RunningState_CLASS:
			return new RunningState(m);
		case Vocabulary.RunningDependentState_CLASS:
			return new RunningDependentState(m);
		case Vocabulary.FailedState_CLASS:
			return new FailedState(m);
		case Vocabulary.CanceledState_CLASS:
			return new CanceledState(m);
		case Vocabulary.DoneState_CLASS:
			return new DoneState(m);
		case Vocabulary.InitState_CLASS:
			return new InitState(m);
		case Vocabulary.PendingState_CLASS:
			return new PendingState(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class State in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.State_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.State_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}