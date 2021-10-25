package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class FilterTopExprBase extends BaseObject {


public FilterTopExprBase(){
super();
}

public FilterTopExprBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.FilterTopExpr_CLASS ? m.get(Vocabulary.KIND) : null);
}

public static FilterTopExpr createFromJson(LinkedHashMap m) {return FilterTopExprBase.fromJson(m);} 
public static FilterTopExpr fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.FilterTopExpr_CLASS :
return new FilterTopExpr(m);
case Vocabulary.NamedFilter_CLASS :
return new NamedFilter(m);
case Vocabulary.Filter_CLASS :
return new Filter(m);
case Vocabulary.FilterExpr_CLASS :
return new FilterExpr(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class FilterTopExpr in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.FilterTopExpr_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.FilterTopExpr_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
return m;
}
}