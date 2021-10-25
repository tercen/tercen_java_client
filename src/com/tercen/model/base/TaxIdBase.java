package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TaxIdBase extends BaseObject {

public String type;
public String value;
public boolean isValid;

public TaxIdBase(){
super();
this.type = "";
this.value = "";
this.isValid = true;
}

public TaxIdBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.TaxId_CLASS ? m.get(Vocabulary.KIND) : null);
this.type = (String)m.get(Vocabulary.type_DP) ;
this.value = (String)m.get(Vocabulary.value_DP) ;
this.isValid = (boolean)m.get(Vocabulary.isValid_DP) ;
}

public static TaxId createFromJson(LinkedHashMap m) {return TaxIdBase.fromJson(m);} 
public static TaxId fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.TaxId_CLASS :
return new TaxId(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class TaxId in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.TaxId_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.TaxId_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.type_DP, type);
m.put(Vocabulary.value_DP, value);
m.put(Vocabulary.isValid_DP, isValid);
return m;
}
}