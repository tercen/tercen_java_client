package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class SaveComputationResultTaskBase extends ComputationTask {

	public SaveComputationResultTaskBase() {
		super();
	}

	public SaveComputationResultTaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.SaveComputationResultTask_CLASS
						? m.get(Vocabulary.KIND)
						: null);
	}

	public static SaveComputationResultTask createFromJson(LinkedHashMap m) {
		return SaveComputationResultTaskBase.fromJson(m);
	}

	public static SaveComputationResultTask fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.SaveComputationResultTask_CLASS:
			return new SaveComputationResultTask(m);
		case Vocabulary.RunComputationTask_CLASS:
			return new RunComputationTask(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class SaveComputationResultTask in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.SaveComputationResultTask_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.SaveComputationResultTask_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}