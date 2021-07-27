package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class GroupStepBase extends RelationStep {

	public String appId;
	public String appName;
	public String version;
	public Point offset;

	public GroupStepBase() {
		super();
		this.appId = "";
		this.appName = "";
		this.version = "";
		this.offset = new Point();
	}

	public GroupStepBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.GroupStep_CLASS ? m.get(Vocabulary.KIND) : null);
		this.appId = (String) m.get(Vocabulary.appId_DP);
		this.appName = (String) m.get(Vocabulary.appName_DP);
		this.version = (String) m.get(Vocabulary.version_DP);
	}

	public static GroupStep createFromJson(LinkedHashMap m) {
		return GroupStepBase.fromJson(m);
	}

	public static GroupStep fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.GroupStep_CLASS:
			return new GroupStep(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class GroupStep in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.GroupStep_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.GroupStep_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.appId_DP, appId);
		m.put(Vocabulary.appName_DP, appName);
		m.put(Vocabulary.version_DP, version);
		m.put(Vocabulary.offset_OP, offset == null ? null : offset.toJson());
		return m;
	}
}