package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class UnionRelationBase extends Relation {

	public LinkedList<Relation> relations;

	public UnionRelationBase() {
		super();
		this.relations = new LinkedList<Relation>();
	}

	public UnionRelationBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.UnionRelation_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static UnionRelation createFromJson(LinkedHashMap m) {
		return UnionRelationBase.fromJson(m);
	}

	public static UnionRelation fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.UnionRelation_CLASS:
			return new UnionRelation(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class UnionRelation in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.UnionRelation_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.UnionRelation_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.relations_OP, BaseObject.objectListToJson(relations));
		return m;
	}
}