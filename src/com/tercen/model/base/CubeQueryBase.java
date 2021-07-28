package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CubeQueryBase extends BaseObject {

	public Relation relation;
	public ArrayList<Factor> colColumns;
	public ArrayList<Factor> rowColumns;
	public ArrayList<CubeAxisQuery> axisQueries;
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
		this.colColumns = new ArrayList<Factor>();
		this.rowColumns = new ArrayList<Factor>();
		this.axisQueries = new ArrayList<CubeAxisQuery>();
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
		if (m.get(Vocabulary.relation_OP) == null)
			this.relation = new Relation();
		else
			this.relation = RelationBase.fromJson((LinkedHashMap) m.get(Vocabulary.relation_OP));
		if (m.get(Vocabulary.colColumns_OP) == null)
			this.colColumns = new ArrayList<Factor>();
		else {
			ArrayList obj_list = new ArrayList();
			ArrayList list = (ArrayList) m.get(Vocabulary.colColumns_OP);
			for (Object map : list) {
				obj_list.add(FactorBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.rowColumns_OP) == null)
			this.rowColumns = new ArrayList<Factor>();
		else {
			ArrayList obj_list = new ArrayList();
			ArrayList list = (ArrayList) m.get(Vocabulary.rowColumns_OP);
			for (Object map : list) {
				obj_list.add(FactorBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.axisQueries_OP) == null)
			this.axisQueries = new ArrayList<CubeAxisQuery>();
		else {
			ArrayList obj_list = new ArrayList();
			ArrayList list = (ArrayList) m.get(Vocabulary.axisQueries_OP);
			for (Object map : list) {
				obj_list.add(CubeAxisQueryBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.filters_OP) == null)
			this.filters = new Filters();
		else
			this.filters = FiltersBase.fromJson((LinkedHashMap) m.get(Vocabulary.filters_OP));
		if (m.get(Vocabulary.operatorSettings_OP) == null)
			this.operatorSettings = new OperatorSettings();
		else
			this.operatorSettings = OperatorSettingsBase
					.fromJson((LinkedHashMap) m.get(Vocabulary.operatorSettings_OP));
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