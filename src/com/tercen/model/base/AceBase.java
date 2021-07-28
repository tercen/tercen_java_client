package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class AceBase extends BaseObject {

	public ArrayList<Principal> principals;
	public ArrayList<Privilege> privileges;

	public AceBase() {
		super();
		this.principals = new ArrayList<Principal>();
		this.privileges = new ArrayList<Privilege>();
	}

	public AceBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Ace_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.principals_OP) == null)
			this.principals = new ArrayList<Principal>();
		else {
			ArrayList obj_list = new ArrayList();
			ArrayList list = (ArrayList) m.get(Vocabulary.principals_OP);
			for (Object map : list) {
				obj_list.add(PrincipalBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.privileges_OP) == null)
			this.privileges = new ArrayList<Privilege>();
		else {
			ArrayList obj_list = new ArrayList();
			ArrayList list = (ArrayList) m.get(Vocabulary.privileges_OP);
			for (Object map : list) {
				obj_list.add(PrivilegeBase.createFromJson((LinkedHashMap) map));
			}
		}
	}

	public static Ace createFromJson(LinkedHashMap m) {
		return AceBase.fromJson(m);
	}

	public static Ace fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Ace_CLASS:
			return new Ace(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Ace in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Ace_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Ace_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.principals_OP, BaseObject.objectListToJson(principals));
		m.put(Vocabulary.privileges_OP, BaseObject.objectListToJson(privileges));
		return m;
	}
}