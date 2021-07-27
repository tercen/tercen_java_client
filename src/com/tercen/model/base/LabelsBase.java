package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class LabelsBase extends BaseObject {

	public LinkedList<Factor> factors;

	public LabelsBase() {
		super();
		this.factors = new LinkedList<Factor>();
	}

	public LabelsBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Labels_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static Labels createFromJson(LinkedHashMap m) {
		return LabelsBase.fromJson(m);
	}

	public static Labels fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Labels_CLASS:
			return new Labels(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Labels in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Labels_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Labels_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.factors_OP, BaseObject.objectListToJson(factors));
		return m;
	}
}