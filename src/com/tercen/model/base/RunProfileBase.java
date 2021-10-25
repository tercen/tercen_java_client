package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RunProfileBase extends Profile {

public int memory;
public int kernelMemory;
public int blkioWeight;
public int pidsLimit;
public int ulimits_nofile;
public int timeout;
public String storageSize;
public String cpusetCpus;

public RunProfileBase(){
super();
this.memory = 0;
this.kernelMemory = 0;
this.blkioWeight = 0;
this.pidsLimit = 0;
this.ulimits_nofile = 0;
this.timeout = 0;
this.storageSize = "";
this.cpusetCpus = "";
}

public RunProfileBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.RunProfile_CLASS ? m.get(Vocabulary.KIND) : null);
this.memory = (int)m.get(Vocabulary.memory_DP) ;
this.kernelMemory = (int)m.get(Vocabulary.kernelMemory_DP) ;
this.blkioWeight = (int)m.get(Vocabulary.blkioWeight_DP) ;
this.pidsLimit = (int)m.get(Vocabulary.pidsLimit_DP) ;
this.ulimits_nofile = (int)m.get(Vocabulary.ulimits_nofile_DP) ;
this.timeout = (int)m.get(Vocabulary.timeout_DP) ;
this.storageSize = (String)m.get(Vocabulary.storageSize_DP) ;
this.cpusetCpus = (String)m.get(Vocabulary.cpusetCpus_DP) ;
}

public static RunProfile createFromJson(LinkedHashMap m) {return RunProfileBase.fromJson(m);} 
public static RunProfile fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.RunProfile_CLASS :
return new RunProfile(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class RunProfile in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.RunProfile_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.RunProfile_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.memory_DP, memory);
m.put(Vocabulary.kernelMemory_DP, kernelMemory);
m.put(Vocabulary.blkioWeight_DP, blkioWeight);
m.put(Vocabulary.pidsLimit_DP, pidsLimit);
m.put(Vocabulary.ulimits_nofile_DP, ulimits_nofile);
m.put(Vocabulary.timeout_DP, timeout);
m.put(Vocabulary.storageSize_DP, storageSize);
m.put(Vocabulary.cpusetCpus_DP, cpusetCpus);
return m;
}
}