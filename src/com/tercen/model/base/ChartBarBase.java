package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ChartBarBase extends Chart {


public ChartBarBase(){
super();
}

public ChartBarBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.ChartBar_CLASS ? m.get(Vocabulary.KIND) : null);
}

public static ChartBar createFromJson(LinkedHashMap m) {return ChartBarBase.fromJson(m);} 
public static ChartBar fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.ChartBar_CLASS :
return new ChartBar(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class ChartBar in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.ChartBar_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.ChartBar_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
return m;
}
}