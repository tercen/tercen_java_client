package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class GraphicalFactorBase extends BaseObject {

	public Factor factor;
	public Rectangle rectangle;

	public GraphicalFactorBase() {
		super();
		this.factor = new Factor();
		this.rectangle = new Rectangle();
	}

	public GraphicalFactorBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.GraphicalFactor_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.factor_OP) == null)
			this.factor = new Factor();
		else
			this.factor = FactorBase.fromJson((LinkedHashMap) m.get(Vocabulary.factor_OP));
		if (m.get(Vocabulary.rectangle_OP) == null)
			this.rectangle = new Rectangle();
		else
			this.rectangle = RectangleBase.fromJson((LinkedHashMap) m.get(Vocabulary.rectangle_OP));
	}

	public static GraphicalFactor createFromJson(LinkedHashMap m) {
		return GraphicalFactorBase.fromJson(m);
	}

	public static GraphicalFactor fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.GraphicalFactor_CLASS:
			return new GraphicalFactor(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class GraphicalFactor in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.GraphicalFactor_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.GraphicalFactor_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.factor_OP, factor == null ? null : factor.toJson());
		m.put(Vocabulary.rectangle_OP, rectangle == null ? null : rectangle.toJson());
		return m;
	}
}