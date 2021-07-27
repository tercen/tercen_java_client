package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class SummaryBase extends BaseObject {

	public TableSummary tableSummary;
	public TableSummary computedTableSummary;
	public TableSummary queryTableSummary;
	public TaskSummary taskSummary;

	public SummaryBase() {
		super();
		this.tableSummary = new TableSummary();
		this.computedTableSummary = new TableSummary();
		this.queryTableSummary = new TableSummary();
		this.taskSummary = new TaskSummary();
	}

	public SummaryBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Summary_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static Summary createFromJson(LinkedHashMap m) {
		return SummaryBase.fromJson(m);
	}

	public static Summary fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Summary_CLASS:
			return new Summary(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Summary in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Summary_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Summary_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.tableSummary_OP, tableSummary == null ? null : tableSummary.toJson());
		m.put(Vocabulary.computedTableSummary_OP, computedTableSummary == null ? null : computedTableSummary.toJson());
		m.put(Vocabulary.queryTableSummary_OP, queryTableSummary == null ? null : queryTableSummary.toJson());
		m.put(Vocabulary.taskSummary_OP, taskSummary == null ? null : taskSummary.toJson());
		return m;
	}
}