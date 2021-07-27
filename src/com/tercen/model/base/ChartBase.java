package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ChartBase extends BaseObject {

	public String name;
	public Properties properties;

	public ChartBase() {
		super();
		this.name = "";
		this.properties = new Properties();
	}

	public ChartBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Chart_CLASS ? m.get(Vocabulary.KIND) : null);
		this.name = (String) m.get(Vocabulary.name_DP);
	}

	public static Chart createFromJson(LinkedHashMap m) {
		return ChartBase.fromJson(m);
	}

	public static Chart fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Chart_CLASS:
			return new Chart(m);
		case Vocabulary.ChartLine_CLASS:
			return new ChartLine(m);
		case Vocabulary.ChartPoint_CLASS:
			return new ChartPoint(m);
		case Vocabulary.ChartHeatmap_CLASS:
			return new ChartHeatmap(m);
		case Vocabulary.ChartBar_CLASS:
			return new ChartBar(m);
		case Vocabulary.ChartSize_CLASS:
			return new ChartSize(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Chart in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Chart_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Chart_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.properties_OP, properties == null ? null : properties.toJson());
		return m;
	}
}