package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ProjectTaskBase extends Task {

	public String projectId;

	public ProjectTaskBase() {
		super();
		this.projectId = "";
	}

	public ProjectTaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ProjectTask_CLASS ? m.get(Vocabulary.KIND) : null);
		this.projectId = (String) m.get(Vocabulary.projectId_DP);
	}

	public static ProjectTask createFromJson(LinkedHashMap m) {
		return ProjectTaskBase.fromJson(m);
	}

	public static ProjectTask fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ProjectTask_CLASS:
			return new ProjectTask(m);
		case Vocabulary.RunComputationTask_CLASS:
			return new RunComputationTask(m);
		case Vocabulary.SaveComputationResultTask_CLASS:
			return new SaveComputationResultTask(m);
		case Vocabulary.ComputationTask_CLASS:
			return new ComputationTask(m);
		case Vocabulary.ExportWorkflowTask_CLASS:
			return new ExportWorkflowTask(m);
		case Vocabulary.CSVTask_CLASS:
			return new CSVTask(m);
		case Vocabulary.CubeQueryTask_CLASS:
			return new CubeQueryTask(m);
		case Vocabulary.ImportWorkflowTask_CLASS:
			return new ImportWorkflowTask(m);
		case Vocabulary.TestOperatorTask_CLASS:
			return new TestOperatorTask(m);
		case Vocabulary.ImportGitWorkflowTask_CLASS:
			return new ImportGitWorkflowTask(m);
		case Vocabulary.RunWebAppTask_CLASS:
			return new RunWebAppTask(m);
		case Vocabulary.ExportTableTask_CLASS:
			return new ExportTableTask(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class ProjectTask in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ProjectTask_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ProjectTask_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.projectId_DP, projectId);
		return m;
	}
}