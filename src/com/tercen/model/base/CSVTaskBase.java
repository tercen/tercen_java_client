package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CSVTaskBase extends ProjectTask {

	public String fileDocumentId;
	public String schemaId;
	public String valueName;
	public String variableName;
	public LinkedList<String> gatherNames;
	public Schema schema;
	public CSVParserParam params;

	public CSVTaskBase() {
		super();
		this.fileDocumentId = "";
		this.schemaId = "";
		this.valueName = "";
		this.variableName = "";
		this.gatherNames = new LinkedList<String>();
		this.schema = new Schema();
		this.params = new CSVParserParam();
	}

	public CSVTaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.CSVTask_CLASS ? m.get(Vocabulary.KIND) : null);
		this.fileDocumentId = (String) m.get(Vocabulary.fileDocumentId_DP);
		this.schemaId = (String) m.get(Vocabulary.schemaId_DP);
		this.valueName = (String) m.get(Vocabulary.valueName_DP);
		this.variableName = (String) m.get(Vocabulary.variableName_DP);
		this.gatherNames = new LinkedList<String>((Collection<? extends String>) (m.get(Vocabulary.gatherNames_DP)));
	}

	public static CSVTask createFromJson(LinkedHashMap m) {
		return CSVTaskBase.fromJson(m);
	}

	public static CSVTask fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.CSVTask_CLASS:
			return new CSVTask(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class CSVTask in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.CSVTask_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.CSVTask_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.fileDocumentId_DP, fileDocumentId);
		m.put(Vocabulary.schemaId_DP, schemaId);
		m.put(Vocabulary.valueName_DP, valueName);
		m.put(Vocabulary.variableName_DP, variableName);
		m.put(Vocabulary.gatherNames_DP, gatherNames);
		m.put(Vocabulary.schema_OP, schema == null ? null : schema.toJson());
		m.put(Vocabulary.params_OP, params == null ? null : params.toJson());
		return m;
	}
}