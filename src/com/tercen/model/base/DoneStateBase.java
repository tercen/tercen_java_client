package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class DoneStateBase extends State {


public DoneStateBase(){
super();
}

public DoneStateBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.DoneState_CLASS ? m.get(Vocabulary.KIND) : null);
}

public static DoneState createFromJson(LinkedHashMap m) {return DoneStateBase.fromJson(m);} 
public static DoneState fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.DoneState_CLASS :
return new DoneState(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class DoneState in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.DoneState_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.DoneState_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
return m;
}
}