package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ChartSizeBase extends Chart {

public int pointSize;

public ChartSizeBase(){
super();
this.pointSize = 0;
}

public ChartSizeBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.ChartSize_CLASS ? m.get(Vocabulary.KIND) : null);
this.pointSize = (int)m.get(Vocabulary.pointSize_DP) ;
}

public static ChartSize createFromJson(LinkedHashMap m) {return ChartSizeBase.fromJson(m);} 
public static ChartSize fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.ChartSize_CLASS :
return new ChartSize(m);
case Vocabulary.ChartLine_CLASS :
return new ChartLine(m);
case Vocabulary.ChartPoint_CLASS :
return new ChartPoint(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class ChartSize in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.ChartSize_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.ChartSize_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.pointSize_DP, pointSize);
return m;
}
}