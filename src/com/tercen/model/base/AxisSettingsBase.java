package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class AxisSettingsBase extends BaseObject {

public ArrayList<Property> properties;
public ArrayList<PropertyValue> propertyValues;

public AxisSettingsBase(){
super();
this.properties = new ArrayList<Property>();
this.propertyValues = new ArrayList<PropertyValue>();
}

public AxisSettingsBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.AxisSettings_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.properties_OP) == null)
this.properties = new ArrayList<Property>();
else {
this.properties = new ArrayList<Property>();
ArrayList list = (ArrayList)m.get(Vocabulary.properties_OP);
for (Object map : list) {
this.properties.add(PropertyBase.createFromJson((LinkedHashMap)map));
}
}
if (m.get(Vocabulary.propertyValues_OP) == null)
this.propertyValues = new ArrayList<PropertyValue>();
else {
this.propertyValues = new ArrayList<PropertyValue>();
ArrayList list = (ArrayList)m.get(Vocabulary.propertyValues_OP);
for (Object map : list) {
this.propertyValues.add(PropertyValueBase.createFromJson((LinkedHashMap)map));
}
}
}

public static AxisSettings createFromJson(LinkedHashMap m) {return AxisSettingsBase.fromJson(m);} 
public static AxisSettings fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.AxisSettings_CLASS :
return new AxisSettings(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class AxisSettings in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.AxisSettings_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.AxisSettings_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.properties_OP, BaseObject.objectListToJson(properties));
m.put(Vocabulary.propertyValues_OP, BaseObject.objectListToJson(propertyValues));
return m;
}
}