package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ChartLineBase extends ChartSize {

	public ChartLineBase() {
		super();
	}

	public ChartLineBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ChartLine_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static ChartLine createFromJson(LinkedHashMap m) {
		return ChartLineBase.fromJson(m);
	}

	public static ChartLine fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ChartLine_CLASS:
			return new ChartLine(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class ChartLine in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ChartLine_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ChartLine_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}