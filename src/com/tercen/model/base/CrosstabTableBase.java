package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CrosstabTableBase extends BaseObject {

	public double cellSize;
	public int offset;
	public LinkedList<GraphicalFactor> graphicalFactors;
	public LinkedList<Rectangle> rectangleSelections;

	public CrosstabTableBase() {
		super();
		this.cellSize = 0.0;
		this.offset = 0;
		this.graphicalFactors = new LinkedList<GraphicalFactor>();
		this.rectangleSelections = new LinkedList<Rectangle>();
	}

	public CrosstabTableBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.CrosstabTable_CLASS ? m.get(Vocabulary.KIND) : null);
		this.cellSize = (double) (m.get(Vocabulary.cellSize_DP));
		this.offset = (int) m.get(Vocabulary.offset_DP);
	}

	public static CrosstabTable createFromJson(LinkedHashMap m) {
		return CrosstabTableBase.fromJson(m);
	}

	public static CrosstabTable fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.CrosstabTable_CLASS:
			return new CrosstabTable(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class CrosstabTable in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.CrosstabTable_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.CrosstabTable_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.cellSize_DP, cellSize);
		m.put(Vocabulary.offset_DP, offset);
		m.put(Vocabulary.graphicalFactors_OP, BaseObject.objectListToJson(graphicalFactors));
		m.put(Vocabulary.rectangleSelections_OP, BaseObject.objectListToJson(rectangleSelections));
		return m;
	}
}