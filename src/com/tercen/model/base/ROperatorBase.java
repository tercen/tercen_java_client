package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ROperatorBase extends GitOperator {

	public ROperatorBase() {
		super();
	}

	public ROperatorBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ROperator_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static ROperator createFromJson(LinkedHashMap m) {
		return ROperatorBase.fromJson(m);
	}

	public static ROperator fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ROperator_CLASS:
			return new ROperator(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class ROperator in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ROperator_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ROperator_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}