package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TaskDataEventBase extends TaskEvent {

public byte[] bytes;

public TaskDataEventBase(){
super();
this.bytes = null;
}

public TaskDataEventBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.TaskDataEvent_CLASS ? m.get(Vocabulary.KIND) : null);
this.bytes = (byte[])m.get(Vocabulary.bytes_DP) ;
}

public static TaskDataEvent createFromJson(LinkedHashMap m) {return TaskDataEventBase.fromJson(m);} 
public static TaskDataEvent fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.TaskDataEvent_CLASS :
return new TaskDataEvent(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class TaskDataEvent in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.TaskDataEvent_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.TaskDataEvent_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.bytes_DP, bytes);
return m;
}
}