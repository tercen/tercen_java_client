package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class WhereRelationBase extends Relation {

public Relation relation;
public Filters filters;

public WhereRelationBase(){
super();
this.relation = new Relation();
this.filters = new Filters();
}

public WhereRelationBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.WhereRelation_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.relation_OP) == null) this.relation = new Relation();
else this.relation = RelationBase.fromJson((LinkedHashMap)m.get(Vocabulary.relation_OP) );
if (m.get(Vocabulary.filters_OP) == null) this.filters = new Filters();
else this.filters = FiltersBase.fromJson((LinkedHashMap)m.get(Vocabulary.filters_OP) );
}

public static WhereRelation createFromJson(LinkedHashMap m) {return WhereRelationBase.fromJson(m);} 
public static WhereRelation fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.WhereRelation_CLASS :
return new WhereRelation(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class WhereRelation in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.WhereRelation_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.WhereRelation_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.relation_OP, relation == null ? null : relation.toJson()) ;
m.put(Vocabulary.filters_OP, filters == null ? null : filters.toJson()) ;
return m;
}
}