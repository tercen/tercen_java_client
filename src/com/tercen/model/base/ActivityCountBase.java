package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ActivityCountBase extends BaseObject {

	public String objectId;
	public int count;

	public ActivityCountBase() {
		super();
		this.objectId = "";
		this.count = 0;
	}

	public ActivityCountBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ActivityCount_CLASS ? m.get(Vocabulary.KIND) : null);
		this.objectId = (String) m.get(Vocabulary.objectId_DP);
		this.count = (int) m.get(Vocabulary.count_DP);
	}

	public static ActivityCount createFromJson(LinkedHashMap m) {
		return ActivityCountBase.fromJson(m);
	}

	public static ActivityCount fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ActivityCount_CLASS:
			return new ActivityCount(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class ActivityCount in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ActivityCount_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ActivityCount_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.objectId_DP, objectId);
		m.put(Vocabulary.count_DP, count);
		return m;
	}
}