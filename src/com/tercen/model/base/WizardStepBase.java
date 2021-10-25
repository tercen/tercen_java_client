package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class WizardStepBase extends NamespaceStep {

public WizardStepModel model;

public WizardStepBase(){
super();
this.model = new WizardStepModel();
}

public WizardStepBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.WizardStep_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.model_OP) == null) this.model = new WizardStepModel();
else this.model = WizardStepModelBase.fromJson((LinkedHashMap)m.get(Vocabulary.model_OP) );
}

public static WizardStep createFromJson(LinkedHashMap m) {return WizardStepBase.fromJson(m);} 
public static WizardStep fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.WizardStep_CLASS :
return new WizardStep(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class WizardStep in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.WizardStep_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.WizardStep_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.model_OP, model == null ? null : model.toJson()) ;
return m;
}
}