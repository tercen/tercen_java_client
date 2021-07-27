package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class StepModelBase extends BaseObject {

	public StepModelBase() {
		super();
	}

	public StepModelBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.StepModel_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static StepModel createFromJson(LinkedHashMap m) {
		return StepModelBase.fromJson(m);
	}

	public static StepModel fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.StepModel_CLASS:
			return new StepModel(m);
		case Vocabulary.TableStepModel_CLASS:
			return new TableStepModel(m);
		case Vocabulary.Crosstab_CLASS:
			return new Crosstab(m);
		case Vocabulary.JoinStepModel_CLASS:
			return new JoinStepModel(m);
		case Vocabulary.WizardStepModel_CLASS:
			return new WizardStepModel(m);
		case Vocabulary.MeltStepModel_CLASS:
			return new MeltStepModel(m);
		case Vocabulary.ExportModel_CLASS:
			return new ExportModel(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class StepModel in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.StepModel_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.StepModel_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}