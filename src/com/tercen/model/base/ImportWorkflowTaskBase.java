package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ImportWorkflowTaskBase extends ProjectTask {

	public String fileId;
	public String workflowId;

	public ImportWorkflowTaskBase() {
		super();
		this.fileId = "";
		this.workflowId = "";
	}

	public ImportWorkflowTaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ImportWorkflowTask_CLASS ? m.get(Vocabulary.KIND)
						: null);
		this.fileId = (String) m.get(Vocabulary.fileId_DP);
		this.workflowId = (String) m.get(Vocabulary.workflowId_DP);
	}

	public static ImportWorkflowTask createFromJson(LinkedHashMap m) {
		return ImportWorkflowTaskBase.fromJson(m);
	}

	public static ImportWorkflowTask fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ImportWorkflowTask_CLASS:
			return new ImportWorkflowTask(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class ImportWorkflowTask in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ImportWorkflowTask_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ImportWorkflowTask_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.fileId_DP, fileId);
		m.put(Vocabulary.workflowId_DP, workflowId);
		return m;
	}
}