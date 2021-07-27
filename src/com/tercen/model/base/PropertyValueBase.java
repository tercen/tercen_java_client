package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PropertyValueBase extends BaseObject {

	public String name;
	public String value;

	public PropertyValueBase() {
		super();
		this.name = "";
		this.value = "";
	}

	public PropertyValueBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.PropertyValue_CLASS ? m.get(Vocabulary.KIND) : null);
		this.name = (String) m.get(Vocabulary.name_DP);
		this.value = (String) m.get(Vocabulary.value_DP);
	}

	public static PropertyValue createFromJson(LinkedHashMap m) {
		return PropertyValueBase.fromJson(m);
	}

	public static PropertyValue fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.PropertyValue_CLASS:
			return new PropertyValue(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class PropertyValue in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.PropertyValue_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.PropertyValue_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.value_DP, value);
		return m;
	}
}