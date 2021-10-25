package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class MeltStepBase extends NamespaceStep {

public MeltStepModel model;
public ArrayList<Attribute> meltedAttributes;

public MeltStepBase(){
super();
this.model = new MeltStepModel();
this.meltedAttributes = new ArrayList<Attribute>();
}

public MeltStepBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.MeltStep_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.model_OP) == null) this.model = new MeltStepModel();
else this.model = MeltStepModelBase.fromJson((LinkedHashMap)m.get(Vocabulary.model_OP) );
if (m.get(Vocabulary.meltedAttributes_OP) == null)
this.meltedAttributes = new ArrayList<Attribute>();
else {
this.meltedAttributes = new ArrayList<Attribute>();
ArrayList list = (ArrayList)m.get(Vocabulary.meltedAttributes_OP);
for (Object map : list) {
this.meltedAttributes.add(AttributeBase.createFromJson((LinkedHashMap)map));
}
}
}

public static MeltStep createFromJson(LinkedHashMap m) {return MeltStepBase.fromJson(m);} 
public static MeltStep fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.MeltStep_CLASS :
return new MeltStep(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class MeltStep in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.MeltStep_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.MeltStep_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.model_OP, model == null ? null : model.toJson()) ;
m.put(Vocabulary.meltedAttributes_OP, BaseObject.objectListToJson(meltedAttributes));
return m;
}
}