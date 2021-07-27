package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TaskProgressEventBase extends TaskEvent {

	public String message;
	public int total;
	public int actual;

	public TaskProgressEventBase() {
		super();
		this.message = "";
		this.total = 0;
		this.actual = 0;
	}

	public TaskProgressEventBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.TaskProgressEvent_CLASS ? m.get(Vocabulary.KIND)
						: null);
		this.message = (String) m.get(Vocabulary.message_DP);
		this.total = (int) m.get(Vocabulary.total_DP);
		this.actual = (int) m.get(Vocabulary.actual_DP);
	}

	public static TaskProgressEvent createFromJson(LinkedHashMap m) {
		return TaskProgressEventBase.fromJson(m);
	}

	public static TaskProgressEvent fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.TaskProgressEvent_CLASS:
			return new TaskProgressEvent(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class TaskProgressEvent in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.TaskProgressEvent_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.TaskProgressEvent_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.message_DP, message);
		m.put(Vocabulary.total_DP, total);
		m.put(Vocabulary.actual_DP, actual);
		return m;
	}
}