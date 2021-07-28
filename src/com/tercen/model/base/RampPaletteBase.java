package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RampPaletteBase extends Palette {

	public boolean isUserDefined;
	public ArrayList<DoubleColorElement> doubleColorElements;

	public RampPaletteBase() {
		super();
		this.isUserDefined = true;
		this.doubleColorElements = new ArrayList<DoubleColorElement>();
	}

	public RampPaletteBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.RampPalette_CLASS ? m.get(Vocabulary.KIND) : null);
		this.isUserDefined = (boolean) m.get(Vocabulary.isUserDefined_DP);
		if (m.get(Vocabulary.doubleColorElements_OP) == null)
			this.doubleColorElements = new ArrayList<DoubleColorElement>();
		else {
			ArrayList obj_list = new ArrayList();
			ArrayList list = (ArrayList) m.get(Vocabulary.doubleColorElements_OP);
			for (Object map : list) {
				obj_list.add(DoubleColorElementBase.createFromJson((LinkedHashMap) map));
			}
		}
	}

	public static RampPalette createFromJson(LinkedHashMap m) {
		return RampPaletteBase.fromJson(m);
	}

	public static RampPalette fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.RampPalette_CLASS:
			return new RampPalette(m);
		case Vocabulary.JetPalette_CLASS:
			return new JetPalette(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class RampPalette in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.RampPalette_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.RampPalette_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.isUserDefined_DP, isUserDefined);
		m.put(Vocabulary.doubleColorElements_OP, BaseObject.objectListToJson(doubleColorElements));
		return m;
	}
}