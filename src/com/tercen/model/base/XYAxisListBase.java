package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class XYAxisListBase extends BaseObject {

	public LinkedList<Rectangle> rectangleSelections;
	public LinkedList<XYAxis> xyAxis;

	public XYAxisListBase() {
		super();
		this.rectangleSelections = new LinkedList<Rectangle>();
		this.xyAxis = new LinkedList<XYAxis>();
	}

	public XYAxisListBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.XYAxisList_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static XYAxisList createFromJson(LinkedHashMap m) {
		return XYAxisListBase.fromJson(m);
	}

	public static XYAxisList fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.XYAxisList_CLASS:
			return new XYAxisList(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class XYAxisList in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.XYAxisList_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.XYAxisList_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.rectangleSelections_OP, BaseObject.objectListToJson(rectangleSelections));
		m.put(Vocabulary.xyAxis_OP, BaseObject.objectListToJson(xyAxis));
		return m;
	}
}