package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TableSummaryBase extends BaseObject {

	public int n;
	public int size;
	public int nr;
	public int nc;

	public TableSummaryBase() {
		super();
		this.n = 0;
		this.size = 0;
		this.nr = 0;
		this.nc = 0;
	}

	public TableSummaryBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.TableSummary_CLASS ? m.get(Vocabulary.KIND) : null);
		this.n = (int) m.get(Vocabulary.n_DP);
		this.size = (int) m.get(Vocabulary.size_DP);
		this.nr = (int) m.get(Vocabulary.nr_DP);
		this.nc = (int) m.get(Vocabulary.nc_DP);
	}

	public static TableSummary createFromJson(LinkedHashMap m) {
		return TableSummaryBase.fromJson(m);
	}

	public static TableSummary fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.TableSummary_CLASS:
			return new TableSummary(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class TableSummary in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.TableSummary_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.TableSummary_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.n_DP, n);
		m.put(Vocabulary.size_DP, size);
		m.put(Vocabulary.nr_DP, nr);
		m.put(Vocabulary.nc_DP, nc);
		return m;
	}
}