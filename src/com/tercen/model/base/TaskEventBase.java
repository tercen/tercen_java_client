package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TaskEventBase extends Event {

public String taskId;

public TaskEventBase(){
super();
this.taskId = "";
}

public TaskEventBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.TaskEvent_CLASS ? m.get(Vocabulary.KIND) : null);
this.taskId = (String)m.get(Vocabulary.taskId_DP) ;
}

public static TaskEvent createFromJson(LinkedHashMap m) {return TaskEventBase.fromJson(m);} 
public static TaskEvent fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.TaskEvent_CLASS :
return new TaskEvent(m);
case Vocabulary.TaskLogEvent_CLASS :
return new TaskLogEvent(m);
case Vocabulary.TaskProgressEvent_CLASS :
return new TaskProgressEvent(m);
case Vocabulary.TaskDataEvent_CLASS :
return new TaskDataEvent(m);
case Vocabulary.TaskStateEvent_CLASS :
return new TaskStateEvent(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class TaskEvent in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.TaskEvent_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.TaskEvent_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.taskId_DP, taskId);
return m;
}
}