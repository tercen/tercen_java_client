package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class PersistentObjectBase extends IdObject {

public boolean isDeleted;
public String rev;

public PersistentObjectBase(){
super();
this.isDeleted = true;
this.rev = "";
}

public PersistentObjectBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.PersistentObject_CLASS ? m.get(Vocabulary.KIND) : null);
this.isDeleted = (boolean)m.get(Vocabulary.isDeleted_DP) ;
this.rev = (String)m.get(Vocabulary.rev_DP) ;
}

public static PersistentObject createFromJson(LinkedHashMap m) {return PersistentObjectBase.fromJson(m);} 
public static PersistentObject fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.PersistentObject_CLASS :
return new PersistentObject(m);
case Vocabulary.GarbageTasks_CLASS :
return new GarbageTasks(m);
case Vocabulary.Team_CLASS :
return new Team(m);
case Vocabulary.RSourceLibrary_CLASS :
return new RSourceLibrary(m);
case Vocabulary.RenvInstalledLibrary_CLASS :
return new RenvInstalledLibrary(m);
case Vocabulary.ShinyOperator_CLASS :
return new ShinyOperator(m);
case Vocabulary.DockerWebAppOperator_CLASS :
return new DockerWebAppOperator(m);
case Vocabulary.DockerOperator_CLASS :
return new DockerOperator(m);
case Vocabulary.ROperator_CLASS :
return new ROperator(m);
case Vocabulary.WebAppOperator_CLASS :
return new WebAppOperator(m);
case Vocabulary.GitOperator_CLASS :
return new GitOperator(m);
case Vocabulary.CubeQueryTableSchema_CLASS :
return new CubeQueryTableSchema(m);
case Vocabulary.TableSchema_CLASS :
return new TableSchema(m);
case Vocabulary.ComputedTableSchema_CLASS :
return new ComputedTableSchema(m);
case Vocabulary.Issue_CLASS :
return new Issue(m);
case Vocabulary.FileDocument_CLASS :
return new FileDocument(m);
case Vocabulary.FolderDocument_CLASS :
return new FolderDocument(m);
case Vocabulary.Schema_CLASS :
return new Schema(m);
case Vocabulary.IssueMessage_CLASS :
return new IssueMessage(m);
case Vocabulary.Workflow_CLASS :
return new Workflow(m);
case Vocabulary.User_CLASS :
return new User(m);
case Vocabulary.RLibrary_CLASS :
return new RLibrary(m);
case Vocabulary.Operator_CLASS :
return new Operator(m);
case Vocabulary.WorkerEndpoint_CLASS :
return new WorkerEndpoint(m);
case Vocabulary.ProjectDocument_CLASS :
return new ProjectDocument(m);
case Vocabulary.Project_CLASS :
return new Project(m);
case Vocabulary.SubscriptionPlan_CLASS :
return new SubscriptionPlan(m);
case Vocabulary.RunComputationTask_CLASS :
return new RunComputationTask(m);
case Vocabulary.SaveComputationResultTask_CLASS :
return new SaveComputationResultTask(m);
case Vocabulary.ComputationTask_CLASS :
return new ComputationTask(m);
case Vocabulary.ExportWorkflowTask_CLASS :
return new ExportWorkflowTask(m);
case Vocabulary.CSVTask_CLASS :
return new CSVTask(m);
case Vocabulary.CubeQueryTask_CLASS :
return new CubeQueryTask(m);
case Vocabulary.ImportWorkflowTask_CLASS :
return new ImportWorkflowTask(m);
case Vocabulary.TestOperatorTask_CLASS :
return new TestOperatorTask(m);
case Vocabulary.ImportGitWorkflowTask_CLASS :
return new ImportGitWorkflowTask(m);
case Vocabulary.RunWebAppTask_CLASS :
return new RunWebAppTask(m);
case Vocabulary.ExportTableTask_CLASS :
return new ExportTableTask(m);
case Vocabulary.ProjectTask_CLASS :
return new ProjectTask(m);
case Vocabulary.GlTask_CLASS :
return new GlTask(m);
case Vocabulary.CreateGitOperatorTask_CLASS :
return new CreateGitOperatorTask(m);
case Vocabulary.TaskLogEvent_CLASS :
return new TaskLogEvent(m);
case Vocabulary.TaskProgressEvent_CLASS :
return new TaskProgressEvent(m);
case Vocabulary.TaskDataEvent_CLASS :
return new TaskDataEvent(m);
case Vocabulary.TaskStateEvent_CLASS :
return new TaskStateEvent(m);
case Vocabulary.TaskEvent_CLASS :
return new TaskEvent(m);
case Vocabulary.GenericEvent_CLASS :
return new GenericEvent(m);
case Vocabulary.GarbageObject_CLASS :
return new GarbageObject(m);
case Vocabulary.Activity_CLASS :
return new Activity(m);
case Vocabulary.Document_CLASS :
return new Document(m);
case Vocabulary.Lock_CLASS :
return new Lock(m);
case Vocabulary.Task_CLASS :
return new Task(m);
case Vocabulary.Event_CLASS :
return new Event(m);
case Vocabulary.UserSecret_CLASS :
return new UserSecret(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class PersistentObject in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.PersistentObject_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.PersistentObject_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.isDeleted_DP, isDeleted);
m.put(Vocabulary.rev_DP, rev);
return m;
}
}