package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class AclBase extends BaseObject {

	public String owner;
	public ArrayList<Ace> aces;

	public AclBase() {
		super();
		this.owner = "";
		this.aces = new ArrayList<Ace>();
	}

	public AclBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Acl_CLASS ? m.get(Vocabulary.KIND) : null);
		this.owner = (String) m.get(Vocabulary.owner_DP);
		if (m.get(Vocabulary.aces_OP) == null)
			this.aces = new ArrayList<Ace>();
		else {
			this.aces = new ArrayList<Ace>();
			ArrayList list = (ArrayList) m.get(Vocabulary.aces_OP);
			for (Object map : list) {
				this.aces.add(AceBase.createFromJson((LinkedHashMap) map));
			}
		}
	}

	public static Acl createFromJson(LinkedHashMap m) {
		return AclBase.fromJson(m);
	}

	public static Acl fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Acl_CLASS:
			return new Acl(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Acl in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Acl_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Acl_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.owner_DP, owner);
		m.put(Vocabulary.aces_OP, BaseObject.objectListToJson(aces));
		return m;
	}
}