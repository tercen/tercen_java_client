package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class WizardStepModelBase extends StepModel {

	public String namespace;
	public String description;
	public ArrayList<MappingFactor> factors;
	public ArrayList<MappingFilter> filters;
	public ArrayList<Step> steps;
	public ArrayList<MappingFactor> defaultFactors;
	public ArrayList<MappingFilter> defaultFilters;

	public WizardStepModelBase() {
		super();
		this.namespace = "";
		this.description = "";
		this.factors = new ArrayList<MappingFactor>();
		this.filters = new ArrayList<MappingFilter>();
		this.steps = new ArrayList<Step>();
		this.defaultFactors = new ArrayList<MappingFactor>();
		this.defaultFilters = new ArrayList<MappingFilter>();
	}

	public WizardStepModelBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.WizardStepModel_CLASS ? m.get(Vocabulary.KIND) : null);
		this.namespace = (String) m.get(Vocabulary.namespace_DP);
		this.description = (String) m.get(Vocabulary.description_DP);
		if (m.get(Vocabulary.factors_OP) == null)
			this.factors = new ArrayList<MappingFactor>();
		else {
			this.factors = new ArrayList<MappingFactor>();
			ArrayList list = (ArrayList) m.get(Vocabulary.factors_OP);
			for (Object map : list) {
				this.factors.add(MappingFactorBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.filters_OP) == null)
			this.filters = new ArrayList<MappingFilter>();
		else {
			this.filters = new ArrayList<MappingFilter>();
			ArrayList list = (ArrayList) m.get(Vocabulary.filters_OP);
			for (Object map : list) {
				this.filters.add(MappingFilterBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.steps_OP) == null)
			this.steps = new ArrayList<Step>();
		else {
			this.steps = new ArrayList<Step>();
			ArrayList list = (ArrayList) m.get(Vocabulary.steps_OP);
			for (Object map : list) {
				this.steps.add(StepBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.defaultFactors_OP) == null)
			this.defaultFactors = new ArrayList<MappingFactor>();
		else {
			this.defaultFactors = new ArrayList<MappingFactor>();
			ArrayList list = (ArrayList) m.get(Vocabulary.defaultFactors_OP);
			for (Object map : list) {
				this.defaultFactors.add(MappingFactorBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.defaultFilters_OP) == null)
			this.defaultFilters = new ArrayList<MappingFilter>();
		else {
			this.defaultFilters = new ArrayList<MappingFilter>();
			ArrayList list = (ArrayList) m.get(Vocabulary.defaultFilters_OP);
			for (Object map : list) {
				this.defaultFilters.add(MappingFilterBase.createFromJson((LinkedHashMap) map));
			}
		}
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
		m.put(Vocabulary.defaultFactors_OP, BaseObject.objectListToJson(defaultFactors));
		m.put(Vocabulary.defaultFilters_OP, BaseObject.objectListToJson(defaultFilters));
		return m;
	}
}