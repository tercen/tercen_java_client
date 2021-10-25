package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ProjectDocumentBase extends Document {

	public String projectId;
	public String folderId;

	public ProjectDocumentBase() {
		super();
		this.projectId = "";
		this.folderId = "";
	}

	public ProjectDocumentBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ProjectDocument_CLASS ? m.get(Vocabulary.KIND) : null);
		this.projectId = (String) m.get(Vocabulary.projectId_DP);
		this.folderId = (String) m.get(Vocabulary.folderId_DP);
	}

	public static ProjectDocument createFromJson(LinkedHashMap m) {
		return ProjectDocumentBase.fromJson(m);
	}

	public static ProjectDocument fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ProjectDocument_CLASS:
			return new ProjectDocument(m);
		case Vocabulary.CubeQueryTableSchema_CLASS:
			return new CubeQueryTableSchema(m);
		case Vocabulary.TableSchema_CLASS:
			return new TableSchema(m);
		case Vocabulary.ComputedTableSchema_CLASS:
			return new ComputedTableSchema(m);
		case Vocabulary.Issue_CLASS:
			return new Issue(m);
		case Vocabulary.FileDocument_CLASS:
			return new FileDocument(m);
		case Vocabulary.FolderDocument_CLASS:
			return new FolderDocument(m);
		case Vocabulary.Schema_CLASS:
			return new Schema(m);
		case Vocabulary.IssueMessage_CLASS:
			return new IssueMessage(m);
		case Vocabulary.Workflow_CLASS:
			return new Workflow(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class ProjectDocument in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ProjectDocument_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ProjectDocument_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.projectId_DP, projectId);
		m.put(Vocabulary.folderId_DP, folderId);
		return m;
	}
}