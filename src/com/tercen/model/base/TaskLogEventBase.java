package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TaskLogEventBase extends TaskEvent {

	public String message;

	public TaskLogEventBase() {
		super();
		this.message = "";
	}

	public TaskLogEventBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.TaskLogEvent_CLASS ? m.get(Vocabulary.KIND) : null);
		this.message = (String) m.get(Vocabulary.message_DP);
	}

	public static TaskLogEvent createFromJson(LinkedHashMap m) {
		return TaskLogEventBase.fromJson(m);
	}

	public static TaskLogEvent fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.TaskLogEvent_CLASS:
			return new TaskLogEvent(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class TaskLogEvent in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.TaskLogEvent_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.TaskLogEvent_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.message_DP, message);
		return m;
	}
}