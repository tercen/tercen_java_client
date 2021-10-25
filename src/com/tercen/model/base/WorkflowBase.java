package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class WorkflowBase extends ProjectDocument {

public ArrayList<Link> links;
public ArrayList<Step> steps;
public Point offset;

public WorkflowBase(){
super();
this.links = new ArrayList<Link>();
this.steps = new ArrayList<Step>();
this.offset = new Point();
}

public WorkflowBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.Workflow_CLASS ? m.get(Vocabulary.KIND) : null);
if (m.get(Vocabulary.links_OP) == null)
this.links = new ArrayList<Link>();
else {
this.links = new ArrayList<Link>();
ArrayList list = (ArrayList)m.get(Vocabulary.links_OP);
for (Object map : list) {
this.links.add(LinkBase.createFromJson((LinkedHashMap)map));
}
}
if (m.get(Vocabulary.steps_OP) == null)
this.steps = new ArrayList<Step>();
else {
this.steps = new ArrayList<Step>();
ArrayList list = (ArrayList)m.get(Vocabulary.steps_OP);
for (Object map : list) {
this.steps.add(StepBase.createFromJson((LinkedHashMap)map));
}
}
if (m.get(Vocabulary.offset_OP) == null) this.offset = new Point();
else this.offset = PointBase.fromJson((LinkedHashMap)m.get(Vocabulary.offset_OP) );
}

public static Workflow createFromJson(LinkedHashMap m) {return WorkflowBase.fromJson(m);} 
public static Workflow fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.Workflow_CLASS :
return new Workflow(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class Workflow in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.Workflow_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.Workflow_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.links_OP, BaseObject.objectListToJson(links));
m.put(Vocabulary.steps_OP, BaseObject.objectListToJson(steps));
m.put(Vocabulary.offset_OP, offset == null ? null : offset.toJson()) ;
return m;
}
}