package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ComputationTaskBase extends CubeQueryTask {

	public String parentTaskId;
	public String fileResultId;
	public Relation computedRelation;

	public ComputationTaskBase() {
		super();
		this.parentTaskId = "";
		this.fileResultId = "";
		this.computedRelation = new Relation();
	}

	public ComputationTaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ComputationTask_CLASS ? m.get(Vocabulary.KIND) : null);
		this.parentTaskId = (String) m.get(Vocabulary.parentTaskId_DP);
		this.fileResultId = (String) m.get(Vocabulary.fileResultId_DP);
		if (m.get(Vocabulary.computedRelation_OP) == null)
			this.computedRelation = new Relation();
		else
			this.computedRelation = RelationBase.fromJson((LinkedHashMap) m.get(Vocabulary.computedRelation_OP));
	}

	public static ComputationTask createFromJson(LinkedHashMap m) {
		return ComputationTaskBase.fromJson(m);
	}

	public static ComputationTask fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ComputationTask_CLASS:
			return new ComputationTask(m);
		case Vocabulary.RunComputationTask_CLASS:
			return new RunComputationTask(m);
		case Vocabulary.SaveComputationResultTask_CLASS:
			return new SaveComputationResultTask(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class ComputationTask in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ComputationTask_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ComputationTask_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.parentTaskId_DP, parentTaskId);
		m.put(Vocabulary.fileResultId_DP, fileResultId);
		m.put(Vocabulary.computedRelation_OP, computedRelation == null ? null : computedRelation.toJson());
		return m;
	}
}