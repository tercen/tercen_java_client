package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class DataStepBase extends CrossTabStep {

public Relation computedRelation;

public DataStepBase(){
super();
this.computedRelation = new Relation();
}

public DataStepBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.DataStep_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.computedRelation_OP) == null) this.computedRelation = new Relation();
else this.computedRelation = RelationBase.fromJson((LinkedHashMap)m.get(Vocabulary.computedRelation_OP) );
}

public static DataStep createFromJson(LinkedHashMap m) {return DataStepBase.fromJson(m);} 
public static DataStep fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.DataStep_CLASS :
return new DataStep(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class DataStep in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.DataStep_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.DataStep_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.computedRelation_OP, computedRelation == null ? null : computedRelation.toJson()) ;
return m;
}
}