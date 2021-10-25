package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ShinyOperatorBase extends WebAppOperator {

	public ShinyOperatorBase() {
		super();
	}

	public ShinyOperatorBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ShinyOperator_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static ShinyOperator createFromJson(LinkedHashMap m) {
		return ShinyOperatorBase.fromJson(m);
	}

	public static ShinyOperator fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ShinyOperator_CLASS:
			return new ShinyOperator(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class ShinyOperator in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ShinyOperator_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ShinyOperator_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}