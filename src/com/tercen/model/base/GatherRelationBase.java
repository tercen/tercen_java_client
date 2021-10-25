package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class GatherRelationBase extends Relation {

public Relation relation;
public ArrayList<String> names;
public String valueName;
public String variableName;
public String valueType;

public GatherRelationBase(){
super();
this.names = new ArrayList<String>();
this.valueName = "";
this.variableName = "";
this.valueType = "";
this.relation = new Relation();
}

public GatherRelationBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.GatherRelation_CLASS ? m.get(Vocabulary.KIND) : null);
this.names = new ArrayList<String>( (Collection<? extends String>)(m.get(Vocabulary.names_DP) ) );
this.valueName = (String)m.get(Vocabulary.valueName_DP) ;
this.variableName = (String)m.get(Vocabulary.variableName_DP) ;
this.valueType = (String)m.get(Vocabulary.valueType_DP) ;
if (m.get(Vocabulary.relation_OP) == null) this.relation = new Relation();
else this.relation = RelationBase.fromJson((LinkedHashMap)m.get(Vocabulary.relation_OP) );
}

public static GatherRelation createFromJson(LinkedHashMap m) {return GatherRelationBase.fromJson(m);} 
public static GatherRelation fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.GatherRelation_CLASS :
return new GatherRelation(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class GatherRelation in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.GatherRelation_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.GatherRelation_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.relation_OP, relation == null ? null : relation.toJson()) ;
m.put(Vocabulary.names_DP, names);
m.put(Vocabulary.valueName_DP, valueName);
m.put(Vocabulary.variableName_DP, variableName);
m.put(Vocabulary.valueType_DP, valueType);
return m;
}
}