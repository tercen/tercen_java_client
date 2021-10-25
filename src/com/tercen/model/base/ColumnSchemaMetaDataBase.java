package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ColumnSchemaMetaDataBase extends BaseObject {

	public ArrayList<String> sort;
	public boolean ascending;
	public ArrayList<String> quartiles;
	public ArrayList<Pair> properties;

	public ColumnSchemaMetaDataBase() {
		super();
		this.sort = new ArrayList<String>();
		this.ascending = true;
		this.quartiles = new ArrayList<String>();
		this.properties = new ArrayList<Pair>();
	}

	public ColumnSchemaMetaDataBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ColumnSchemaMetaData_CLASS ? m.get(Vocabulary.KIND)
						: null);
		if (m.get(Vocabulary.sort_DP) == null)
			this.sort = new ArrayList<String>();
		else
			this.sort = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.sort_DP)));
		this.ascending = (boolean) m.get(Vocabulary.ascending_DP);
		if (m.get(Vocabulary.quartiles_DP) == null)
			this.quartiles = new ArrayList<String>();
		else
			this.quartiles = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.quartiles_DP)));
		if (m.get(Vocabulary.properties_OP) == null)
			this.properties = new ArrayList<Pair>();
		else {
			this.properties = new ArrayList<Pair>();
			ArrayList list = (ArrayList) m.get(Vocabulary.properties_OP);
			for (Object map : list) {
				this.properties.add(PairBase.createFromJson((LinkedHashMap) map));
			}
		}
	}

	public static ColumnSchemaMetaData createFromJson(LinkedHashMap m) {
		return ColumnSchemaMetaDataBase.fromJson(m);
	}

	public static ColumnSchemaMetaData fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ColumnSchemaMetaData_CLASS:
			return new ColumnSchemaMetaData(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class ColumnSchemaMetaData in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ColumnSchemaMetaData_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ColumnSchemaMetaData_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.sort_DP, sort);
		m.put(Vocabulary.ascending_DP, ascending);
		m.put(Vocabulary.quartiles_DP, quartiles);
		m.put(Vocabulary.properties_OP, BaseObject.objectListToJson(properties));
		return m;
	}
}