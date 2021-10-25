package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ResourceSummaryBase extends BaseObject {

	public double storage;
	public double usedStorage;
	public double cpuTime;
	public double usedCpuTime;

	public ResourceSummaryBase() {
		super();
		this.storage = 0.0;
		this.usedStorage = 0.0;
		this.cpuTime = 0.0;
		this.usedCpuTime = 0.0;
	}

	public ResourceSummaryBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ResourceSummary_CLASS ? m.get(Vocabulary.KIND) : null);
		this.storage = (double) (m.get(Vocabulary.storage_DP));
		this.usedStorage = (double) (m.get(Vocabulary.usedStorage_DP));
		this.cpuTime = (double) (m.get(Vocabulary.cpuTime_DP));
		this.usedCpuTime = (double) (m.get(Vocabulary.usedCpuTime_DP));
	}

	public static ResourceSummary createFromJson(LinkedHashMap m) {
		return ResourceSummaryBase.fromJson(m);
	}

	public static ResourceSummary fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ResourceSummary_CLASS:
			return new ResourceSummary(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class ResourceSummary in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ResourceSummary_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ResourceSummary_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.storage_DP, storage);
		m.put(Vocabulary.usedStorage_DP, usedStorage);
		m.put(Vocabulary.cpuTime_DP, cpuTime);
		m.put(Vocabulary.usedCpuTime_DP, usedCpuTime);
		return m;
	}
}