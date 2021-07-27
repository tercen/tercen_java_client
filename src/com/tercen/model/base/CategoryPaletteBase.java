package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CategoryPaletteBase extends Palette {

	public ColorList colorList;
	public LinkedList<StringColorElement> stringColorElements;

	public CategoryPaletteBase() {
		super();
		this.colorList = new ColorList();
		this.stringColorElements = new LinkedList<StringColorElement>();
	}

	public CategoryPaletteBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.CategoryPalette_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static CategoryPalette createFromJson(LinkedHashMap m) {
		return CategoryPaletteBase.fromJson(m);
	}

	public static CategoryPalette fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.CategoryPalette_CLASS:
			return new CategoryPalette(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class CategoryPalette in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.CategoryPalette_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.CategoryPalette_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.colorList_OP, colorList == null ? null : colorList.toJson());
		m.put(Vocabulary.stringColorElements_OP, BaseObject.objectListToJson(stringColorElements));
		return m;
	}
}