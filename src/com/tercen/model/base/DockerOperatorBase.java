package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class DockerOperatorBase extends GitOperator {

	public String container;

	public DockerOperatorBase() {
		super();
		this.container = "";
	}

	public DockerOperatorBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.DockerOperator_CLASS ? m.get(Vocabulary.KIND) : null);
		this.container = (String) m.get(Vocabulary.container_DP);
	}

	public static DockerOperator createFromJson(LinkedHashMap m) {
		return DockerOperatorBase.fromJson(m);
	}

	public static DockerOperator fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.DockerOperator_CLASS:
			return new DockerOperator(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class DockerOperator in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.DockerOperator_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.DockerOperator_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.container_DP, container);
		return m;
	}
}