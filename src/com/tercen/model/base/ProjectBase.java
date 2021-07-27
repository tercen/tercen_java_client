package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ProjectBase extends Document {

	public ProjectBase() {
		super();
	}

	public ProjectBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Project_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static Project createFromJson(LinkedHashMap m) {
		return ProjectBase.fromJson(m);
	}

	public static Project fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Project_CLASS:
			return new Project(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Project in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Project_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Project_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}