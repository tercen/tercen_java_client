package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ColumnSchemaBase extends IdObject {

public String name;
public String type;
public int nRows;
public int size;
public ColumnSchemaMetaData metaData;

public ColumnSchemaBase(){
super();
this.name = "";
this.type = "";
this.nRows = 0;
this.size = 0;
this.metaData = new ColumnSchemaMetaData();
}

public ColumnSchemaBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.ColumnSchema_CLASS ? m.get(Vocabulary.KIND) : null);
this.name = (String)m.get(Vocabulary.name_DP) ;
this.type = (String)m.get(Vocabulary.type_DP) ;
this.nRows = (int)m.get(Vocabulary.nRows_DP) ;
this.size = (int)m.get(Vocabulary.size_DP) ;
if (m.get(Vocabulary.metaData_OP) == null) this.metaData = new ColumnSchemaMetaData();
else this.metaData = ColumnSchemaMetaDataBase.fromJson((LinkedHashMap)m.get(Vocabulary.metaData_OP) );
}

public static ColumnSchema createFromJson(LinkedHashMap m) {return ColumnSchemaBase.fromJson(m);} 
public static ColumnSchema fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.ColumnSchema_CLASS :
return new ColumnSchema(m);
case Vocabulary.Column_CLASS :
return new Column(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class ColumnSchema in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.ColumnSchema_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.ColumnSchema_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.name_DP, name);
m.put(Vocabulary.type_DP, type);
m.put(Vocabulary.nRows_DP, nRows);
m.put(Vocabulary.size_DP, size);
m.put(Vocabulary.metaData_OP, metaData == null ? null : metaData.toJson()) ;
return m;
}
}