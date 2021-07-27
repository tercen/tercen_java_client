package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PlanBase extends BaseObject {

	public String name;
	public String displayName;
	public String paymentProviderPlanId;
	public LinkedList<String> descriptions;
	public double price;

	public PlanBase() {
		super();
		this.name = "";
		this.displayName = "";
		this.paymentProviderPlanId = "";
		this.descriptions = new LinkedList<String>();
		this.price = 0.0;
	}

	public PlanBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Plan_CLASS ? m.get(Vocabulary.KIND) : null);
		this.name = (String) m.get(Vocabulary.name_DP);
		this.displayName = (String) m.get(Vocabulary.displayName_DP);
		this.paymentProviderPlanId = (String) m.get(Vocabulary.paymentProviderPlanId_DP);
		this.descriptions = new LinkedList<String>((Collection<? extends String>) (m.get(Vocabulary.descriptions_DP)));
		this.price = (double) (m.get(Vocabulary.price_DP));
	}

	public static Plan createFromJson(LinkedHashMap m) {
		return PlanBase.fromJson(m);
	}

	public static Plan fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Plan_CLASS:
			return new Plan(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Plan in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Plan_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Plan_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.displayName_DP, displayName);
		m.put(Vocabulary.paymentProviderPlanId_DP, paymentProviderPlanId);
		m.put(Vocabulary.descriptions_DP, descriptions);
		m.put(Vocabulary.price_DP, price);
		return m;
	}
}