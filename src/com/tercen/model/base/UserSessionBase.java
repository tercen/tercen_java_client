package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class UserSessionBase extends BaseObject {

	public Version serverVersion;
	public User user;
	public Token token;

	public UserSessionBase() {
		super();
		this.serverVersion = new Version();
		this.user = new User();
		this.token = new Token();
	}

	public UserSessionBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.UserSession_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static UserSession createFromJson(LinkedHashMap m) {
		return UserSessionBase.fromJson(m);
	}

	public static UserSession fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.UserSession_CLASS:
			return new UserSession(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class UserSession in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.UserSession_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.UserSession_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.serverVersion_OP, serverVersion == null ? null : serverVersion.toJson());
		m.put(Vocabulary.user_OP, user == null ? null : user.toJson());
		m.put(Vocabulary.token_OP, token == null ? null : token.toJson());
		return m;
	}
}