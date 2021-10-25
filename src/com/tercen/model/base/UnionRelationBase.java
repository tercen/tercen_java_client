package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class UnionRelationBase extends Relation {

public ArrayList<Relation> relations;

public UnionRelationBase(){
super();
this.relations = new ArrayList<Relation>();
}

public UnionRelationBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.UnionRelation_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.relations_OP) == null)
this.relations = new ArrayList<Relation>();
else {
this.relations = new ArrayList<Relation>();
ArrayList list = (ArrayList)m.get(Vocabulary.relations_OP);
for (Object map : list) {
this.relations.add(RelationBase.createFromJson((LinkedHashMap)map));
}
}
}

public static UnionRelation createFromJson(LinkedHashMap m) {return UnionRelationBase.fromJson(m);} 
public static UnionRelation fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.UnionRelation_CLASS :
return new UnionRelation(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class UnionRelation in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.UnionRelation_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.UnionRelation_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.relations_OP, BaseObject.objectListToJson(relations));
return m;
}
}