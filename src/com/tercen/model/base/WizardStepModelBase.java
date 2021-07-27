package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class WizardStepModelBase extends StepModel {

	public String namespace;
	public String description;
	public LinkedList<MappingFactor> factors;
	public LinkedList<MappingFilter> filters;
	public LinkedList<Step> steps;

	public WizardStepModelBase() {
		super();
		this.namespace = "";
		this.description = "";
		this.factors = new LinkedList<MappingFactor>();
		this.filters = new LinkedList<MappingFilter>();
		this.steps = new LinkedList<Step>();
	}

	public WizardStepModelBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.WizardStepModel_CLASS ? m.get(Vocabulary.KIND) : null);
		this.namespace = (String) m.get(Vocabulary.namespace_DP);
		this.description = (String) m.get(Vocabulary.description_DP);
	}

	public static WizardStepModel createFromJson(LinkedHashMap m) {
		return WizardStepModelBase.fromJson(m);
	}

	public static WizardStepModel fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.WizardStepModel_CLASS:
			return new WizardStepModel(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class WizardStepModel in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.WizardStepModel_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.WizardStepModel_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.namespace_DP, namespace);
		m.put(Vocabulary.description_DP, description);
		m.put(Vocabulary.factors_OP, BaseObject.objectListToJson(factors));
		m.put(Vocabulary.filters_OP, BaseObject.objectListToJson(filters));
		m.put(Vocabulary.steps_OP, BaseObject.objectListToJson(steps));
		return m;
	}
}