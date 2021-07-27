package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class InputPortBase extends Port {

	public InputPortBase() {
		super();
	}

	public InputPortBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.InputPort_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static InputPort createFromJson(LinkedHashMap m) {
		return InputPortBase.fromJson(m);
	}

	public static InputPort fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.InputPort_CLASS:
			return new InputPort(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class InputPort in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.InputPort_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.InputPort_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}