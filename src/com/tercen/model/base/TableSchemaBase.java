package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TableSchemaBase extends Schema {


public TableSchemaBase(){
super();
}

public TableSchemaBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.TableSchema_CLASS ? m.get(Vocabulary.KIND) : null);
}

public static TableSchema createFromJson(LinkedHashMap m) {return TableSchemaBase.fromJson(m);} 
public static TableSchema fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.TableSchema_CLASS :
return new TableSchema(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class TableSchema in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.TableSchema_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.TableSchema_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
return m;
}
}