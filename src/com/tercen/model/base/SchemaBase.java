package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class SchemaBase extends ProjectDocument {

	public int nRows;
	public ArrayList<ColumnSchema> columns;
	public String dataDirectory;
	public Relation relation;

	public SchemaBase() {
		super();
		this.nRows = 0;
		this.dataDirectory = "";
		this.columns = new ArrayList<ColumnSchema>();
		this.relation = new Relation();
	}

	public SchemaBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Schema_CLASS ? m.get(Vocabulary.KIND) : null);
		this.nRows = (int) m.get(Vocabulary.nRows_DP);
		this.dataDirectory = (String) m.get(Vocabulary.dataDirectory_DP);
		if (m.get(Vocabulary.columns_OP) == null)
			this.columns = new ArrayList<ColumnSchema>();
		else {
			ArrayList obj_list = new ArrayList();
			ArrayList list = (ArrayList) m.get(Vocabulary.columns_OP);
			for (Object map : list) {
				obj_list.add(ColumnSchemaBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.relation_OP) == null)
			this.relation = new Relation();
		else
			this.relation = RelationBase.fromJson((LinkedHashMap) m.get(Vocabulary.relation_OP));
	}

	public static Schema createFromJson(LinkedHashMap m) {
		return SchemaBase.fromJson(m);
	}

	public static Schema fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Schema_CLASS:
			return new Schema(m);
		case Vocabulary.CubeQueryTableSchema_CLASS:
			return new CubeQueryTableSchema(m);
		case Vocabulary.TableSchema_CLASS:
			return new TableSchema(m);
		case Vocabulary.ComputedTableSchema_CLASS:
			return new ComputedTableSchema(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Schema in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Schema_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Schema_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.nRows_DP, nRows);
		m.put(Vocabulary.columns_OP, BaseObject.objectListToJson(columns));
		m.put(Vocabulary.dataDirectory_DP, dataDirectory);
		m.put(Vocabulary.relation_OP, relation == null ? null : relation.toJson());
		return m;
	}
}