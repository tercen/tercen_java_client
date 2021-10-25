package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class EnumeratedPropertyBase extends StringProperty {

	public ArrayList<String> values;

	public EnumeratedPropertyBase() {
		super();
		this.values = new ArrayList<String>();
	}

	public EnumeratedPropertyBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.EnumeratedProperty_CLASS ? m.get(Vocabulary.KIND)
						: null);
		this.values = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.values_DP)));
	}

	public static EnumeratedProperty createFromJson(LinkedHashMap m) {
		return EnumeratedPropertyBase.fromJson(m);
	}

	public static EnumeratedProperty fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.EnumeratedProperty_CLASS:
			return new EnumeratedProperty(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class EnumeratedProperty in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.EnumeratedProperty_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.EnumeratedProperty_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.values_DP, values);
		return m;
	}
}