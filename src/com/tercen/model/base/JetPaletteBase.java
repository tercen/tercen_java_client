package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class JetPaletteBase extends RampPalette {

	public JetPaletteBase() {
		super();
	}

	public JetPaletteBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.JetPalette_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static JetPalette createFromJson(LinkedHashMap m) {
		return JetPaletteBase.fromJson(m);
	}

	public static JetPalette fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.JetPalette_CLASS:
			return new JetPalette(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class JetPalette in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.JetPalette_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.JetPalette_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}