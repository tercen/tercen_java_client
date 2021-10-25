package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class InitStateBase extends State {


public InitStateBase(){
super();
}

public InitStateBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.InitState_CLASS ? m.get(Vocabulary.KIND) : null);
}

public static InitState createFromJson(LinkedHashMap m) {return InitStateBase.fromJson(m);} 
public static InitState fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.InitState_CLASS :
return new InitState(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class InitState in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.InitState_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.InitState_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
return m;
}
}