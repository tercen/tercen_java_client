package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CompositeRelationBase extends Relation {

	public ArrayList<JoinOperator> joinOperators;
	public Relation mainRelation;

	public CompositeRelationBase() {
		super();
		this.joinOperators = new ArrayList<JoinOperator>();
		this.mainRelation = new Relation();
	}

	public CompositeRelationBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.CompositeRelation_CLASS ? m.get(Vocabulary.KIND)
						: null);
		if (m.get(Vocabulary.joinOperators_OP) == null)
			this.joinOperators = new ArrayList<JoinOperator>();
		else {
			this.joinOperators = new ArrayList<JoinOperator>();
			ArrayList list = (ArrayList) m.get(Vocabulary.joinOperators_OP);
			for (Object map : list) {
				this.joinOperators.add(JoinOperatorBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.mainRelation_OP) == null)
			this.mainRelation = new Relation();
		else
			this.mainRelation = RelationBase.fromJson((LinkedHashMap) m.get(Vocabulary.mainRelation_OP));
	}

	public static CompositeRelation createFromJson(LinkedHashMap m) {
		return CompositeRelationBase.fromJson(m);
	}

	public static CompositeRelation fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.CompositeRelation_CLASS:
			return new CompositeRelation(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class CompositeRelation in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.CompositeRelation_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.CompositeRelation_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.joinOperators_OP, BaseObject.objectListToJson(joinOperators));
		m.put(Vocabulary.mainRelation_OP, mainRelation == null ? null : mainRelation.toJson());
		return m;
	}
}