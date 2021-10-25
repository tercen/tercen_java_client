package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CrossTabStepBase extends NamespaceStep {

public Crosstab model;

public CrossTabStepBase(){
super();
this.model = new Crosstab();
}

public CrossTabStepBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.CrossTabStep_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.model_OP) == null) this.model = new Crosstab();
else this.model = CrosstabBase.fromJson((LinkedHashMap)m.get(Vocabulary.model_OP) );
}

public static CrossTabStep createFromJson(LinkedHashMap m) {return CrossTabStepBase.fromJson(m);} 
public static CrossTabStep fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.CrossTabStep_CLASS :
return new CrossTabStep(m);
case Vocabulary.DataStep_CLASS :
return new DataStep(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class CrossTabStep in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.CrossTabStep_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.CrossTabStep_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.model_OP, model == null ? null : model.toJson()) ;
return m;
}
}