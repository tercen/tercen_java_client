package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RunWebAppTaskBase extends ProjectTask {

public String operatorId;
public Url url;

public RunWebAppTaskBase(){
super();
this.operatorId = "";
this.url = new Url();
}

public RunWebAppTaskBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.RunWebAppTask_CLASS ? m.get(Vocabulary.KIND) : null);
this.operatorId = (String)m.get(Vocabulary.operatorId_DP) ;
if (m.get(Vocabulary.url_OP) == null) this.url = new Url();
else this.url = UrlBase.fromJson((LinkedHashMap)m.get(Vocabulary.url_OP) );
}

public static RunWebAppTask createFromJson(LinkedHashMap m) {return RunWebAppTaskBase.fromJson(m);} 
public static RunWebAppTask fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.RunWebAppTask_CLASS :
return new RunWebAppTask(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class RunWebAppTask in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.RunWebAppTask_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.RunWebAppTask_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.operatorId_DP, operatorId);
m.put(Vocabulary.url_OP, url == null ? null : url.toJson()) ;
return m;
}
}