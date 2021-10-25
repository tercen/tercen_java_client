package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ColumnPairBase extends BaseObject {

	public ArrayList<String> lColumns;
	public ArrayList<String> rColumns;

	public ColumnPairBase() {
		super();
		this.lColumns = new ArrayList<String>();
		this.rColumns = new ArrayList<String>();
	}

	public ColumnPairBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ColumnPair_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.lColumns_DP) == null)
			this.lColumns = new ArrayList<String>();
		else
			this.lColumns = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.lColumns_DP)));
		if (m.get(Vocabulary.rColumns_DP) == null)
			this.rColumns = new ArrayList<String>();
		else
			this.rColumns = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.rColumns_DP)));
	}

	public static ColumnPair createFromJson(LinkedHashMap m) {
		return ColumnPairBase.fromJson(m);
	}

	public static ColumnPair fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ColumnPair_CLASS:
			return new ColumnPair(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class ColumnPair in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ColumnPair_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ColumnPair_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.lColumns_DP, lColumns);
		m.put(Vocabulary.rColumns_DP, rColumns);
		return m;
	}
}