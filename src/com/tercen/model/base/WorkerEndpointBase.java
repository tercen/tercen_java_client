package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class WorkerEndpointBase extends Document {

	public String uri;

	public WorkerEndpointBase() {
		super();
		this.uri = "";
	}

	public WorkerEndpointBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.WorkerEndpoint_CLASS ? m.get(Vocabulary.KIND) : null);
		this.uri = (String) m.get(Vocabulary.uri_DP);
	}

	public static WorkerEndpoint createFromJson(LinkedHashMap m) {
		return WorkerEndpointBase.fromJson(m);
	}

	public static WorkerEndpoint fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.WorkerEndpoint_CLASS:
			return new WorkerEndpoint(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class WorkerEndpoint in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.WorkerEndpoint_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.WorkerEndpoint_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.uri_DP, uri);
		return m;
	}
}