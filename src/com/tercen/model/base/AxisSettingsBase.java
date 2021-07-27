package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class AxisSettingsBase extends BaseObject {

	public LinkedList<Property> properties;
	public LinkedList<PropertyValue> propertyValues;

	public AxisSettingsBase() {
		super();
		this.properties = new LinkedList<Property>();
		this.propertyValues = new LinkedList<PropertyValue>();
	}

	public AxisSettingsBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.AxisSettings_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static AxisSettings createFromJson(LinkedHashMap m) {
		return AxisSettingsBase.fromJson(m);
	}

	public static AxisSettings fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.AxisSettings_CLASS:
			return new AxisSettings(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class AxisSettings in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.AxisSettings_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.AxisSettings_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.properties_OP, BaseObject.objectListToJson(properties));
		m.put(Vocabulary.propertyValues_OP, BaseObject.objectListToJson(propertyValues));
		return m;
	}
}