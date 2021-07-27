package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ExportTableTaskBase extends ProjectTask {

	public String exportName;
	public LinkedList<String> schemaIds;
	public String exportType;
	public String exportToId;
	public String exportId;
	public LinkedList<String> namespaces;
	public LinkedList<String> exportedSchemaIds;

	public ExportTableTaskBase() {
		super();
		this.exportName = "";
		this.schemaIds = new LinkedList<String>();
		this.exportType = "";
		this.exportToId = "";
		this.exportId = "";
		this.namespaces = new LinkedList<String>();
		this.exportedSchemaIds = new LinkedList<String>();
	}

	public ExportTableTaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ExportTableTask_CLASS ? m.get(Vocabulary.KIND) : null);
		this.exportName = (String) m.get(Vocabulary.exportName_DP);
		this.schemaIds = new LinkedList<String>((Collection<? extends String>) (m.get(Vocabulary.schemaIds_DP)));
		this.exportType = (String) m.get(Vocabulary.exportType_DP);
		this.exportToId = (String) m.get(Vocabulary.exportToId_DP);
		this.exportId = (String) m.get(Vocabulary.exportId_DP);
		this.namespaces = new LinkedList<String>((Collection<? extends String>) (m.get(Vocabulary.namespaces_DP)));
		this.exportedSchemaIds = new LinkedList<String>(
				(Collection<? extends String>) (m.get(Vocabulary.exportedSchemaIds_DP)));
	}

	public static ExportTableTask createFromJson(LinkedHashMap m) {
		return ExportTableTaskBase.fromJson(m);
	}

	public static ExportTableTask fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ExportTableTask_CLASS:
			return new ExportTableTask(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class ExportTableTask in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ExportTableTask_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ExportTableTask_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.exportName_DP, exportName);
		m.put(Vocabulary.schemaIds_DP, schemaIds);
		m.put(Vocabulary.exportType_DP, exportType);
		m.put(Vocabulary.exportToId_DP, exportToId);
		m.put(Vocabulary.exportId_DP, exportId);
		m.put(Vocabulary.namespaces_DP, namespaces);
		m.put(Vocabulary.exportedSchemaIds_DP, exportedSchemaIds);
		return m;
	}
}