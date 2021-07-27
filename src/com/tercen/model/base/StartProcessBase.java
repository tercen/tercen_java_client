package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class StartProcessBase extends IdObject {

	public String executable;
	public LinkedList<String> arguments;
	public Ulimits ulimits;
	public int timeout;
	public int pid;
	public String script;

	public StartProcessBase() {
		super();
		this.executable = "";
		this.arguments = new LinkedList<String>();
		this.timeout = 0;
		this.pid = 0;
		this.script = "";
		this.ulimits = new Ulimits();
	}

	public StartProcessBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.StartProcess_CLASS ? m.get(Vocabulary.KIND) : null);
		this.executable = (String) m.get(Vocabulary.executable_DP);
		this.arguments = new LinkedList<String>((Collection<? extends String>) (m.get(Vocabulary.arguments_DP)));
		this.timeout = (int) m.get(Vocabulary.timeout_DP);
		this.pid = (int) m.get(Vocabulary.pid_DP);
		this.script = (String) m.get(Vocabulary.script_DP);
	}

	public static StartProcess createFromJson(LinkedHashMap m) {
		return StartProcessBase.fromJson(m);
	}

	public static StartProcess fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.StartProcess_CLASS:
			return new StartProcess(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class StartProcess in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.StartProcess_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.StartProcess_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.executable_DP, executable);
		m.put(Vocabulary.arguments_DP, arguments);
		m.put(Vocabulary.ulimits_OP, ulimits == null ? null : ulimits.toJson());
		m.put(Vocabulary.timeout_DP, timeout);
		m.put(Vocabulary.pid_DP, pid);
		m.put(Vocabulary.script_DP, script);
		return m;
	}
}