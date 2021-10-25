package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class SimpleRelationBase extends Relation {

public int index;

public SimpleRelationBase(){
super();
this.index = 0;
}

public SimpleRelationBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.SimpleRelation_CLASS ? m.get(Vocabulary.KIND) : null);
this.index = (int)m.get(Vocabulary.index_DP) ;
}

public static SimpleRelation createFromJson(LinkedHashMap m) {return SimpleRelationBase.fromJson(m);} 
public static SimpleRelation fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.SimpleRelation_CLASS :
return new SimpleRelation(m);
case Vocabulary.ReferenceRelation_CLASS :
return new ReferenceRelation(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class SimpleRelation in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.SimpleRelation_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.SimpleRelation_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.index_DP, index);
return m;
}
}