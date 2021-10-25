package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class WorkerBase extends BaseObject {

public String status;
public String name;
public String uri;
public double priority;
public int nCPU;
public int nThread;
public double memory;
public int nAvailableThread;
public double availableMemory;
public ArrayList<String> availableTaskTypes;
public String lastDateActivity;
public int heartBeat;

public WorkerBase(){
super();
this.status = "";
this.name = "";
this.uri = "";
this.priority = 0.0;
this.nCPU = 0;
this.nThread = 0;
this.memory = 0.0;
this.nAvailableThread = 0;
this.availableMemory = 0.0;
this.availableTaskTypes = new ArrayList<String>();
this.lastDateActivity = "";
this.heartBeat = 0;
}

public WorkerBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.Worker_CLASS ? m.get(Vocabulary.KIND) : null);
this.status = (String)m.get(Vocabulary.status_DP) ;
this.name = (String)m.get(Vocabulary.name_DP) ;
this.uri = (String)m.get(Vocabulary.uri_DP) ;
this.priority = (double)(m.get(Vocabulary.priority_DP) ) ;
this.nCPU = (int)m.get(Vocabulary.nCPU_DP) ;
this.nThread = (int)m.get(Vocabulary.nThread_DP) ;
this.memory = (double)(m.get(Vocabulary.memory_DP) ) ;
this.nAvailableThread = (int)m.get(Vocabulary.nAvailableThread_DP) ;
this.availableMemory = (double)(m.get(Vocabulary.availableMemory_DP) ) ;
this.availableTaskTypes = new ArrayList<String>( (Collection<? extends String>)(m.get(Vocabulary.availableTaskTypes_DP) ) );
this.lastDateActivity = (String)m.get(Vocabulary.lastDateActivity_DP) ;
this.heartBeat = (int)m.get(Vocabulary.heartBeat_DP) ;
}

public static Worker createFromJson(LinkedHashMap m) {return WorkerBase.fromJson(m);} 
public static Worker fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.Worker_CLASS :
return new Worker(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class Worker in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.Worker_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.Worker_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.status_DP, status);
m.put(Vocabulary.name_DP, name);
m.put(Vocabulary.uri_DP, uri);
m.put(Vocabulary.priority_DP, priority);
m.put(Vocabulary.nCPU_DP, nCPU);
m.put(Vocabulary.nThread_DP, nThread);
m.put(Vocabulary.memory_DP, memory);
m.put(Vocabulary.nAvailableThread_DP, nAvailableThread);
m.put(Vocabulary.availableMemory_DP, availableMemory);
m.put(Vocabulary.availableTaskTypes_DP, availableTaskTypes);
m.put(Vocabulary.lastDateActivity_DP, lastDateActivity);
m.put(Vocabulary.heartBeat_DP, heartBeat);
return m;
}
}