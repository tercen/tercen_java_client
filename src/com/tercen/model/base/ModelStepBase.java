package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ModelStepBase extends Step {

	public ModelStepBase() {
		super();
	}

	public ModelStepBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ModelStep_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static ModelStep createFromJson(LinkedHashMap m) {
		return ModelStepBase.fromJson(m);
	}

	public static ModelStep fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ModelStep_CLASS:
			return new ModelStep(m);
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
		case Vocabulary.GroupStep_CLASS:
			return new GroupStep(m);
		case Vocabulary.InStep_CLASS:
			return new InStep(m);
		case Vocabulary.OutStep_CLASS:
			return new OutStep(m);
		case Vocabulary.TableStep_CLASS:
			return new TableStep(m);
		case Vocabulary.NamespaceStep_CLASS:
			return new NamespaceStep(m);
		case Vocabulary.RelationStep_CLASS:
			return new RelationStep(m);
		case Vocabulary.ExportStep_CLASS:
			return new ExportStep(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class ModelStep in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ModelStep_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ModelStep_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}