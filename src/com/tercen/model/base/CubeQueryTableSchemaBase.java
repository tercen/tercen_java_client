package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CubeQueryTableSchemaBase extends Schema {

public String queryHash;
public String queryTableType;
public CubeQuery query;

public CubeQueryTableSchemaBase(){
super();
this.queryHash = "";
this.queryTableType = "";
this.query = new CubeQuery();
}

public CubeQueryTableSchemaBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.CubeQueryTableSchema_CLASS ? m.get(Vocabulary.KIND) : null);
this.queryHash = (String)m.get(Vocabulary.queryHash_DP) ;
this.queryTableType = (String)m.get(Vocabulary.queryTableType_DP) ;
if (m.get(Vocabulary.query_OP) == null) this.query = new CubeQuery();
else this.query = CubeQueryBase.fromJson((LinkedHashMap)m.get(Vocabulary.query_OP) );
}

public static CubeQueryTableSchema createFromJson(LinkedHashMap m) {return CubeQueryTableSchemaBase.fromJson(m);} 
public static CubeQueryTableSchema fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.CubeQueryTableSchema_CLASS :
return new CubeQueryTableSchema(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class CubeQueryTableSchema in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.CubeQueryTableSchema_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.CubeQueryTableSchema_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.queryHash_DP, queryHash);
m.put(Vocabulary.queryTableType_DP, queryTableType);
m.put(Vocabulary.query_OP, query == null ? null : query.toJson()) ;
return m;
}
}