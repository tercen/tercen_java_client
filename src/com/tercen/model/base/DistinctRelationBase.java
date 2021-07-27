package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class DistinctRelationBase extends Relation {

	public Relation relation;
	public LinkedList<String> group;

	public DistinctRelationBase() {
		super();
		this.group = new LinkedList<String>();
		this.relation = new Relation();
	}

	public DistinctRelationBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.DistinctRelation_CLASS ? m.get(Vocabulary.KIND)
						: null);
		this.group = new LinkedList<String>((Collection<? extends String>) (m.get(Vocabulary.group_DP)));
	}

	public static DistinctRelation createFromJson(LinkedHashMap m) {
		return DistinctRelationBase.fromJson(m);
	}

	public static DistinctRelation fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.DistinctRelation_CLASS:
			return new DistinctRelation(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class DistinctRelation in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.DistinctRelation_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.DistinctRelation_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.relation_OP, relation == null ? null : relation.toJson());
		m.put(Vocabulary.group_DP, group);
		return m;
	}
}