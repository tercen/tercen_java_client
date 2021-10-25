package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ViesInfoBase extends BaseObject {

	public String countryCode;
	public String vatNumber;
	public String requestDate;
	public boolean valid;
	public String name;
	public String address;

	public ViesInfoBase() {
		super();
		this.countryCode = "";
		this.vatNumber = "";
		this.requestDate = "";
		this.valid = true;
		this.name = "";
		this.address = "";
	}

	public ViesInfoBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.ViesInfo_CLASS ? m.get(Vocabulary.KIND) : null);
		this.countryCode = (String) m.get(Vocabulary.countryCode_DP);
		this.vatNumber = (String) m.get(Vocabulary.vatNumber_DP);
		this.requestDate = (String) m.get(Vocabulary.requestDate_DP);
		this.valid = (boolean) m.get(Vocabulary.valid_DP);
		this.name = (String) m.get(Vocabulary.name_DP);
		this.address = (String) m.get(Vocabulary.address_DP);
	}

	public static ViesInfo createFromJson(LinkedHashMap m) {
		return ViesInfoBase.fromJson(m);
	}

	public static ViesInfo fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.ViesInfo_CLASS:
			return new ViesInfo(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class ViesInfo in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.ViesInfo_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.ViesInfo_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.countryCode_DP, countryCode);
		m.put(Vocabulary.vatNumber_DP, vatNumber);
		m.put(Vocabulary.requestDate_DP, requestDate);
		m.put(Vocabulary.valid_DP, valid);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.address_DP, address);
		return m;
	}
}