package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CpuTimeProfileBase extends Profile {

	public double cpuTime;

	public CpuTimeProfileBase() {
		super();
		this.cpuTime = 0.0;
	}

	public CpuTimeProfileBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.CpuTimeProfile_CLASS ? m.get(Vocabulary.KIND) : null);
		this.cpuTime = (double) (m.get(Vocabulary.cpuTime_DP));
	}

	public static CpuTimeProfile createFromJson(LinkedHashMap m) {
		return CpuTimeProfileBase.fromJson(m);
	}

	public static CpuTimeProfile fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.CpuTimeProfile_CLASS:
			return new CpuTimeProfile(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class CpuTimeProfile in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.CpuTimeProfile_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.CpuTimeProfile_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.cpuTime_DP, cpuTime);
		return m;
	}
}