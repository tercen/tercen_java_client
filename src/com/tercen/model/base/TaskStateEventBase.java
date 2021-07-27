package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TaskStateEventBase extends TaskEvent {

	public State state;

	public TaskStateEventBase() {
		super();
		this.state = new State();
	}

	public TaskStateEventBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.TaskStateEvent_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static TaskStateEvent createFromJson(LinkedHashMap m) {
		return TaskStateEventBase.fromJson(m);
	}

	public static TaskStateEvent fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.TaskStateEvent_CLASS:
			return new TaskStateEvent(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class TaskStateEvent in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.TaskStateEvent_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.TaskStateEvent_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.state_OP, state == null ? null : state.toJson());
		return m;
	}
}