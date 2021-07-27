package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class FilterExprBase extends FilterTopExpr {

	public String filterOp;
	public String stringValue;
	public Factor factor;

	public FilterExprBase() {
		super();
		this.filterOp = "";
		this.stringValue = "";
		this.factor = new Factor();
	}

	public FilterExprBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.FilterExpr_CLASS ? m.get(Vocabulary.KIND) : null);
		this.filterOp = (String) m.get(Vocabulary.filterOp_DP);
		this.stringValue = (String) m.get(Vocabulary.stringValue_DP);
	}

	public static FilterExpr createFromJson(LinkedHashMap m) {
		return FilterExprBase.fromJson(m);
	}

	public static FilterExpr fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.FilterExpr_CLASS:
			return new FilterExpr(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class FilterExpr in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.FilterExpr_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.FilterExpr_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.filterOp_DP, filterOp);
		m.put(Vocabulary.stringValue_DP, stringValue);
		m.put(Vocabulary.factor_OP, factor == null ? null : factor.toJson());
		return m;
	}
}