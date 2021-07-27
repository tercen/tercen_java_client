package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class MeltStepModelBase extends StepModel {

	public LinkedList<Factor> factors;
	public String namespace;
	public String selectionPattern;
	public String factorType;

	public MeltStepModelBase() {
		super();
		this.namespace = "";
		this.selectionPattern = "";
		this.factorType = "";
		this.factors = new LinkedList<Factor>();
	}

	public MeltStepModelBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.MeltStepModel_CLASS ? m.get(Vocabulary.KIND) : null);
		this.namespace = (String) m.get(Vocabulary.namespace_DP);
		this.selectionPattern = (String) m.get(Vocabulary.selectionPattern_DP);
		this.factorType = (String) m.get(Vocabulary.factorType_DP);
	}

	public static MeltStepModel createFromJson(LinkedHashMap m) {
		return MeltStepModelBase.fromJson(m);
	}

	public static MeltStepModel fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.MeltStepModel_CLASS:
			return new MeltStepModel(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class MeltStepModel in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.MeltStepModel_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.MeltStepModel_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.factors_OP, BaseObject.objectListToJson(factors));
		m.put(Vocabulary.namespace_DP, namespace);
		m.put(Vocabulary.selectionPattern_DP, selectionPattern);
		m.put(Vocabulary.factorType_DP, factorType);
		return m;
	}
}