package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ErrorsBase extends BaseObject {

public ArrayList<Factor> factors;

public ErrorsBase(){
super();
this.factors = new ArrayList<Factor>();
}

public ErrorsBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.Errors_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.factors_OP) == null)
this.factors = new ArrayList<Factor>();
else {
this.factors = new ArrayList<Factor>();
ArrayList list = (ArrayList)m.get(Vocabulary.factors_OP);
for (Object map : list) {
this.factors.add(FactorBase.createFromJson((LinkedHashMap)map));
}
}
}

public static Errors createFromJson(LinkedHashMap m) {return ErrorsBase.fromJson(m);} 
public static Errors fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.Errors_CLASS :
return new Errors(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class Errors in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.Errors_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.Errors_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.factors_OP, BaseObject.objectListToJson(factors));
return m;
}
}