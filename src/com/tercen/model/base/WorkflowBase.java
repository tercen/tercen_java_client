package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class WorkflowBase extends ProjectDocument {

	public LinkedList<Link> links;
	public LinkedList<Step> steps;
	public Point offset;

	public WorkflowBase() {
		super();
		this.links = new LinkedList<Link>();
		this.steps = new LinkedList<Step>();
		this.offset = new Point();
	}

	public WorkflowBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Workflow_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static Workflow createFromJson(LinkedHashMap m) {
		return WorkflowBase.fromJson(m);
	}

	public static Workflow fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Workflow_CLASS:
			return new Workflow(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Workflow in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Workflow_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Workflow_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.links_OP, BaseObject.objectListToJson(links));
		m.put(Vocabulary.steps_OP, BaseObject.objectListToJson(steps));
		m.put(Vocabulary.offset_OP, offset == null ? null : offset.toJson());
		return m;
	}
}