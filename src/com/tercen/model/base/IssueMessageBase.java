package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class IssueMessageBase extends ProjectDocument {

	public String issueId;
	public String body;

	public IssueMessageBase() {
		super();
		this.issueId = "";
		this.body = "";
	}

	public IssueMessageBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.IssueMessage_CLASS ? m.get(Vocabulary.KIND) : null);
		this.issueId = (String) m.get(Vocabulary.issueId_DP);
		this.body = (String) m.get(Vocabulary.body_DP);
	}

	public static IssueMessage createFromJson(LinkedHashMap m) {
		return IssueMessageBase.fromJson(m);
	}

	public static IssueMessage fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.IssueMessage_CLASS:
			return new IssueMessage(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class IssueMessage in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.IssueMessage_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.IssueMessage_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.issueId_DP, issueId);
		m.put(Vocabulary.body_DP, body);
		return m;
	}
}