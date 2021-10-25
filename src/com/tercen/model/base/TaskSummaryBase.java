package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TaskSummaryBase extends BaseObject {

public int n;
public double duration;

public TaskSummaryBase(){
super();
this.n = 0;
this.duration = 0.0;
}

public TaskSummaryBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.TaskSummary_CLASS ? m.get(Vocabulary.KIND) : null);
this.n = (int)m.get(Vocabulary.n_DP) ;
this.duration = (double)(m.get(Vocabulary.duration_DP) ) ;
}

public static TaskSummary createFromJson(LinkedHashMap m) {return TaskSummaryBase.fromJson(m);} 
public static TaskSummary fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.TaskSummary_CLASS :
return new TaskSummary(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class TaskSummary in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.TaskSummary_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.TaskSummary_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.n_DP, n);
m.put(Vocabulary.duration_DP, duration);
return m;
}
}