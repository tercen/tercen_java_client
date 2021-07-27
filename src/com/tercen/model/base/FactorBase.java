package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class FactorBase extends BaseObject {

	public String name;
	public String type;

	public FactorBase() {
		super();
		this.name = "";
		this.type = "";
	}

	public FactorBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Factor_CLASS ? m.get(Vocabulary.KIND) : null);
		this.name = (String) m.get(Vocabulary.name_DP);
		this.type = (String) m.get(Vocabulary.type_DP);
	}

	public static Factor createFromJson(LinkedHashMap m) {
		return FactorBase.fromJson(m);
	}

	public static Factor fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Factor_CLASS:
			return new Factor(m);
		case Vocabulary.Attribute_CLASS:
			return new Attribute(m);
		case Vocabulary.MappingFactor_CLASS:
			return new MappingFactor(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Factor in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Factor_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Factor_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.type_DP, type);
		return m;
	}
}