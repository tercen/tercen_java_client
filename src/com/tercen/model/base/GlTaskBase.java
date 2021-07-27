package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class GlTaskBase extends Task {

	public String glQuery;

	public GlTaskBase() {
		super();
		this.glQuery = "";
	}

	public GlTaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.GlTask_CLASS ? m.get(Vocabulary.KIND) : null);
		this.glQuery = (String) m.get(Vocabulary.glQuery_DP);
	}

	public static GlTask createFromJson(LinkedHashMap m) {
		return GlTaskBase.fromJson(m);
	}

	public static GlTask fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.GlTask_CLASS:
			return new GlTask(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class GlTask in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.GlTask_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.GlTask_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.glQuery_DP, glQuery);
		return m;
	}
}