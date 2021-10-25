package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TableStepBase extends RelationStep {

public TableStepModel model;

public TableStepBase(){
super();
this.model = new TableStepModel();
}

public TableStepBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.TableStep_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.model_OP) == null) this.model = new TableStepModel();
else this.model = TableStepModelBase.fromJson((LinkedHashMap)m.get(Vocabulary.model_OP) );
}

public static TableStep createFromJson(LinkedHashMap m) {return TableStepBase.fromJson(m);} 
public static TableStep fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.TableStep_CLASS :
return new TableStep(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class TableStep in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.TableStep_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.TableStep_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.model_OP, model == null ? null : model.toJson()) ;
return m;
}
}