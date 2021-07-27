package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class MappingFactorBase extends Factor {

	public boolean isSingle;
	public String description;
	public String factorName;
	public LinkedList<Factor> factors;

	public MappingFactorBase() {
		super();
		this.isSingle = true;
		this.description = "";
		this.factorName = "";
		this.factors = new LinkedList<Factor>();
	}

	public MappingFactorBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.MappingFactor_CLASS ? m.get(Vocabulary.KIND) : null);
		this.isSingle = (boolean) m.get(Vocabulary.isSingle_DP);
		this.description = (String) m.get(Vocabulary.description_DP);
		this.factorName = (String) m.get(Vocabulary.factorName_DP);
	}

	public static MappingFactor createFromJson(LinkedHashMap m) {
		return MappingFactorBase.fromJson(m);
	}

	public static MappingFactor fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.MappingFactor_CLASS:
			return new MappingFactor(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class MappingFactor in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.MappingFactor_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.MappingFactor_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.isSingle_DP, isSingle);
		m.put(Vocabulary.description_DP, description);
		m.put(Vocabulary.factorName_DP, factorName);
		m.put(Vocabulary.factors_OP, BaseObject.objectListToJson(factors));
		return m;
	}
}