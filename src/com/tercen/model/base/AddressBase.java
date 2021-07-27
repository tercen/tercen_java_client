package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class AddressBase extends BaseObject {

	public String country;
	public String state;
	public String city;
	public String zipCode;
	public String address1;
	public String address2;
	public String phone;

	public AddressBase() {
		super();
		this.country = "";
		this.state = "";
		this.city = "";
		this.zipCode = "";
		this.address1 = "";
		this.address2 = "";
		this.phone = "";
	}

	public AddressBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Address_CLASS ? m.get(Vocabulary.KIND) : null);
		this.country = (String) m.get(Vocabulary.country_DP);
		this.state = (String) m.get(Vocabulary.state_DP);
		this.city = (String) m.get(Vocabulary.city_DP);
		this.zipCode = (String) m.get(Vocabulary.zipCode_DP);
		this.address1 = (String) m.get(Vocabulary.address1_DP);
		this.address2 = (String) m.get(Vocabulary.address2_DP);
		this.phone = (String) m.get(Vocabulary.phone_DP);
	}

	public static Address createFromJson(LinkedHashMap m) {
		return AddressBase.fromJson(m);
	}

	public static Address fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Address_CLASS:
			return new Address(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Address in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Address_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Address_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.country_DP, country);
		m.put(Vocabulary.state_DP, state);
		m.put(Vocabulary.city_DP, city);
		m.put(Vocabulary.zipCode_DP, zipCode);
		m.put(Vocabulary.address1_DP, address1);
		m.put(Vocabulary.address2_DP, address2);
		m.put(Vocabulary.phone_DP, phone);
		return m;
	}
}