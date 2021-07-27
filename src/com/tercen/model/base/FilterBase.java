package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class FilterBase extends FilterTopExpr {

	public String logical;
	public boolean not;
	public LinkedList<FilterTopExpr> filterExprs;

	public FilterBase() {
		super();
		this.logical = "";
		this.not = true;
		this.filterExprs = new LinkedList<FilterTopExpr>();
	}

	public FilterBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Filter_CLASS ? m.get(Vocabulary.KIND) : null);
		this.logical = (String) m.get(Vocabulary.logical_DP);
		this.not = (boolean) m.get(Vocabulary.not_DP);
	}

	public static Filter createFromJson(LinkedHashMap m) {
		return FilterBase.fromJson(m);
	}

	public static Filter fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Filter_CLASS:
			return new Filter(m);
		case Vocabulary.NamedFilter_CLASS:
			return new NamedFilter(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Filter in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Filter_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Filter_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.logical_DP, logical);
		m.put(Vocabulary.not_DP, not);
		m.put(Vocabulary.filterExprs_OP, BaseObject.objectListToJson(filterExprs));
		return m;
	}
}