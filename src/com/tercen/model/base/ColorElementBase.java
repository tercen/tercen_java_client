package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ColorElementBase extends BaseObject {

public int color;

public ColorElementBase(){
super();
this.color = 0;
}

public ColorElementBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.ColorElement_CLASS ? m.get(Vocabulary.KIND) : null);
this.color = (int)m.get(Vocabulary.color_DP) ;
}

public static ColorElement createFromJson(LinkedHashMap m) {return ColorElementBase.fromJson(m);} 
public static ColorElement fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.ColorElement_CLASS :
return new ColorElement(m);
case Vocabulary.DoubleColorElement_CLASS :
return new DoubleColorElement(m);
case Vocabulary.StringColorElement_CLASS :
return new StringColorElement(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class ColorElement in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.ColorElement_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.ColorElement_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.color_DP, color);
return m;
}
}