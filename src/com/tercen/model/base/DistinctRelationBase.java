package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class DistinctRelationBase extends Relation {

	public Relation relation;
	public ArrayList<String> group;

	public DistinctRelationBase() {
		super();
		this.group = new ArrayList<String>();
		this.relation = new Relation();
	}

	public DistinctRelationBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.DistinctRelation_CLASS ? m.get(Vocabulary.KIND)
						: null);
		if (m.get(Vocabulary.group_DP) == null)
			this.group = new ArrayList<String>();
		else
			this.group = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.group_DP)));
		if (m.get(Vocabulary.relation_OP) == null)
			this.relation = new Relation();
		else
			this.relation = RelationBase.fromJson((LinkedHashMap) m.get(Vocabulary.relation_OP));
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