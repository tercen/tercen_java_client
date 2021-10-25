package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ColumnBase extends ColumnSchema {

public Object values;

public ColumnBase(){
super();
this.values = null;
}

public ColumnBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.Column_CLASS ? m.get(Vocabulary.KIND) : null);
this.values = (Object)m.get(Vocabulary.values_DP) ;
}

public static Column createFromJson(LinkedHashMap m) {return ColumnBase.fromJson(m);} 
public static Column fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.Column_CLASS :
return new Column(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class Column in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.Column_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.Column_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.values_DP, values);
return m;
}
}