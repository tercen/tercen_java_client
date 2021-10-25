package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ReferenceRelationBase extends SimpleRelation {

public Relation relation;

public ReferenceRelationBase(){
super();
this.relation = new Relation();
}

public ReferenceRelationBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.ReferenceRelation_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.relation_OP) == null) this.relation = new Relation();
else this.relation = RelationBase.fromJson((LinkedHashMap)m.get(Vocabulary.relation_OP) );
}

public static ReferenceRelation createFromJson(LinkedHashMap m) {return ReferenceRelationBase.fromJson(m);} 
public static ReferenceRelation fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.ReferenceRelation_CLASS :
return new ReferenceRelation(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class ReferenceRelation in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.ReferenceRelation_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.ReferenceRelation_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.relation_OP, relation == null ? null : relation.toJson()) ;
return m;
}
}