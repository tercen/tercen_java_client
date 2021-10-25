package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class XYAxisBase extends BaseObject {

public Chart chart;
public Colors colors;
public Errors errors;
public Labels labels;
public Axis xAxis;
public Axis yAxis;
public String taskId;

public XYAxisBase(){
super();
this.taskId = "";
this.chart = new Chart();
this.colors = new Colors();
this.errors = new Errors();
this.labels = new Labels();
this.xAxis = new Axis();
this.yAxis = new Axis();
}

public XYAxisBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.XYAxis_CLASS ? m.get(Vocabulary.KIND) : null);
this.taskId = (String)m.get(Vocabulary.taskId_DP) ;
if (m.get(Vocabulary.chart_OP) == null) this.chart = new Chart();
else this.chart = ChartBase.fromJson((LinkedHashMap)m.get(Vocabulary.chart_OP) );
if (m.get(Vocabulary.colors_OP) == null) this.colors = new Colors();
else this.colors = ColorsBase.fromJson((LinkedHashMap)m.get(Vocabulary.colors_OP) );
if (m.get(Vocabulary.errors_OP) == null) this.errors = new Errors();
else this.errors = ErrorsBase.fromJson((LinkedHashMap)m.get(Vocabulary.errors_OP) );
if (m.get(Vocabulary.labels_OP) == null) this.labels = new Labels();
else this.labels = LabelsBase.fromJson((LinkedHashMap)m.get(Vocabulary.labels_OP) );
if (m.get(Vocabulary.xAxis_OP) == null) this.xAxis = new Axis();
else this.xAxis = AxisBase.fromJson((LinkedHashMap)m.get(Vocabulary.xAxis_OP) );
if (m.get(Vocabulary.yAxis_OP) == null) this.yAxis = new Axis();
else this.yAxis = AxisBase.fromJson((LinkedHashMap)m.get(Vocabulary.yAxis_OP) );
}

public static XYAxis createFromJson(LinkedHashMap m) {return XYAxisBase.fromJson(m);} 
public static XYAxis fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.XYAxis_CLASS :
return new XYAxis(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class XYAxis in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.XYAxis_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.XYAxis_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.chart_OP, chart == null ? null : chart.toJson()) ;
m.put(Vocabulary.colors_OP, colors == null ? null : colors.toJson()) ;
m.put(Vocabulary.errors_OP, errors == null ? null : errors.toJson()) ;
m.put(Vocabulary.labels_OP, labels == null ? null : labels.toJson()) ;
m.put(Vocabulary.xAxis_OP, xAxis == null ? null : xAxis.toJson()) ;
m.put(Vocabulary.yAxis_OP, yAxis == null ? null : yAxis.toJson()) ;
m.put(Vocabulary.taskId_DP, taskId);
return m;
}
}