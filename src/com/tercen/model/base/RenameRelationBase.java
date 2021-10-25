package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RenameRelationBase extends Relation {

	public Relation relation;
	public ArrayList<String> inNames;
	public ArrayList<String> outNames;

	public RenameRelationBase() {
		super();
		this.inNames = new ArrayList<String>();
		this.outNames = new ArrayList<String>();
		this.relation = new Relation();
	}

	public RenameRelationBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.RenameRelation_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.inNames_DP) == null)
			this.inNames = new ArrayList<String>();
		else
			this.inNames = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.inNames_DP)));
		if (m.get(Vocabulary.outNames_DP) == null)
			this.outNames = new ArrayList<String>();
		else
			this.outNames = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.outNames_DP)));
		if (m.get(Vocabulary.relation_OP) == null)
			this.relation = new Relation();
		else
			this.relation = RelationBase.fromJson((LinkedHashMap) m.get(Vocabulary.relation_OP));
	}

	public static RenameRelation createFromJson(LinkedHashMap m) {
		return RenameRelationBase.fromJson(m);
	}

	public static RenameRelation fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.RenameRelation_CLASS:
			return new RenameRelation(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class RenameRelation in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.RenameRelation_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.RenameRelation_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.relation_OP, relation == null ? null : relation.toJson());
		m.put(Vocabulary.inNames_DP, inNames);
		m.put(Vocabulary.outNames_DP, outNames);
		return m;
	}
}