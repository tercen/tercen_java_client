package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PaletteBase extends BaseObject {

	public int backcolor;
	public LinkedList<PropertyValue> properties;

	public PaletteBase() {
		super();
		this.backcolor = 0;
		this.properties = new LinkedList<PropertyValue>();
	}

	public PaletteBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Palette_CLASS ? m.get(Vocabulary.KIND) : null);
		this.backcolor = (int) m.get(Vocabulary.backcolor_DP);
	}

	public static Palette createFromJson(LinkedHashMap m) {
		return PaletteBase.fromJson(m);
	}

	public static Palette fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Palette_CLASS:
			return new Palette(m);
		case Vocabulary.JetPalette_CLASS:
			return new JetPalette(m);
		case Vocabulary.RampPalette_CLASS:
			return new RampPalette(m);
		case Vocabulary.CategoryPalette_CLASS:
			return new CategoryPalette(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Palette in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Palette_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Palette_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.backcolor_DP, backcolor);
		m.put(Vocabulary.properties_OP, BaseObject.objectListToJson(properties));
		return m;
	}
}