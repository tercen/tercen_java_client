package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TaskBase extends PersistentObject {

	public LinkedList<Pair> environment;
	public State state;
	public Date createdDate;
	public Date lastModifiedDate;
	public Date runDate;
	public Date completedDate;
	public double duration;
	public AclContext aclContext;
	public String owner;
	public String taskHash;
	public String channelId;

	public TaskBase() {
		super();
		this.duration = 0.0;
		this.owner = "";
		this.taskHash = "";
		this.channelId = "";
		this.environment = new LinkedList<Pair>();
		this.state = new State();
		this.createdDate = new Date();
		this.lastModifiedDate = new Date();
		this.runDate = new Date();
		this.completedDate = new Date();
		this.aclContext = new AclContext();
	}

	public TaskBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Task_CLASS ? m.get(Vocabulary.KIND) : null);
		this.duration = (double) (m.get(Vocabulary.duration_DP));
		this.owner = (String) m.get(Vocabulary.owner_DP);
		this.taskHash = (String) m.get(Vocabulary.taskHash_DP);
		this.channelId = (String) m.get(Vocabulary.channelId_DP);
	}

	public static Task createFromJson(LinkedHashMap m) {
		return TaskBase.fromJson(m);
	}

	public static Task fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Task_CLASS:
			return new Task(m);
		case Vocabulary.RunComputationTask_CLASS:
			return new RunComputationTask(m);
		case Vocabulary.SaveComputationResultTask_CLASS:
			return new SaveComputationResultTask(m);
		case Vocabulary.ComputationTask_CLASS:
			return new ComputationTask(m);
		case Vocabulary.ExportWorkflowTask_CLASS:
			return new ExportWorkflowTask(m);
		case Vocabulary.CSVTask_CLASS:
			return new CSVTask(m);
		case Vocabulary.CubeQueryTask_CLASS:
			return new CubeQueryTask(m);
		case Vocabulary.ImportWorkflowTask_CLASS:
			return new ImportWorkflowTask(m);
		case Vocabulary.TestOperatorTask_CLASS:
			return new TestOperatorTask(m);
		case Vocabulary.ImportGitWorkflowTask_CLASS:
			return new ImportGitWorkflowTask(m);
		case Vocabulary.RunWebAppTask_CLASS:
			return new RunWebAppTask(m);
		case Vocabulary.ExportTableTask_CLASS:
			return new ExportTableTask(m);
		case Vocabulary.ProjectTask_CLASS:
			return new ProjectTask(m);
		case Vocabulary.GlTask_CLASS:
			return new GlTask(m);
		case Vocabulary.CreateGitOperatorTask_CLASS:
			return new CreateGitOperatorTask(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Task in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Task_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Task_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.environment_OP, BaseObject.objectListToJson(environment));
		m.put(Vocabulary.state_OP, state == null ? null : state.toJson());
		m.put(Vocabulary.createdDate_OP, createdDate == null ? null : createdDate.toJson());
		m.put(Vocabulary.lastModifiedDate_OP, lastModifiedDate == null ? null : lastModifiedDate.toJson());
		m.put(Vocabulary.runDate_OP, runDate == null ? null : runDate.toJson());
		m.put(Vocabulary.completedDate_OP, completedDate == null ? null : completedDate.toJson());
		m.put(Vocabulary.duration_DP, duration);
		m.put(Vocabulary.aclContext_OP, aclContext == null ? null : aclContext.toJson());
		m.put(Vocabulary.owner_DP, owner);
		m.put(Vocabulary.taskHash_DP, taskHash);
		m.put(Vocabulary.channelId_DP, channelId);
		return m;
	}
}