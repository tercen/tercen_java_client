package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ViewStepBase extends Step {

	public ViewStepBase() {
		super();
	}

	public ViewStepBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ViewStep_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static ViewStep createFromJson(LinkedHashMap m) {
		return ViewStepBase.fromJson(m);
	}

	public static ViewStep fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ViewStep_CLASS:
			return new ViewStep(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class ViewStep in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ViewStep_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ViewStep_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}