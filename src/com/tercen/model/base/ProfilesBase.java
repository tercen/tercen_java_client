package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ProfilesBase extends BaseObject {

	public ApiCallProfile apiProfile;
	public TableProfile tableProfile;
	public CpuTimeProfile cpuTimeProfile;
	public StorageProfile storageProfile;
	public RunProfile runProfile;

	public ProfilesBase() {
		super();
		this.apiProfile = new ApiCallProfile();
		this.tableProfile = new TableProfile();
		this.cpuTimeProfile = new CpuTimeProfile();
		this.storageProfile = new StorageProfile();
		this.runProfile = new RunProfile();
	}

	public ProfilesBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Profiles_CLASS ? m.get(Vocabulary.KIND) : null);
		if (m.get(Vocabulary.apiProfile_OP) == null)
			this.apiProfile = new ApiCallProfile();
		else
			this.apiProfile = ApiCallProfileBase.fromJson((LinkedHashMap) m.get(Vocabulary.apiProfile_OP));
		if (m.get(Vocabulary.tableProfile_OP) == null)
			this.tableProfile = new TableProfile();
		else
			this.tableProfile = TableProfileBase.fromJson((LinkedHashMap) m.get(Vocabulary.tableProfile_OP));
		if (m.get(Vocabulary.cpuTimeProfile_OP) == null)
			this.cpuTimeProfile = new CpuTimeProfile();
		else
			this.cpuTimeProfile = CpuTimeProfileBase.fromJson((LinkedHashMap) m.get(Vocabulary.cpuTimeProfile_OP));
		if (m.get(Vocabulary.storageProfile_OP) == null)
			this.storageProfile = new StorageProfile();
		else
			this.storageProfile = StorageProfileBase.fromJson((LinkedHashMap) m.get(Vocabulary.storageProfile_OP));
		if (m.get(Vocabulary.runProfile_OP) == null)
			this.runProfile = new RunProfile();
		else
			this.runProfile = RunProfileBase.fromJson((LinkedHashMap) m.get(Vocabulary.runProfile_OP));
	}

	public static Profiles createFromJson(LinkedHashMap m) {
		return ProfilesBase.fromJson(m);
	}

	public static Profiles fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Profiles_CLASS:
			return new Profiles(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Profiles in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Profiles_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Profiles_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.apiProfile_OP, apiProfile == null ? null : apiProfile.toJson());
		m.put(Vocabulary.tableProfile_OP, tableProfile == null ? null : tableProfile.toJson());
		m.put(Vocabulary.cpuTimeProfile_OP, cpuTimeProfile == null ? null : cpuTimeProfile.toJson());
		m.put(Vocabulary.storageProfile_OP, storageProfile == null ? null : storageProfile.toJson());
		m.put(Vocabulary.runProfile_OP, runProfile == null ? null : runProfile.toJson());
		return m;
	}
}