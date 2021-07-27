package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class GroupByRelationBase extends Relation {

	public Relation relation;
	public LinkedList<String> group;

	public GroupByRelationBase() {
		super();
		this.group = new LinkedList<String>();
		this.relation = new Relation();
	}

	public GroupByRelationBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.GroupByRelation_CLASS ? m.get(Vocabulary.KIND) : null);
		this.group = new LinkedList<String>((Collection<? extends String>) (m.get(Vocabulary.group_DP)));
	}

	public static GroupByRelation createFromJson(LinkedHashMap m) {
		return GroupByRelationBase.fromJson(m);
	}

	public static GroupByRelation fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.GroupByRelation_CLASS:
			return new GroupByRelation(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class GroupByRelation in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.GroupByRelation_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.GroupByRelation_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.relation_OP, relation == null ? null : relation.toJson());
		m.put(Vocabulary.group_DP, group);
		return m;
	}
}