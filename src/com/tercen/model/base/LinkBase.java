package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class LinkBase extends IdObject {

	public String inputId;
	public String outputId;

	public LinkBase() {
		super();
		this.inputId = "";
		this.outputId = "";
	}

	public LinkBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Link_CLASS ? m.get(Vocabulary.KIND) : null);
		this.inputId = (String) m.get(Vocabulary.inputId_DP);
		this.outputId = (String) m.get(Vocabulary.outputId_DP);
	}

	public static Link createFromJson(LinkedHashMap m) {
		return LinkBase.fromJson(m);
	}

	public static Link fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Link_CLASS:
			return new Link(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Link in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Link_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Link_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.inputId_DP, inputId);
		m.put(Vocabulary.outputId_DP, outputId);
		return m;
	}
}