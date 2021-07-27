package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RelationBase extends IdObject {

	public RelationBase() {
		super();
	}

	public RelationBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Relation_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static Relation createFromJson(LinkedHashMap m) {
		return RelationBase.fromJson(m);
	}

	public static Relation fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Relation_CLASS:
			return new Relation(m);
		case Vocabulary.ReferenceRelation_CLASS:
			return new ReferenceRelation(m);
		case Vocabulary.WhereRelation_CLASS:
			return new WhereRelation(m);
		case Vocabulary.DistinctRelation_CLASS:
			return new DistinctRelation(m);
		case Vocabulary.InMemoryRelation_CLASS:
			return new InMemoryRelation(m);
		case Vocabulary.RenameRelation_CLASS:
			return new RenameRelation(m);
		case Vocabulary.UnionRelation_CLASS:
			return new UnionRelation(m);
		case Vocabulary.SimpleRelation_CLASS:
			return new SimpleRelation(m);
		case Vocabulary.GatherRelation_CLASS:
			return new GatherRelation(m);
		case Vocabulary.CompositeRelation_CLASS:
			return new CompositeRelation(m);
		case Vocabulary.GroupByRelation_CLASS:
			return new GroupByRelation(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Relation in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Relation_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Relation_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}