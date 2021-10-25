package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class OutStepBase extends RelationStep {

	public Point groupPortPosition;

	public OutStepBase() {
		super();
		this.groupPortPosition = new Point();
	}

	public OutStepBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.OutStep_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.groupPortPosition_OP) == null)
			this.groupPortPosition = new Point();
		else
			this.groupPortPosition = PointBase.fromJson((LinkedHashMap) m.get(Vocabulary.groupPortPosition_OP));
	}

	public static OutStep createFromJson(LinkedHashMap m) {
		return OutStepBase.fromJson(m);
	}

	public static OutStep fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.OutStep_CLASS:
			return new OutStep(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class OutStep in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.OutStep_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.OutStep_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.groupPortPosition_OP, groupPortPosition == null ? null : groupPortPosition.toJson());
		return m;
	}
}