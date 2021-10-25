package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class AttributeBase extends Factor {

public String relationId;

public AttributeBase(){
super();
this.relationId = "";
}

public AttributeBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.Attribute_CLASS ? m.get(Vocabulary.KIND) : null);
this.relationId = (String)m.get(Vocabulary.relationId_DP) ;
}

public static Attribute createFromJson(LinkedHashMap m) {return AttributeBase.fromJson(m);} 
public static Attribute fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.Attribute_CLASS :
return new Attribute(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class Attribute in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.Attribute_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.Attribute_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.relationId_DP, relationId);
return m;
}
}