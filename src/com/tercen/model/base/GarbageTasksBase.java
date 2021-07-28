package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class GarbageTasksBase extends GarbageObject {

	public String workflowId;
	public ArrayList<String> deletedTaskIds;
	public ArrayList<String> addedTaskIds;
	public ArrayList<String> deletedStepIds;

	public GarbageTasksBase() {
		super();
		this.workflowId = "";
		this.deletedTaskIds = new ArrayList<String>();
		this.addedTaskIds = new ArrayList<String>();
		this.deletedStepIds = new ArrayList<String>();
	}

	public GarbageTasksBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.GarbageTasks_CLASS ? m.get(Vocabulary.KIND) : null);
		this.workflowId = (String) m.get(Vocabulary.workflowId_DP);
		this.deletedTaskIds = new ArrayList<String>(
				(Collection<? extends String>) (m.get(Vocabulary.deletedTaskIds_DP)));
		this.addedTaskIds = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.addedTaskIds_DP)));
		this.deletedStepIds = new ArrayList<String>(
				(Collection<? extends String>) (m.get(Vocabulary.deletedStepIds_DP)));
	}

	public static GarbageTasks createFromJson(LinkedHashMap m) {
		return GarbageTasksBase.fromJson(m);
	}

	public static GarbageTasks fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.GarbageTasks_CLASS:
			return new GarbageTasks(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class GarbageTasks in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.GarbageTasks_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.GarbageTasks_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.workflowId_DP, workflowId);
		m.put(Vocabulary.deletedTaskIds_DP, deletedTaskIds);
		m.put(Vocabulary.addedTaskIds_DP, addedTaskIds);
		m.put(Vocabulary.deletedStepIds_DP, deletedStepIds);
		return m;
	}
}