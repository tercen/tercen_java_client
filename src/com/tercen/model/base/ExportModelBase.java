package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ExportModelBase extends StepModel {

	public ExportModelBase() {
		super();
	}

	public ExportModelBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ExportModel_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static ExportModel createFromJson(LinkedHashMap m) {
		return ExportModelBase.fromJson(m);
	}

	public static ExportModel fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ExportModel_CLASS:
			return new ExportModel(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class ExportModel in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ExportModel_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ExportModel_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}