package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ExportStepBase extends ModelStep {

	public ExportModel model;

	public ExportStepBase() {
		super();
		this.model = new ExportModel();
	}

	public ExportStepBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ExportStep_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.model_OP) == null)
			this.model = new ExportModel();
		else
			this.model = ExportModelBase.fromJson((LinkedHashMap) m.get(Vocabulary.model_OP));
	}

	public static ExportStep createFromJson(LinkedHashMap m) {
		return ExportStepBase.fromJson(m);
	}

	public static ExportStep fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ExportStep_CLASS:
			return new ExportStep(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class ExportStep in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ExportStep_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ExportStep_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.model_OP, model == null ? null : model.toJson());
		return m;
	}
}