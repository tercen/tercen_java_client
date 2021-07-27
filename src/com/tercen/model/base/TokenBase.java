package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TokenBase extends BaseObject {

	public String userId;
	public Date expiry;
	public String token;

	public TokenBase() {
		super();
		this.userId = "";
		this.token = "";
		this.expiry = new Date();
	}

	public TokenBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Token_CLASS ? m.get(Vocabulary.KIND) : null);
		this.userId = (String) m.get(Vocabulary.userId_DP);
		this.token = (String) m.get(Vocabulary.token_DP);
	}

	public static Token createFromJson(LinkedHashMap m) {
		return TokenBase.fromJson(m);
	}

	public static Token fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Token_CLASS:
			return new Token(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Token in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Token_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Token_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.userId_DP, userId);
		m.put(Vocabulary.expiry_OP, expiry == null ? null : expiry.toJson());
		m.put(Vocabulary.token_DP, token);
		return m;
	}
}