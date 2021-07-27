package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class StepBase extends IdObject {

	public String groupId;
	public String name;
	public LinkedList<InputPort> inputs;
	public LinkedList<OutputPort> outputs;
	public Rectangle rectangle;
	public StepState state;

	public StepBase() {
		super();
		this.groupId = "";
		this.name = "";
		this.inputs = new LinkedList<InputPort>();
		this.outputs = new LinkedList<OutputPort>();
		this.rectangle = new Rectangle();
		this.state = new StepState();
	}

	public StepBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Step_CLASS ? m.get(Vocabulary.KIND) : null);
		this.groupId = (String) m.get(Vocabulary.groupId_DP);
		this.name = (String) m.get(Vocabulary.name_DP);
	}

	public static Step createFromJson(LinkedHashMap m) {
		return StepBase.fromJson(m);
	}

	public static Step fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Step_CLASS:
			return new Step(m);
		case Vocabulary.DataStep_CLASS:
			return new DataStep(m);
		case Vocabulary.MeltStep_CLASS:
			return new MeltStep(m);
		case Vocabulary.JoinStep_CLASS:
			return new JoinStep(m);
		case Vocabulary.WizardStep_CLASS:
			return new WizardStep(m);
		case Vocabulary.CrossTabStep_CLASS:
			return new CrossTabStep(m);
		case Vocabulary.GroupStep_CLASS:
			return new GroupStep(m);
		case Vocabulary.InStep_CLASS:
			return new InStep(m);
		case Vocabulary.OutStep_CLASS:
			return new OutStep(m);
		case Vocabulary.TableStep_CLASS:
			return new TableStep(m);
		case Vocabulary.NamespaceStep_CLASS:
			return new NamespaceStep(m);
		case Vocabulary.RelationStep_CLASS:
			return new RelationStep(m);
		case Vocabulary.ExportStep_CLASS:
			return new ExportStep(m);
		case Vocabulary.ModelStep_CLASS:
			return new ModelStep(m);
		case Vocabulary.ViewStep_CLASS:
			return new ViewStep(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Step in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Step_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Step_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.groupId_DP, groupId);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.inputs_OP, BaseObject.objectListToJson(inputs));
		m.put(Vocabulary.outputs_OP, BaseObject.objectListToJson(outputs));
		m.put(Vocabulary.rectangle_OP, rectangle == null ? null : rectangle.toJson());
		m.put(Vocabulary.state_OP, state == null ? null : state.toJson());
		return m;
	}
}