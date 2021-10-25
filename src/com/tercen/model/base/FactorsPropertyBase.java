package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class FactorsPropertyBase extends StringProperty {


public FactorsPropertyBase(){
super();
}

public FactorsPropertyBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.FactorsProperty_CLASS ? m.get(Vocabulary.KIND) : null);
}

public static FactorsProperty createFromJson(LinkedHashMap m) {return FactorsPropertyBase.fromJson(m);} 
public static FactorsProperty fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.FactorsProperty_CLASS :
return new FactorsProperty(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class FactorsProperty in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.FactorsProperty_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.FactorsProperty_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
return m;
}
}