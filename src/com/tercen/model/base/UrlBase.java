package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class UrlBase extends BaseObject {

public String uri;

public UrlBase(){
super();
this.uri = "";
}

public UrlBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.Url_CLASS ? m.get(Vocabulary.KIND) : null);
this.uri = (String)m.get(Vocabulary.uri_DP) ;
}

public static Url createFromJson(LinkedHashMap m) {return UrlBase.fromJson(m);} 
public static Url fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.Url_CLASS :
return new Url(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class Url in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.Url_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.Url_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.uri_DP, uri);
return m;
}
}