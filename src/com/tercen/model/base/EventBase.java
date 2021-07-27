package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class EventBase extends PersistentObject {

	public Date date;

	public EventBase() {
		super();
		this.date = new Date();
	}

	public EventBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Event_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static Event createFromJson(LinkedHashMap m) {
		return EventBase.fromJson(m);
	}

	public static Event fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Event_CLASS:
			return new Event(m);
		case Vocabulary.TaskLogEvent_CLASS:
			return new TaskLogEvent(m);
		case Vocabulary.TaskProgressEvent_CLASS:
			return new TaskProgressEvent(m);
		case Vocabulary.TaskDataEvent_CLASS:
			return new TaskDataEvent(m);
		case Vocabulary.TaskStateEvent_CLASS:
			return new TaskStateEvent(m);
		case Vocabulary.TaskEvent_CLASS:
			return new TaskEvent(m);
		case Vocabulary.GenericEvent_CLASS:
			return new GenericEvent(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Event in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Event_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Event_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.date_OP, date == null ? null : date.toJson());
		return m;
	}
}