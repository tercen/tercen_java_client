package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class JoinStepModelBase extends StepModel {

	public LinkedList<Factor> leftFactors;
	public LinkedList<Factor> rightFactors;
	public String rightPrefix;

	public JoinStepModelBase() {
		super();
		this.rightPrefix = "";
		this.leftFactors = new LinkedList<Factor>();
		this.rightFactors = new LinkedList<Factor>();
	}

	public JoinStepModelBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.JoinStepModel_CLASS ? m.get(Vocabulary.KIND) : null);
		this.rightPrefix = (String) m.get(Vocabulary.rightPrefix_DP);
	}

	public static JoinStepModel createFromJson(LinkedHashMap m) {
		return JoinStepModelBase.fromJson(m);
	}

	public static JoinStepModel fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.JoinStepModel_CLASS:
			return new JoinStepModel(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class JoinStepModel in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.JoinStepModel_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.JoinStepModel_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.leftFactors_OP, BaseObject.objectListToJson(leftFactors));
		m.put(Vocabulary.rightFactors_OP, BaseObject.objectListToJson(rightFactors));
		m.put(Vocabulary.rightPrefix_DP, rightPrefix);
		return m;
	}
}