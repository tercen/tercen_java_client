package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class BooleanPropertyBase extends Property {

public boolean defaultValue;

public BooleanPropertyBase(){
super();
this.defaultValue = true;
}

public BooleanPropertyBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.BooleanProperty_CLASS ? m.get(Vocabulary.KIND) : null);
this.defaultValue = (boolean)m.get(Vocabulary.defaultValue_DP) ;
}

public static BooleanProperty createFromJson(LinkedHashMap m) {return BooleanPropertyBase.fromJson(m);} 
public static BooleanProperty fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.BooleanProperty_CLASS :
return new BooleanProperty(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class BooleanProperty in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.BooleanProperty_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.BooleanProperty_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.defaultValue_DP, defaultValue);
return m;
}
}