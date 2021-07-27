package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class OperatorRefBase extends BaseObject {

	public String name;
	public String version;
	public String operatorId;
	public String operatorKind;
	public LinkedList<PropertyValue> propertyValues;
	public Url url;

	public OperatorRefBase() {
		super();
		this.name = "";
		this.version = "";
		this.operatorId = "";
		this.operatorKind = "";
		this.propertyValues = new LinkedList<PropertyValue>();
		this.url = new Url();
	}

	public OperatorRefBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.OperatorRef_CLASS ? m.get(Vocabulary.KIND) : null);
		this.name = (String) m.get(Vocabulary.name_DP);
		this.version = (String) m.get(Vocabulary.version_DP);
		this.operatorId = (String) m.get(Vocabulary.operatorId_DP);
		this.operatorKind = (String) m.get(Vocabulary.operatorKind_DP);
	}

	public static OperatorRef createFromJson(LinkedHashMap m) {
		return OperatorRefBase.fromJson(m);
	}

	public static OperatorRef fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.OperatorRef_CLASS:
			return new OperatorRef(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class OperatorRef in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.OperatorRef_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.OperatorRef_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.version_DP, version);
		m.put(Vocabulary.operatorId_DP, operatorId);
		m.put(Vocabulary.operatorKind_DP, operatorKind);
		m.put(Vocabulary.propertyValues_OP, BaseObject.objectListToJson(propertyValues));
		m.put(Vocabulary.url_OP, url == null ? null : url.toJson());
		return m;
	}
}