package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class SearchResultBase extends BaseObject {

	public int total_rows;
	public String bookmark;
	public ArrayList<PersistentObject> rows;

	public SearchResultBase() {
		super();
		this.total_rows = 0;
		this.bookmark = "";
		this.rows = new ArrayList<PersistentObject>();
	}

	public SearchResultBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.SearchResult_CLASS ? m.get(Vocabulary.KIND) : null);
		this.total_rows = (int) m.get(Vocabulary.total_rows_DP);
		this.bookmark = (String) m.get(Vocabulary.bookmark_DP);
		if (m.get(Vocabulary.rows_OP) == null)
			this.rows = new ArrayList<PersistentObject>();
		else {
			this.rows = new ArrayList<PersistentObject>();
			ArrayList list = (ArrayList) m.get(Vocabulary.rows_OP);
			for (Object map : list) {
				this.rows.add(PersistentObjectBase.createFromJson((LinkedHashMap) map));
			}
		}
	}

	public static SearchResult createFromJson(LinkedHashMap m) {
		return SearchResultBase.fromJson(m);
	}

	public static SearchResult fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.SearchResult_CLASS:
			return new SearchResult(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class SearchResult in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.SearchResult_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.SearchResult_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.total_rows_DP, total_rows);
		m.put(Vocabulary.bookmark_DP, bookmark);
		m.put(Vocabulary.rows_OP, BaseObject.objectListToJson(rows));
		return m;
	}
}