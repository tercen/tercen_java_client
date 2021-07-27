package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CubeQueryTaskBase extends ProjectTask {

	public CubeQuery query;
	public boolean removeOnGC;
	public LinkedList<String> schemaIds;

	public CubeQueryTaskBase() {
		super();
		this.removeOnGC = true;
		this.schemaIds = new LinkedList<String>();
		this.query = new CubeQuery();
	}

	public CubeQueryTaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.CubeQueryTask_CLASS ? m.get(Vocabulary.KIND) : null);
		this.removeOnGC = (boolean) m.get(Vocabulary.removeOnGC_DP);
		this.schemaIds = new LinkedList<String>((Collection<? extends String>) (m.get(Vocabulary.schemaIds_DP)));
	}

	public static CubeQueryTask createFromJson(LinkedHashMap m) {
		return CubeQueryTaskBase.fromJson(m);
	}

	public static CubeQueryTask fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.CubeQueryTask_CLASS:
			return new CubeQueryTask(m);
		case Vocabulary.RunComputationTask_CLASS:
			return new RunComputationTask(m);
		case Vocabulary.SaveComputationResultTask_CLASS:
			return new SaveComputationResultTask(m);
		case Vocabulary.ComputationTask_CLASS:
			return new ComputationTask(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class CubeQueryTask in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.CubeQueryTask_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.CubeQueryTask_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.query_OP, query == null ? null : query.toJson());
		m.put(Vocabulary.removeOnGC_DP, removeOnGC);
		m.put(Vocabulary.schemaIds_DP, schemaIds);
		return m;
	}
}