package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class LabelsBase extends BaseObject {

	public ArrayList<Factor> factors;

	public LabelsBase() {
		super();
		this.factors = new ArrayList<Factor>();
	}

	public LabelsBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Labels_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.factors_OP) == null)
			this.factors = new ArrayList<Factor>();
		else {
			ArrayList obj_list = new ArrayList();
			ArrayList list = (ArrayList) m.get(Vocabulary.factors_OP);
			for (Object map : list) {
				obj_list.add(FactorBase.createFromJson((LinkedHashMap) map));
			}
		}
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