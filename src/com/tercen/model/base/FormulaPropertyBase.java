package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class FormulaPropertyBase extends StringProperty {

	public FormulaPropertyBase() {
		super();
	}

	public FormulaPropertyBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.FormulaProperty_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static FormulaProperty createFromJson(LinkedHashMap m) {
		return FormulaPropertyBase.fromJson(m);
	}

	public static FormulaProperty fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.FormulaProperty_CLASS:
			return new FormulaProperty(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class FormulaProperty in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.FormulaProperty_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.FormulaProperty_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}