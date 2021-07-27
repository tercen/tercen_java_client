package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ColorsBase extends BaseObject {

	public LinkedList<Factor> factors;
	public Palette palette;

	public ColorsBase() {
		super();
		this.factors = new LinkedList<Factor>();
		this.palette = new Palette();
	}

	public ColorsBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Colors_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static Colors createFromJson(LinkedHashMap m) {
		return ColorsBase.fromJson(m);
	}

	public static Colors fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Colors_CLASS:
			return new Colors(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Colors in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Colors_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Colors_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.factors_OP, BaseObject.objectListToJson(factors));
		m.put(Vocabulary.palette_OP, palette == null ? null : palette.toJson());
		return m;
	}
}