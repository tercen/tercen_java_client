package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class AxisBase extends BaseObject {

	public Point axisExtent;
	public AxisSettings axisSettings;
	public GraphicalFactor graphicalFactor;

	public AxisBase() {
		super();
		this.axisExtent = new Point();
		this.axisSettings = new AxisSettings();
		this.graphicalFactor = new GraphicalFactor();
	}

	public AxisBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Axis_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static Axis createFromJson(LinkedHashMap m) {
		return AxisBase.fromJson(m);
	}

	public static Axis fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Axis_CLASS:
			return new Axis(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Axis in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Axis_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Axis_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.axisExtent_OP, axisExtent == null ? null : axisExtent.toJson());
		m.put(Vocabulary.axisSettings_OP, axisSettings == null ? null : axisSettings.toJson());
		m.put(Vocabulary.graphicalFactor_OP, graphicalFactor == null ? null : graphicalFactor.toJson());
		return m;
	}
}