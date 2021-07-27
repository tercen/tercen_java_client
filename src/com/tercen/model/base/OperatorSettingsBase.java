package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class OperatorSettingsBase extends BaseObject {

	public String namespace;
	public OperatorRef operatorRef;
	public LinkedList<Pair> environment;

	public OperatorSettingsBase() {
		super();
		this.namespace = "";
		this.operatorRef = new OperatorRef();
		this.environment = new LinkedList<Pair>();
	}

	public OperatorSettingsBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.OperatorSettings_CLASS ? m.get(Vocabulary.KIND)
						: null);
		this.namespace = (String) m.get(Vocabulary.namespace_DP);
	}

	public static OperatorSettings createFromJson(LinkedHashMap m) {
		return OperatorSettingsBase.fromJson(m);
	}

	public static OperatorSettings fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.OperatorSettings_CLASS:
			return new OperatorSettings(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class OperatorSettings in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.OperatorSettings_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.OperatorSettings_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.namespace_DP, namespace);
		m.put(Vocabulary.operatorRef_OP, operatorRef == null ? null : operatorRef.toJson());
		m.put(Vocabulary.environment_OP, BaseObject.objectListToJson(environment));
		return m;
	}
}