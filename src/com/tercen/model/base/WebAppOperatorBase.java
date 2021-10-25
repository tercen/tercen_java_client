package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class WebAppOperatorBase extends GitOperator {

public boolean isViewOnly;

public WebAppOperatorBase(){
super();
this.isViewOnly = true;
}

public WebAppOperatorBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.WebAppOperator_CLASS ? m.get(Vocabulary.KIND) : null);
this.isViewOnly = (boolean)m.get(Vocabulary.isViewOnly_DP) ;
}

public static WebAppOperator createFromJson(LinkedHashMap m) {return WebAppOperatorBase.fromJson(m);} 
public static WebAppOperator fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.WebAppOperator_CLASS :
return new WebAppOperator(m);
case Vocabulary.ShinyOperator_CLASS :
return new ShinyOperator(m);
case Vocabulary.DockerWebAppOperator_CLASS :
return new DockerWebAppOperator(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class WebAppOperator in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.WebAppOperator_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.WebAppOperator_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.isViewOnly_DP, isViewOnly);
return m;
}
}