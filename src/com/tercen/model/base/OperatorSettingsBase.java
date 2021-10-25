package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class OperatorSettingsBase extends BaseObject {

public String namespace;
public OperatorRef operatorRef;
public ArrayList<Pair> environment;

public OperatorSettingsBase(){
super();
this.namespace = "";
this.operatorRef = new OperatorRef();
this.environment = new ArrayList<Pair>();
}

public OperatorSettingsBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.OperatorSettings_CLASS ? m.get(Vocabulary.KIND) : null);
this.namespace = (String)m.get(Vocabulary.namespace_DP) ;
if (m.get(Vocabulary.operatorRef_OP) == null) this.operatorRef = new OperatorRef();
else this.operatorRef = OperatorRefBase.fromJson((LinkedHashMap)m.get(Vocabulary.operatorRef_OP) );
if (m.get(Vocabulary.environment_OP) == null)
this.environment = new ArrayList<Pair>();
else {
this.environment = new ArrayList<Pair>();
ArrayList list = (ArrayList)m.get(Vocabulary.environment_OP);
for (Object map : list) {
this.environment.add(PairBase.createFromJson((LinkedHashMap)map));
}
}
}

public static OperatorSettings createFromJson(LinkedHashMap m) {return OperatorSettingsBase.fromJson(m);} 
public static OperatorSettings fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.OperatorSettings_CLASS :
return new OperatorSettings(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class OperatorSettings in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.OperatorSettings_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.OperatorSettings_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.namespace_DP, namespace);
m.put(Vocabulary.operatorRef_OP, operatorRef == null ? null : operatorRef.toJson()) ;
m.put(Vocabulary.environment_OP, BaseObject.objectListToJson(environment));
return m;
}
}