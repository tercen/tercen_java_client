package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RLibraryBase extends Document {

	public RDescription rDescription;

	public RLibraryBase() {
		super();
		this.rDescription = new RDescription();
	}

	public RLibraryBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.RLibrary_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.rDescription_OP) == null)
			this.rDescription = new RDescription();
		else
			this.rDescription = RDescriptionBase.fromJson((LinkedHashMap) m.get(Vocabulary.rDescription_OP));
	}

	public static RLibrary createFromJson(LinkedHashMap m) {
		return RLibraryBase.fromJson(m);
	}

	public static RLibrary fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.RLibrary_CLASS:
			return new RLibrary(m);
		case Vocabulary.RSourceLibrary_CLASS:
			return new RSourceLibrary(m);
		case Vocabulary.RenvInstalledLibrary_CLASS:
			return new RenvInstalledLibrary(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class RLibrary in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.RLibrary_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.RLibrary_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.rDescription_OP, rDescription == null ? null : rDescription.toJson());
		return m;
	}
}