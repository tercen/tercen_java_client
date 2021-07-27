package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ExportWorkflowTaskBase extends ProjectTask {

	public String workflowId;
	public String fileId;

	public ExportWorkflowTaskBase() {
		super();
		this.workflowId = "";
		this.fileId = "";
	}

	public ExportWorkflowTaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ExportWorkflowTask_CLASS ? m.get(Vocabulary.KIND)
						: null);
		this.workflowId = (String) m.get(Vocabulary.workflowId_DP);
		this.fileId = (String) m.get(Vocabulary.fileId_DP);
	}

	public static ExportWorkflowTask createFromJson(LinkedHashMap m) {
		return ExportWorkflowTaskBase.fromJson(m);
	}

	public static ExportWorkflowTask fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ExportWorkflowTask_CLASS:
			return new ExportWorkflowTask(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class ExportWorkflowTask in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ExportWorkflowTask_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ExportWorkflowTask_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.workflowId_DP, workflowId);
		m.put(Vocabulary.fileId_DP, fileId);
		return m;
	}
}