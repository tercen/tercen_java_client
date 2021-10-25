package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ColorListBase extends BaseObject {

	public String name;

	public ColorListBase() {
		super();
		this.name = "";
	}

	public ColorListBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ColorList_CLASS ? m.get(Vocabulary.KIND) : null);
		this.name = (String) m.get(Vocabulary.name_DP);
	}

	public static ColorList createFromJson(LinkedHashMap m) {
		return ColorListBase.fromJson(m);
	}

	public static ColorList fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ColorList_CLASS:
			return new ColorList(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class ColorList in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ColorList_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ColorList_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		return m;
	}
}