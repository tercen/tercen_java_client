package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class OperatorBase extends Document {

	public LinkedList<Property> properties;
	public String longDescription;

	public OperatorBase() {
		super();
		this.longDescription = "";
		this.properties = new LinkedList<Property>();
	}

	public OperatorBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Operator_CLASS ? m.get(Vocabulary.KIND) : null);
		this.longDescription = (String) m.get(Vocabulary.longDescription_DP);
	}

	public static Operator createFromJson(LinkedHashMap m) {
		return OperatorBase.fromJson(m);
	}

	public static Operator fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Operator_CLASS:
			return new Operator(m);
		case Vocabulary.ShinyOperator_CLASS:
			return new ShinyOperator(m);
		case Vocabulary.DockerWebAppOperator_CLASS:
			return new DockerWebAppOperator(m);
		case Vocabulary.DockerOperator_CLASS:
			return new DockerOperator(m);
		case Vocabulary.ROperator_CLASS:
			return new ROperator(m);
		case Vocabulary.WebAppOperator_CLASS:
			return new WebAppOperator(m);
		case Vocabulary.GitOperator_CLASS:
			return new GitOperator(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Operator in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Operator_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Operator_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.properties_OP, BaseObject.objectListToJson(properties));
		m.put(Vocabulary.longDescription_DP, longDescription);
		return m;
	}
}