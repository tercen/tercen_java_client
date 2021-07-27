package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class StringColorElementBase extends ColorElement {

	public String stringValue;

	public StringColorElementBase() {
		super();
		this.stringValue = "";
	}

	public StringColorElementBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.StringColorElement_CLASS ? m.get(Vocabulary.KIND)
						: null);
		this.stringValue = (String) m.get(Vocabulary.stringValue_DP);
	}

	public static StringColorElement createFromJson(LinkedHashMap m) {
		return StringColorElementBase.fromJson(m);
	}

	public static StringColorElement fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.StringColorElement_CLASS:
			return new StringColorElement(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class StringColorElement in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.StringColorElement_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.StringColorElement_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.stringValue_DP, stringValue);
		return m;
	}
}