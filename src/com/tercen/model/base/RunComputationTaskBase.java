package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RunComputationTaskBase extends SaveComputationResultTask {

	public RunComputationTaskBase() {
		super();
	}

	public RunComputationTaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.RunComputationTask_CLASS ? m.get(Vocabulary.KIND)
						: null);
	}

	public static RunComputationTask createFromJson(LinkedHashMap m) {
		return RunComputationTaskBase.fromJson(m);
	}

	public static RunComputationTask fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.RunComputationTask_CLASS:
			return new RunComputationTask(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class RunComputationTask in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.RunComputationTask_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.RunComputationTask_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}