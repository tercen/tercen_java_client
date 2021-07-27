package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PropertyBase extends BaseObject {

	public String name;
	public String description;

	public PropertyBase() {
		super();
		this.name = "";
		this.description = "";
	}

	public PropertyBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Property_CLASS ? m.get(Vocabulary.KIND) : null);
		this.name = (String) m.get(Vocabulary.name_DP);
		this.description = (String) m.get(Vocabulary.description_DP);
	}

	public static Property createFromJson(LinkedHashMap m) {
		return PropertyBase.fromJson(m);
	}

	public static Property fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Property_CLASS:
			return new Property(m);
		case Vocabulary.EnumeratedProperty_CLASS:
			return new EnumeratedProperty(m);
		case Vocabulary.FactorsProperty_CLASS:
			return new FactorsProperty(m);
		case Vocabulary.FormulaProperty_CLASS:
			return new FormulaProperty(m);
		case Vocabulary.DoubleProperty_CLASS:
			return new DoubleProperty(m);
		case Vocabulary.StringProperty_CLASS:
			return new StringProperty(m);
		case Vocabulary.BooleanProperty_CLASS:
			return new BooleanProperty(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Property in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Property_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Property_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.description_DP, description);
		return m;
	}
}