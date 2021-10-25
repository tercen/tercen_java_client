package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class OperatorResultBase extends BaseObject {

	public ArrayList<Table> tables;
	public ArrayList<JoinOperator> joinOperators;

	public OperatorResultBase() {
		super();
		this.tables = new ArrayList<Table>();
		this.joinOperators = new ArrayList<JoinOperator>();
	}

	public OperatorResultBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.OperatorResult_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.tables_OP) == null)
			this.tables = new ArrayList<Table>();
		else {
			this.tables = new ArrayList<Table>();
			ArrayList list = (ArrayList) m.get(Vocabulary.tables_OP);
			for (Object map : list) {
				this.tables.add(TableBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.joinOperators_OP) == null)
			this.joinOperators = new ArrayList<JoinOperator>();
		else {
			this.joinOperators = new ArrayList<JoinOperator>();
			ArrayList list = (ArrayList) m.get(Vocabulary.joinOperators_OP);
			for (Object map : list) {
				this.joinOperators.add(JoinOperatorBase.createFromJson((LinkedHashMap) map));
			}
		}
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