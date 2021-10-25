package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ChartPointBase extends ChartSize {

	public ChartPointBase() {
		super();
	}

	public ChartPointBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ChartPoint_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static ChartPoint createFromJson(LinkedHashMap m) {
		return ChartPointBase.fromJson(m);
	}

	public static ChartPoint fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ChartPoint_CLASS:
			return new ChartPoint(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class ChartPoint in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ChartPoint_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ChartPoint_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}