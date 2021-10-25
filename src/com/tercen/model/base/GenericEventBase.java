package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class GenericEventBase extends Event {

	public String type;
	public String content;

	public GenericEventBase() {
		super();
		this.type = "";
		this.content = "";
	}

	public GenericEventBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.GenericEvent_CLASS ? m.get(Vocabulary.KIND) : null);
		this.type = (String) m.get(Vocabulary.type_DP);
		this.content = (String) m.get(Vocabulary.content_DP);
	}

	public static GenericEvent createFromJson(LinkedHashMap m) {
		return GenericEventBase.fromJson(m);
	}

	public static GenericEvent fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.GenericEvent_CLASS:
			return new GenericEvent(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class GenericEvent in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.GenericEvent_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.GenericEvent_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.type_DP, type);
		m.put(Vocabulary.content_DP, content);
		return m;
	}
}