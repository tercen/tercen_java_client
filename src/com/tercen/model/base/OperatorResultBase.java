package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class OperatorResultBase extends BaseObject {

	public LinkedList<Table> tables;
	public LinkedList<JoinOperator> joinOperators;

	public OperatorResultBase() {
		super();
		this.tables = new LinkedList<Table>();
		this.joinOperators = new LinkedList<JoinOperator>();
	}

	public OperatorResultBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.OperatorResult_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static OperatorResult createFromJson(LinkedHashMap m) {
		return OperatorResultBase.fromJson(m);
	}

	public static OperatorResult fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.OperatorResult_CLASS:
			return new OperatorResult(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class OperatorResult in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.OperatorResult_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.OperatorResult_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.tables_OP, BaseObject.objectListToJson(tables));
		m.put(Vocabulary.joinOperators_OP, BaseObject.objectListToJson(joinOperators));
		return m;
	}
}