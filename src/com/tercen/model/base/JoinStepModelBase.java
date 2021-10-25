package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class JoinStepModelBase extends StepModel {

public ArrayList<Factor> leftFactors;
public ArrayList<Factor> rightFactors;
public String rightPrefix;

public JoinStepModelBase(){
super();
this.rightPrefix = "";
this.leftFactors = new ArrayList<Factor>();
this.rightFactors = new ArrayList<Factor>();
}

public JoinStepModelBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.JoinStepModel_CLASS ? m.get(Vocabulary.KIND) : null);
this.rightPrefix = (String)m.get(Vocabulary.rightPrefix_DP) ;
if (m.get(Vocabulary.leftFactors_OP) == null)
this.leftFactors = new ArrayList<Factor>();
else {
this.leftFactors = new ArrayList<Factor>();
ArrayList list = (ArrayList)m.get(Vocabulary.leftFactors_OP);
for (Object map : list) {
this.leftFactors.add(FactorBase.createFromJson((LinkedHashMap)map));
}
}
if (m.get(Vocabulary.rightFactors_OP) == null)
this.rightFactors = new ArrayList<Factor>();
else {
this.rightFactors = new ArrayList<Factor>();
ArrayList list = (ArrayList)m.get(Vocabulary.rightFactors_OP);
for (Object map : list) {
this.rightFactors.add(FactorBase.createFromJson((LinkedHashMap)map));
}
}
}

public static JoinStepModel createFromJson(LinkedHashMap m) {return JoinStepModelBase.fromJson(m);} 
public static JoinStepModel fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.JoinStepModel_CLASS :
return new JoinStepModel(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class JoinStepModel in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.JoinStepModel_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.JoinStepModel_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.leftFactors_OP, BaseObject.objectListToJson(leftFactors));
m.put(Vocabulary.rightFactors_OP, BaseObject.objectListToJson(rightFactors));
m.put(Vocabulary.rightPrefix_DP, rightPrefix);
return m;
}
}