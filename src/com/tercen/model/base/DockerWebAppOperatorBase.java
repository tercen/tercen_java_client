package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class DockerWebAppOperatorBase extends WebAppOperator {

	public String container;

	public DockerWebAppOperatorBase() {
		super();
		this.container = "";
	}

	public DockerWebAppOperatorBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.DockerWebAppOperator_CLASS ? m.get(Vocabulary.KIND)
						: null);
		this.container = (String) m.get(Vocabulary.container_DP);
	}

	public static DockerWebAppOperator createFromJson(LinkedHashMap m) {
		return DockerWebAppOperatorBase.fromJson(m);
	}

	public static DockerWebAppOperator fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.DockerWebAppOperator_CLASS:
			return new DockerWebAppOperator(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class DockerWebAppOperator in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.DockerWebAppOperator_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.DockerWebAppOperator_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.container_DP, container);
		return m;
	}
}