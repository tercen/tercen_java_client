package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TableBase extends BaseObject {

	public int nRows;
	public TableProperties properties;
	public LinkedList<Column> columns;

	public TableBase() {
		super();
		this.nRows = 0;
		this.properties = new TableProperties();
		this.columns = new LinkedList<Column>();
	}

	public TableBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Table_CLASS ? m.get(Vocabulary.KIND) : null);
		this.nRows = (int) m.get(Vocabulary.nRows_DP);
	}

	public static Table createFromJson(LinkedHashMap m) {
		return TableBase.fromJson(m);
	}

	public static Table fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Table_CLASS:
			return new Table(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Table in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Table_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Table_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.nRows_DP, nRows);
		m.put(Vocabulary.properties_OP, properties == null ? null : properties.toJson());
		m.put(Vocabulary.columns_OP, BaseObject.objectListToJson(columns));
		return m;
	}
}