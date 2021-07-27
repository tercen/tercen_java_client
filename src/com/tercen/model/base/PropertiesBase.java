package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PropertiesBase extends BaseObject {

	public LinkedList<Property> properties;
	public LinkedList<PropertyValue> propertyValues;

	public PropertiesBase() {
		super();
		this.properties = new LinkedList<Property>();
		this.propertyValues = new LinkedList<PropertyValue>();
	}

	public PropertiesBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Properties_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static Properties createFromJson(LinkedHashMap m) {
		return PropertiesBase.fromJson(m);
	}

	public static Properties fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Properties_CLASS:
			return new Properties(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Properties in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Properties_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Properties_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.properties_OP, BaseObject.objectListToJson(properties));
		m.put(Vocabulary.propertyValues_OP, BaseObject.objectListToJson(propertyValues));
		return m;
	}
}