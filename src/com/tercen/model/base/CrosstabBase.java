package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CrosstabBase extends StepModel {

public XYAxisList axis;
public CrosstabTable columnTable;
public Filters filters;
public OperatorSettings operatorSettings;
public CrosstabTable rowTable;
public String taskId;

public CrosstabBase(){
super();
this.taskId = "";
this.axis = new XYAxisList();
this.columnTable = new CrosstabTable();
this.filters = new Filters();
this.operatorSettings = new OperatorSettings();
this.rowTable = new CrosstabTable();
}

public CrosstabBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.Crosstab_CLASS ? m.get(Vocabulary.KIND) : null);
this.taskId = (String)m.get(Vocabulary.taskId_DP) ;
if (m.get(Vocabulary.axis_OP) == null) this.axis = new XYAxisList();
else this.axis = XYAxisListBase.fromJson((LinkedHashMap)m.get(Vocabulary.axis_OP) );
if (m.get(Vocabulary.columnTable_OP) == null) this.columnTable = new CrosstabTable();
else this.columnTable = CrosstabTableBase.fromJson((LinkedHashMap)m.get(Vocabulary.columnTable_OP) );
if (m.get(Vocabulary.filters_OP) == null) this.filters = new Filters();
else this.filters = FiltersBase.fromJson((LinkedHashMap)m.get(Vocabulary.filters_OP) );
if (m.get(Vocabulary.operatorSettings_OP) == null) this.operatorSettings = new OperatorSettings();
else this.operatorSettings = OperatorSettingsBase.fromJson((LinkedHashMap)m.get(Vocabulary.operatorSettings_OP) );
if (m.get(Vocabulary.rowTable_OP) == null) this.rowTable = new CrosstabTable();
else this.rowTable = CrosstabTableBase.fromJson((LinkedHashMap)m.get(Vocabulary.rowTable_OP) );
}

public static Crosstab createFromJson(LinkedHashMap m) {return CrosstabBase.fromJson(m);} 
public static Crosstab fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.Crosstab_CLASS :
return new Crosstab(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class Crosstab in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.Crosstab_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.Crosstab_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.axis_OP, axis == null ? null : axis.toJson()) ;
m.put(Vocabulary.columnTable_OP, columnTable == null ? null : columnTable.toJson()) ;
m.put(Vocabulary.filters_OP, filters == null ? null : filters.toJson()) ;
m.put(Vocabulary.operatorSettings_OP, operatorSettings == null ? null : operatorSettings.toJson()) ;
m.put(Vocabulary.rowTable_OP, rowTable == null ? null : rowTable.toJson()) ;
m.put(Vocabulary.taskId_DP, taskId);
return m;
}
}