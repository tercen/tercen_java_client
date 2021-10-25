package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class TeamBase extends User {


public TeamBase(){
super();
}

public TeamBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.Team_CLASS ? m.get(Vocabulary.KIND) : null);
}

public static Team createFromJson(LinkedHashMap m) {return TeamBase.fromJson(m);} 
public static Team fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.Team_CLASS :
return new Team(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class Team in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.Team_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.Team_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
return m;
}
}