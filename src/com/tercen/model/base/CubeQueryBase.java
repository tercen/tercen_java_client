package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CubeQueryBase extends BaseObject {

	public Relation relation;
	public LinkedList<Factor> colColumns;
	public LinkedList<Factor> rowColumns;
	public LinkedList<CubeAxisQuery> axisQueries;
	public Filters filters;
	public OperatorSettings operatorSettings;
	public String qtHash;
	public String columnHash;
	public String rowHash;

	public CubeQueryBase() {
		super();
		this.qtHash = "";
		this.columnHash = "";
		this.rowHash = "";
		this.relation = new Relation();
		this.colColumns = new LinkedList<Factor>();
		this.rowColumns = new LinkedList<Factor>();
		this.axisQueries = new LinkedList<CubeAxisQuery>();
		this.filters = new Filters();
		this.operatorSettings = new OperatorSettings();
	}

	public CubeQueryBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.CubeQuery_CLASS ? m.get(Vocabulary.KIND) : null);
		this.qtHash = (String) m.get(Vocabulary.qtHash_DP);
		this.columnHash = (String) m.get(Vocabulary.columnHash_DP);
		this.rowHash = (String) m.get(Vocabulary.rowHash_DP);
	}

	public static CubeQuery createFromJson(LinkedHashMap m) {
		return CubeQueryBase.fromJson(m);
	}

	public static CubeQuery fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.CubeQuery_CLASS:
			return new CubeQuery(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class CubeQuery in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.CubeQuery_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.CubeQuery_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.relation_OP, relation == null ? null : relation.toJson());
		m.put(Vocabulary.colColumns_OP, BaseObject.objectListToJson(colColumns));
		m.put(Vocabulary.rowColumns_OP, BaseObject.objectListToJson(rowColumns));
		m.put(Vocabulary.axisQueries_OP, BaseObject.objectListToJson(axisQueries));
		m.put(Vocabulary.filters_OP, filters == null ? null : filters.toJson());
		m.put(Vocabulary.operatorSettings_OP, operatorSettings == null ? null : operatorSettings.toJson());
		m.put(Vocabulary.qtHash_DP, qtHash);
		m.put(Vocabulary.columnHash_DP, columnHash);
		m.put(Vocabulary.rowHash_DP, rowHash);
		return m;
	}
}