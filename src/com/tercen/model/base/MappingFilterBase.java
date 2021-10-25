package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class MappingFilterBase extends BaseObject {

	public String name;
	public String description;
	public NamedFilter namedFilter;
	public boolean isRequired;

	public MappingFilterBase() {
		super();
		this.name = "";
		this.description = "";
		this.isRequired = true;
		this.namedFilter = new NamedFilter();
	}

	public MappingFilterBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.MappingFilter_CLASS ? m.get(Vocabulary.KIND) : null);
		this.name = (String) m.get(Vocabulary.name_DP);
		this.description = (String) m.get(Vocabulary.description_DP);
		this.isRequired = (boolean) m.get(Vocabulary.isRequired_DP);
		if (m.get(Vocabulary.namedFilter_OP) == null)
			this.namedFilter = new NamedFilter();
		else
			this.namedFilter = NamedFilterBase.fromJson((LinkedHashMap) m.get(Vocabulary.namedFilter_OP));
	}

	public static MappingFilter createFromJson(LinkedHashMap m) {
		return MappingFilterBase.fromJson(m);
	}

	public static MappingFilter fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.MappingFilter_CLASS:
			return new MappingFilter(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class MappingFilter in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.MappingFilter_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.MappingFilter_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.description_DP, description);
		m.put(Vocabulary.namedFilter_OP, namedFilter == null ? null : namedFilter.toJson());
		m.put(Vocabulary.isRequired_DP, isRequired);
		return m;
	}
}