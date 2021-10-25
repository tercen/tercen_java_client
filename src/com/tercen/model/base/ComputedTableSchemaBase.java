package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ComputedTableSchemaBase extends Schema {

public CubeQuery query;

public ComputedTableSchemaBase(){
super();
this.query = new CubeQuery();
}

public ComputedTableSchemaBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.ComputedTableSchema_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.query_OP) == null) this.query = new CubeQuery();
else this.query = CubeQueryBase.fromJson((LinkedHashMap)m.get(Vocabulary.query_OP) );
}

public static ComputedTableSchema createFromJson(LinkedHashMap m) {return ComputedTableSchemaBase.fromJson(m);} 
public static ComputedTableSchema fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.ComputedTableSchema_CLASS :
return new ComputedTableSchema(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class ComputedTableSchema in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.ComputedTableSchema_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.ComputedTableSchema_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.query_OP, query == null ? null : query.toJson()) ;
return m;
}
}