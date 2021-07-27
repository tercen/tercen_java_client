package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class JoinOperatorBase extends BaseObject {

	public ColumnPair leftPair;
	public Relation rightRelation;

	public JoinOperatorBase() {
		super();
		this.leftPair = new ColumnPair();
		this.rightRelation = new Relation();
	}

	public JoinOperatorBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.JoinOperator_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static JoinOperator createFromJson(LinkedHashMap m) {
		return JoinOperatorBase.fromJson(m);
	}

	public static JoinOperator fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.JoinOperator_CLASS:
			return new JoinOperator(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class JoinOperator in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.JoinOperator_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.JoinOperator_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.leftPair_OP, leftPair == null ? null : leftPair.toJson());
		m.put(Vocabulary.rightRelation_OP, rightRelation == null ? null : rightRelation.toJson());
		return m;
	}
}