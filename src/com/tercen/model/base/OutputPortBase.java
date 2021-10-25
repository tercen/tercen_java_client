package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class OutputPortBase extends Port {


public OutputPortBase(){
super();
}

public OutputPortBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.OutputPort_CLASS ? m.get(Vocabulary.KIND) : null);
}

public static OutputPort createFromJson(LinkedHashMap m) {return OutputPortBase.fromJson(m);} 
public static OutputPort fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.OutputPort_CLASS :
return new OutputPort(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class OutputPort in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.OutputPort_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.OutputPort_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
return m;
}
}