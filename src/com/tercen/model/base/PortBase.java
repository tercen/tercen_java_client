package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PortBase extends IdObject {

	public String linkType;
	public String name;

	public PortBase() {
		super();
		this.linkType = "";
		this.name = "";
	}

	public PortBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Port_CLASS ? m.get(Vocabulary.KIND) : null);
		this.linkType = (String) m.get(Vocabulary.linkType_DP);
		this.name = (String) m.get(Vocabulary.name_DP);
	}

	public static Port createFromJson(LinkedHashMap m) {
		return PortBase.fromJson(m);
	}

	public static Port fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Port_CLASS:
			return new Port(m);
		case Vocabulary.InputPort_CLASS:
			return new InputPort(m);
		case Vocabulary.OutputPort_CLASS:
			return new OutputPort(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Port in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Port_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Port_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.linkType_DP, linkType);
		m.put(Vocabulary.name_DP, name);
		return m;
	}
}