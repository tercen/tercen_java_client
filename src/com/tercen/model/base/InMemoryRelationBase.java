package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class InMemoryRelationBase extends Relation {

	public Table inMemoryTable;

	public InMemoryRelationBase() {
		super();
		this.inMemoryTable = new Table();
	}

	public InMemoryRelationBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.InMemoryRelation_CLASS ? m.get(Vocabulary.KIND)
						: null);
	}

	public static InMemoryRelation createFromJson(LinkedHashMap m) {
		return InMemoryRelationBase.fromJson(m);
	}

	public static InMemoryRelation fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.InMemoryRelation_CLASS:
			return new InMemoryRelation(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class InMemoryRelation in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.InMemoryRelation_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.InMemoryRelation_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.inMemoryTable_OP, inMemoryTable == null ? null : inMemoryTable.toJson());
		return m;
	}
}