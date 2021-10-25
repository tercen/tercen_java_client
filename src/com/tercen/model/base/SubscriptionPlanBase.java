package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class SubscriptionPlanBase extends Document {

	public String providerKey;
	public String paymentProviderPlanId;
	public String checkoutSessionId;
	public String subscriptionId;
	public String status;
	public String paymentMethodStatus;
	public String ip;

	public SubscriptionPlanBase() {
		super();
		this.providerKey = "";
		this.paymentProviderPlanId = "";
		this.checkoutSessionId = "";
		this.subscriptionId = "";
		this.status = "";
		this.paymentMethodStatus = "";
		this.ip = "";
	}

	public SubscriptionPlanBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.SubscriptionPlan_CLASS ? m.get(Vocabulary.KIND)
						: null);
		this.providerKey = (String) m.get(Vocabulary.providerKey_DP);
		this.paymentProviderPlanId = (String) m.get(Vocabulary.paymentProviderPlanId_DP);
		this.checkoutSessionId = (String) m.get(Vocabulary.checkoutSessionId_DP);
		this.subscriptionId = (String) m.get(Vocabulary.subscriptionId_DP);
		this.status = (String) m.get(Vocabulary.status_DP);
		this.paymentMethodStatus = (String) m.get(Vocabulary.paymentMethodStatus_DP);
		this.ip = (String) m.get(Vocabulary.ip_DP);
	}

	public static SubscriptionPlan createFromJson(LinkedHashMap m) {
		return SubscriptionPlanBase.fromJson(m);
	}

	public static SubscriptionPlan fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.SubscriptionPlan_CLASS:
			return new SubscriptionPlan(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class SubscriptionPlan in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.SubscriptionPlan_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.SubscriptionPlan_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.providerKey_DP, providerKey);
		m.put(Vocabulary.paymentProviderPlanId_DP, paymentProviderPlanId);
		m.put(Vocabulary.checkoutSessionId_DP, checkoutSessionId);
		m.put(Vocabulary.subscriptionId_DP, subscriptionId);
		m.put(Vocabulary.status_DP, status);
		m.put(Vocabulary.paymentMethodStatus_DP, paymentMethodStatus);
		m.put(Vocabulary.ip_DP, ip);
		return m;
	}
}