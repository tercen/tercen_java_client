package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TestOperatorTaskBase extends ProjectTask {

	public String operatorId;

	public TestOperatorTaskBase() {
		super();
		this.operatorId = "";
	}

	public TestOperatorTaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.TestOperatorTask_CLASS ? m.get(Vocabulary.KIND)
						: null);
		this.operatorId = (String) m.get(Vocabulary.operatorId_DP);
	}

	public static TestOperatorTask createFromJson(LinkedHashMap m) {
		return TestOperatorTaskBase.fromJson(m);
	}

	public static TestOperatorTask fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.TestOperatorTask_CLASS:
			return new TestOperatorTask(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class TestOperatorTask in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.TestOperatorTask_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.TestOperatorTask_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.operatorId_DP, operatorId);
		return m;
	}
}