package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PointBase extends BaseObject {

	public double x;
	public double y;

	public PointBase() {
		super();
		this.x = 0.0;
		this.y = 0.0;
	}

	public PointBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Point_CLASS ? m.get(Vocabulary.KIND) : null);
		this.x = (double) (m.get(Vocabulary.x_DP));
		this.y = (double) (m.get(Vocabulary.y_DP));
	}

	public static Point createFromJson(LinkedHashMap m) {
		return PointBase.fromJson(m);
	}

	public static Point fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Point_CLASS:
			return new Point(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Point in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Point_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Point_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.x_DP, x);
		m.put(Vocabulary.y_DP, y);
		return m;
	}
}