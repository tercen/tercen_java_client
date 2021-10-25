package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class StepStateBase extends BaseObject {

public String taskId;
public State taskState;

public StepStateBase(){
super();
this.taskId = "";
this.taskState = new State();
}

public StepStateBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.StepState_CLASS ? m.get(Vocabulary.KIND) : null);
this.taskId = (String)m.get(Vocabulary.taskId_DP) ;
if (m.get(Vocabulary.taskState_OP) == null) this.taskState = new State();
else this.taskState = StateBase.fromJson((LinkedHashMap)m.get(Vocabulary.taskState_OP) );
}

public static StepState createFromJson(LinkedHashMap m) {return StepStateBase.fromJson(m);} 
public static StepState fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.StepState_CLASS :
return new StepState(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class StepState in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.StepState_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.StepState_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.taskId_DP, taskId);
m.put(Vocabulary.taskState_OP, taskState == null ? null : taskState.toJson()) ;
return m;
}
}