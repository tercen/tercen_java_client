package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TableProfileBase extends Profile {

	public int nRows;
	public int nCols;

	public TableProfileBase() {
		super();
		this.nRows = 0;
		this.nCols = 0;
	}

	public TableProfileBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.TableProfile_CLASS ? m.get(Vocabulary.KIND) : null);
		this.nRows = (int) m.get(Vocabulary.nRows_DP);
		this.nCols = (int) m.get(Vocabulary.nCols_DP);
	}

	public static TableProfile createFromJson(LinkedHashMap m) {
		return TableProfileBase.fromJson(m);
	}

	public static TableProfile fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.TableProfile_CLASS:
			return new TableProfile(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class TableProfile in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.TableProfile_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.TableProfile_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.nRows_DP, nRows);
		m.put(Vocabulary.nCols_DP, nCols);
		return m;
	}
}