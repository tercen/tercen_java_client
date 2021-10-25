package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class GitOperatorBase extends Operator {

	public String path;

	public GitOperatorBase() {
		super();
		this.path = "";
	}

	public GitOperatorBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.GitOperator_CLASS ? m.get(Vocabulary.KIND) : null);
		this.path = (String) m.get(Vocabulary.path_DP);
	}

	public static GitOperator createFromJson(LinkedHashMap m) {
		return GitOperatorBase.fromJson(m);
	}

	public static GitOperator fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.GitOperator_CLASS:
			return new GitOperator(m);
		case Vocabulary.ShinyOperator_CLASS:
			return new ShinyOperator(m);
		case Vocabulary.DockerWebAppOperator_CLASS:
			return new DockerWebAppOperator(m);
		case Vocabulary.DockerOperator_CLASS:
			return new DockerOperator(m);
		case Vocabulary.ROperator_CLASS:
			return new ROperator(m);
		case Vocabulary.WebAppOperator_CLASS:
			return new WebAppOperator(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class GitOperator in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.GitOperator_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.GitOperator_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.path_DP, path);
		return m;
	}
}