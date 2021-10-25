package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ActivityBase extends PersistentObject {

	public String type;
	public String objectKind;
	public Date date;
	public String teamId;
	public String projectId;
	public String userId;
	public String projectName;
	public boolean isPublic;
	public ArrayList<Pair> properties;

	public ActivityBase() {
		super();
		this.type = "";
		this.objectKind = "";
		this.teamId = "";
		this.projectId = "";
		this.userId = "";
		this.projectName = "";
		this.isPublic = true;
		this.date = new Date();
		this.properties = new ArrayList<Pair>();
	}

	public ActivityBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Activity_CLASS ? m.get(Vocabulary.KIND) : null);
		this.type = (String) m.get(Vocabulary.type_DP);
		this.objectKind = (String) m.get(Vocabulary.objectKind_DP);
		this.teamId = (String) m.get(Vocabulary.teamId_DP);
		this.projectId = (String) m.get(Vocabulary.projectId_DP);
		this.userId = (String) m.get(Vocabulary.userId_DP);
		this.projectName = (String) m.get(Vocabulary.projectName_DP);
		this.isPublic = (boolean) m.get(Vocabulary.isPublic_DP);
		if (m.get(Vocabulary.date_OP) == null)
			this.date = new Date();
		else
			this.date = DateBase.fromJson((LinkedHashMap) m.get(Vocabulary.date_OP));
		if (m.get(Vocabulary.properties_OP) == null)
			this.properties = new ArrayList<Pair>();
		else {
			this.properties = new ArrayList<Pair>();
			ArrayList list = (ArrayList) m.get(Vocabulary.properties_OP);
			for (Object map : list) {
				this.properties.add(PairBase.createFromJson((LinkedHashMap) map));
			}
		}
	}

	public static Activity createFromJson(LinkedHashMap m) {
		return ActivityBase.fromJson(m);
	}

	public static Activity fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Activity_CLASS:
			return new Activity(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Activity in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Activity_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Activity_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.type_DP, type);
		m.put(Vocabulary.objectKind_DP, objectKind);
		m.put(Vocabulary.date_OP, date == null ? null : date.toJson());
		m.put(Vocabulary.teamId_DP, teamId);
		m.put(Vocabulary.projectId_DP, projectId);
		m.put(Vocabulary.userId_DP, userId);
		m.put(Vocabulary.projectName_DP, projectName);
		m.put(Vocabulary.isPublic_DP, isPublic);
		m.put(Vocabulary.properties_OP, BaseObject.objectListToJson(properties));
		return m;
	}
}