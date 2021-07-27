package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class StringPropertyBase extends Property {

	public String defaultValue;

	public StringPropertyBase() {
		super();
		this.defaultValue = "";
	}

	public StringPropertyBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.StringProperty_CLASS ? m.get(Vocabulary.KIND) : null);
		this.defaultValue = (String) m.get(Vocabulary.defaultValue_DP);
	}

	public static StringProperty createFromJson(LinkedHashMap m) {
		return StringPropertyBase.fromJson(m);
	}

	public static StringProperty fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.StringProperty_CLASS:
			return new StringProperty(m);
		case Vocabulary.EnumeratedProperty_CLASS:
			return new EnumeratedProperty(m);
		case Vocabulary.FactorsProperty_CLASS:
			return new FactorsProperty(m);
		case Vocabulary.FormulaProperty_CLASS:
			return new FormulaProperty(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class StringProperty in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.StringProperty_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.StringProperty_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.defaultValue_DP, defaultValue);
		return m;
	}
}