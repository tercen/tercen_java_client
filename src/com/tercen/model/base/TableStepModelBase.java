package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TableStepModelBase extends StepModel {

	public Relation relation;

	public TableStepModelBase() {
		super();
		this.relation = new Relation();
	}

	public TableStepModelBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.TableStepModel_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.relation_OP) == null)
			this.relation = new Relation();
		else
			this.relation = RelationBase.fromJson((LinkedHashMap) m.get(Vocabulary.relation_OP));
	}

	public static TableStepModel createFromJson(LinkedHashMap m) {
		return TableStepModelBase.fromJson(m);
	}

	public static TableStepModel fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.TableStepModel_CLASS:
			return new TableStepModel(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class TableStepModel in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.TableStepModel_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.TableStepModel_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.relation_OP, relation == null ? null : relation.toJson());
		return m;
	}
}