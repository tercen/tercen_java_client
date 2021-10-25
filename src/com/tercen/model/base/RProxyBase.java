package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RProxyBase extends BaseObject {

public String name;
public String targetUrl;

public RProxyBase(){
super();
this.name = "";
this.targetUrl = "";
}

public RProxyBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.RProxy_CLASS ? m.get(Vocabulary.KIND) : null);
this.name = (String)m.get(Vocabulary.name_DP) ;
this.targetUrl = (String)m.get(Vocabulary.targetUrl_DP) ;
}

public static RProxy createFromJson(LinkedHashMap m) {return RProxyBase.fromJson(m);} 
public static RProxy fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.RProxy_CLASS :
return new RProxy(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class RProxy in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.RProxy_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.RProxy_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.name_DP, name);
m.put(Vocabulary.targetUrl_DP, targetUrl);
return m;
}
}