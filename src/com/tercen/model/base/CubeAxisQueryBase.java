package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CubeAxisQueryBase extends BaseObject {

public int pointSize;
public String chartType;
public Factor yAxis;
public AxisSettings yAxisSettings;
public Factor xAxis;
public AxisSettings xAxisSettings;
public ArrayList<Factor> errors;
public ArrayList<Factor> labels;
public ArrayList<Factor> colors;

public CubeAxisQueryBase(){
super();
this.pointSize = 0;
this.chartType = "";
this.yAxis = new Factor();
this.yAxisSettings = new AxisSettings();
this.xAxis = new Factor();
this.xAxisSettings = new AxisSettings();
this.errors = new ArrayList<Factor>();
this.labels = new ArrayList<Factor>();
this.colors = new ArrayList<Factor>();
}

public CubeAxisQueryBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.CubeAxisQuery_CLASS ? m.get(Vocabulary.KIND) : null);
this.pointSize = (int)m.get(Vocabulary.pointSize_DP) ;
this.chartType = (String)m.get(Vocabulary.chartType_DP) ;
if (m.get(Vocabulary.yAxis_OP) == null) this.yAxis = new Factor();
else this.yAxis = FactorBase.fromJson((LinkedHashMap)m.get(Vocabulary.yAxis_OP) );
if (m.get(Vocabulary.yAxisSettings_OP) == null) this.yAxisSettings = new AxisSettings();
else this.yAxisSettings = AxisSettingsBase.fromJson((LinkedHashMap)m.get(Vocabulary.yAxisSettings_OP) );
if (m.get(Vocabulary.xAxis_OP) == null) this.xAxis = new Factor();
else this.xAxis = FactorBase.fromJson((LinkedHashMap)m.get(Vocabulary.xAxis_OP) );
if (m.get(Vocabulary.xAxisSettings_OP) == null) this.xAxisSettings = new AxisSettings();
else this.xAxisSettings = AxisSettingsBase.fromJson((LinkedHashMap)m.get(Vocabulary.xAxisSettings_OP) );
if (m.get(Vocabulary.errors_OP) == null)
this.errors = new ArrayList<Factor>();
else {
this.errors = new ArrayList<Factor>();
ArrayList list = (ArrayList)m.get(Vocabulary.errors_OP);
for (Object map : list) {
this.errors.add(FactorBase.createFromJson((LinkedHashMap)map));
}
}
if (m.get(Vocabulary.labels_OP) == null)
this.labels = new ArrayList<Factor>();
else {
this.labels = new ArrayList<Factor>();
ArrayList list = (ArrayList)m.get(Vocabulary.labels_OP);
for (Object map : list) {
this.labels.add(FactorBase.createFromJson((LinkedHashMap)map));
}
}
if (m.get(Vocabulary.colors_OP) == null)
this.colors = new ArrayList<Factor>();
else {
this.colors = new ArrayList<Factor>();
ArrayList list = (ArrayList)m.get(Vocabulary.colors_OP);
for (Object map : list) {
this.colors.add(FactorBase.createFromJson((LinkedHashMap)map));
}
}
}

public static CubeAxisQuery createFromJson(LinkedHashMap m) {return CubeAxisQueryBase.fromJson(m);} 
public static CubeAxisQuery fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.CubeAxisQuery_CLASS :
return new CubeAxisQuery(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class CubeAxisQuery in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.CubeAxisQuery_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.CubeAxisQuery_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.pointSize_DP, pointSize);
m.put(Vocabulary.chartType_DP, chartType);
m.put(Vocabulary.yAxis_OP, yAxis == null ? null : yAxis.toJson()) ;
m.put(Vocabulary.yAxisSettings_OP, yAxisSettings == null ? null : yAxisSettings.toJson()) ;
m.put(Vocabulary.xAxis_OP, xAxis == null ? null : xAxis.toJson()) ;
m.put(Vocabulary.xAxisSettings_OP, xAxisSettings == null ? null : xAxisSettings.toJson()) ;
m.put(Vocabulary.errors_OP, BaseObject.objectListToJson(errors));
m.put(Vocabulary.labels_OP, BaseObject.objectListToJson(labels));
m.put(Vocabulary.colors_OP, BaseObject.objectListToJson(colors));
return m;
}
}