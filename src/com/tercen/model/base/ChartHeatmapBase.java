package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ChartHeatmapBase extends Chart {


public ChartHeatmapBase(){
super();
}

public ChartHeatmapBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.ChartHeatmap_CLASS ? m.get(Vocabulary.KIND) : null);
}

public static ChartHeatmap createFromJson(LinkedHashMap m) {return ChartHeatmapBase.fromJson(m);} 
public static ChartHeatmap fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.ChartHeatmap_CLASS :
return new ChartHeatmap(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class ChartHeatmap in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.ChartHeatmap_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.ChartHeatmap_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
return m;
}
}