package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class DoubleColorElementBase extends ColorElement {

public String stringValue;

public DoubleColorElementBase(){
super();
this.stringValue = "";
}

public DoubleColorElementBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.DoubleColorElement_CLASS ? m.get(Vocabulary.KIND) : null);
this.stringValue = (String)m.get(Vocabulary.stringValue_DP) ;
}

public static DoubleColorElement createFromJson(LinkedHashMap m) {return DoubleColorElementBase.fromJson(m);} 
public static DoubleColorElement fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.DoubleColorElement_CLASS :
return new DoubleColorElement(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class DoubleColorElement in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.DoubleColorElement_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.DoubleColorElement_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.stringValue_DP, stringValue);
return m;
}
}