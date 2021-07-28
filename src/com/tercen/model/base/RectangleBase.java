package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RectangleBase extends BaseObject {

	public Point extent;
	public Point topLeft;

	public RectangleBase() {
		super();
		this.extent = new Point();
		this.topLeft = new Point();
	}

	public RectangleBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Rectangle_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.extent_OP) == null)
			this.extent = new Point();
		else
			this.extent = PointBase.fromJson((LinkedHashMap) m.get(Vocabulary.extent_OP));
		if (m.get(Vocabulary.topLeft_OP) == null)
			this.topLeft = new Point();
		else
			this.topLeft = PointBase.fromJson((LinkedHashMap) m.get(Vocabulary.topLeft_OP));
	}

	public static Rectangle createFromJson(LinkedHashMap m) {
		return RectangleBase.fromJson(m);
	}

	public static Rectangle fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Rectangle_CLASS:
			return new Rectangle(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Rectangle in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Rectangle_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Rectangle_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.extent_OP, extent == null ? null : extent.toJson());
		m.put(Vocabulary.topLeft_OP, topLeft == null ? null : topLeft.toJson());
		return m;
	}
}