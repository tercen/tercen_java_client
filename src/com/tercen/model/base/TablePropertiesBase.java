package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TablePropertiesBase extends BaseObject {

	public String name;
	public ArrayList<String> sortOrder;
	public boolean ascending;

	public TablePropertiesBase() {
		super();
		this.name = "";
		this.sortOrder = new ArrayList<String>();
		this.ascending = true;
	}

	public TablePropertiesBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.TableProperties_CLASS ? m.get(Vocabulary.KIND) : null);
		this.name = (String) m.get(Vocabulary.name_DP);
		this.sortOrder = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.sortOrder_DP)));
		this.ascending = (boolean) m.get(Vocabulary.ascending_DP);
	}

	public static TableProperties createFromJson(LinkedHashMap m) {
		return TablePropertiesBase.fromJson(m);
	}

	public static TableProperties fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.TableProperties_CLASS:
			return new TableProperties(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class TableProperties in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.TableProperties_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.TableProperties_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.sortOrder_DP, sortOrder);
		m.put(Vocabulary.ascending_DP, ascending);
		return m;
	}
}