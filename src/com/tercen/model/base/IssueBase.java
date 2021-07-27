package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class IssueBase extends ProjectDocument {

	public IssueBase() {
		super();
	}

	public IssueBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Issue_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static Issue createFromJson(LinkedHashMap m) {
		return IssueBase.fromJson(m);
	}

	public static Issue fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Issue_CLASS:
			return new Issue(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Issue in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Issue_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Issue_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}