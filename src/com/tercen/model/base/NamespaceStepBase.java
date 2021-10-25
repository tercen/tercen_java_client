package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class NamespaceStepBase extends RelationStep {

	public NamespaceStepBase() {
		super();
	}

	public NamespaceStepBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.NamespaceStep_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static NamespaceStep createFromJson(LinkedHashMap m) {
		return NamespaceStepBase.fromJson(m);
	}

	public static NamespaceStep fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.NamespaceStep_CLASS:
			return new NamespaceStep(m);
		case Vocabulary.DataStep_CLASS:
			return new DataStep(m);
		case Vocabulary.MeltStep_CLASS:
			return new MeltStep(m);
		case Vocabulary.JoinStep_CLASS:
			return new JoinStep(m);
		case Vocabulary.WizardStep_CLASS:
			return new WizardStep(m);
		case Vocabulary.CrossTabStep_CLASS:
			return new CrossTabStep(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class NamespaceStep in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.NamespaceStep_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.NamespaceStep_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}