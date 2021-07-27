package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class FiltersBase extends BaseObject {

	public boolean removeNaN;
	public LinkedList<NamedFilter> namedFilters;

	public FiltersBase() {
		super();
		this.removeNaN = true;
		this.namedFilters = new LinkedList<NamedFilter>();
	}

	public FiltersBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Filters_CLASS ? m.get(Vocabulary.KIND) : null);
		this.removeNaN = (boolean) m.get(Vocabulary.removeNaN_DP);
	}

	public static Filters createFromJson(LinkedHashMap m) {
		return FiltersBase.fromJson(m);
	}

	public static Filters fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Filters_CLASS:
			return new Filters(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Filters in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Filters_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Filters_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.removeNaN_DP, removeNaN);
		m.put(Vocabulary.namedFilters_OP, BaseObject.objectListToJson(namedFilters));
		return m;
	}
}