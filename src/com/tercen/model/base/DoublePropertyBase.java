package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class DoublePropertyBase extends Property {

public double defaultValue;

public DoublePropertyBase(){
super();
this.defaultValue = 0.0;
}

public DoublePropertyBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.DoubleProperty_CLASS ? m.get(Vocabulary.KIND) : null);
this.defaultValue = (double)(m.get(Vocabulary.defaultValue_DP) ) ;
}

public static DoubleProperty createFromJson(LinkedHashMap m) {return DoublePropertyBase.fromJson(m);} 
public static DoubleProperty fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.DoubleProperty_CLASS :
return new DoubleProperty(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class DoubleProperty in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.DoubleProperty_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.DoubleProperty_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.defaultValue_DP, defaultValue);
return m;
}
}