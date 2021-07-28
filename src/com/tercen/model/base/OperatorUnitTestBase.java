package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class OperatorUnitTestBase extends BaseObject {

	public String name;
	public String namespace;
	public String inputDataUri;
	public ArrayList<String> outputDataUri;
	public ArrayList<String> columns;
	public ArrayList<String> rows;
	public ArrayList<String> colors;
	public ArrayList<String> labels;
	public String yAxis;
	public String xAxis;

	public OperatorUnitTestBase() {
		super();
		this.name = "";
		this.namespace = "";
		this.inputDataUri = "";
		this.outputDataUri = new ArrayList<String>();
		this.columns = new ArrayList<String>();
		this.rows = new ArrayList<String>();
		this.colors = new ArrayList<String>();
		this.labels = new ArrayList<String>();
		this.yAxis = "";
		this.xAxis = "";
	}

	public OperatorUnitTestBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.OperatorUnitTest_CLASS ? m.get(Vocabulary.KIND)
						: null);
		this.name = (String) m.get(Vocabulary.name_DP);
		this.namespace = (String) m.get(Vocabulary.namespace_DP);
		this.inputDataUri = (String) m.get(Vocabulary.inputDataUri_DP);
		this.outputDataUri = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.outputDataUri_DP)));
		this.columns = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.columns_DP)));
		this.rows = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.rows_DP)));
		this.colors = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.colors_DP)));
		this.labels = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.labels_DP)));
		this.yAxis = (String) m.get(Vocabulary.yAxis_DP);
		this.xAxis = (String) m.get(Vocabulary.xAxis_DP);
	}

	public static OperatorUnitTest createFromJson(LinkedHashMap m) {
		return OperatorUnitTestBase.fromJson(m);
	}

	public static OperatorUnitTest fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.OperatorUnitTest_CLASS:
			return new OperatorUnitTest(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class OperatorUnitTest in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.OperatorUnitTest_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.OperatorUnitTest_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.namespace_DP, namespace);
		m.put(Vocabulary.inputDataUri_DP, inputDataUri);
		m.put(Vocabulary.outputDataUri_DP, outputDataUri);
		m.put(Vocabulary.columns_DP, columns);
		m.put(Vocabulary.rows_DP, rows);
		m.put(Vocabulary.colors_DP, colors);
		m.put(Vocabulary.labels_DP, labels);
		m.put(Vocabulary.yAxis_DP, yAxis);
		m.put(Vocabulary.xAxis_DP, xAxis);
		return m;
	}
}