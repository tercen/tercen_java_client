package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class AclContextBase extends BaseObject {

public String username;

public AclContextBase(){
super();
this.username = "";
}

public AclContextBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.AclContext_CLASS ? m.get(Vocabulary.KIND) : null);
this.username = (String)m.get(Vocabulary.username_DP) ;
}

public static AclContext createFromJson(LinkedHashMap m) {return AclContextBase.fromJson(m);} 
public static AclContext fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.AclContext_CLASS :
return new AclContext(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class AclContext in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.AclContext_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.AclContext_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.username_DP, username);
return m;
}
}