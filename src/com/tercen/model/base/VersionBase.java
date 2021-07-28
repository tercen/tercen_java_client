package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class VersionBase extends BaseObject {

	public int major;
	public int minor;
	public int patch;
	public String tag;
	public String date;
	public String commit;

	public VersionBase() {
		super();
		this.major = 0;
		this.minor = 0;
		this.patch = 0;
		this.tag = "";
		this.date = "";
		this.commit = "";
	}

	public VersionBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Version_CLASS ? m.get(Vocabulary.KIND) : null);
		this.major = (int) m.get(Vocabulary.major_DP);
		this.minor = (int) m.get(Vocabulary.minor_DP);
		this.patch = (int) m.get(Vocabulary.patch_DP);
		this.tag = (String) m.get(Vocabulary.tag_DP);
		this.date = (String) m.get(Vocabulary.date_DP);
		this.commit = (String) m.get(Vocabulary.commit_DP);
	}

	public static Version createFromJson(LinkedHashMap m) {
		return VersionBase.fromJson(m);
	}

	public static Version fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Version_CLASS:
			return new Version(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Version in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Version_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Version_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.major_DP, major);
		m.put(Vocabulary.minor_DP, minor);
		m.put(Vocabulary.patch_DP, patch);
		m.put(Vocabulary.tag_DP, tag);
		m.put(Vocabulary.date_DP, date);
		m.put(Vocabulary.commit_DP, commit);
		return m;
	}
}