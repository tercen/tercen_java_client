package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class XYAxisListBase extends BaseObject {

public ArrayList<Rectangle> rectangleSelections;
public ArrayList<XYAxis> xyAxis;

public XYAxisListBase(){
super();
this.rectangleSelections = new ArrayList<Rectangle>();
this.xyAxis = new ArrayList<XYAxis>();
}

public XYAxisListBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.XYAxisList_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.rectangleSelections_OP) == null)
this.rectangleSelections = new ArrayList<Rectangle>();
else {
this.rectangleSelections = new ArrayList<Rectangle>();
ArrayList list = (ArrayList)m.get(Vocabulary.rectangleSelections_OP);
for (Object map : list) {
this.rectangleSelections.add(RectangleBase.createFromJson((LinkedHashMap)map));
}
}
if (m.get(Vocabulary.xyAxis_OP) == null)
this.xyAxis = new ArrayList<XYAxis>();
else {
this.xyAxis = new ArrayList<XYAxis>();
ArrayList list = (ArrayList)m.get(Vocabulary.xyAxis_OP);
for (Object map : list) {
this.xyAxis.add(XYAxisBase.createFromJson((LinkedHashMap)map));
}
}
}

public static XYAxisList createFromJson(LinkedHashMap m) {return XYAxisListBase.fromJson(m);} 
public static XYAxisList fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.XYAxisList_CLASS :
return new XYAxisList(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class XYAxisList in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.XYAxisList_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.XYAxisList_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.rectangleSelections_OP, BaseObject.objectListToJson(rectangleSelections));
m.put(Vocabulary.xyAxis_OP, BaseObject.objectListToJson(xyAxis));
return m;
}
}