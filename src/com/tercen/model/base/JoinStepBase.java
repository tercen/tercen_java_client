package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class JoinStepBase extends NamespaceStep {

	public JoinStepModel model;
	public LinkedList<Attribute> rightAttributes;

	public JoinStepBase() {
		super();
		this.model = new JoinStepModel();
		this.rightAttributes = new LinkedList<Attribute>();
	}

	public JoinStepBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.JoinStep_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static JoinStep createFromJson(LinkedHashMap m) {
		return JoinStepBase.fromJson(m);
	}

	public static JoinStep fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.JoinStep_CLASS:
			return new JoinStep(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class JoinStep in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.JoinStep_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.JoinStep_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.model_OP, model == null ? null : model.toJson());
		m.put(Vocabulary.rightAttributes_OP, BaseObject.objectListToJson(rightAttributes));
		return m;
	}
}