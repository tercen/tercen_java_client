package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RenvInstalledLibraryBase extends RLibrary {

public String path;

public RenvInstalledLibraryBase(){
super();
this.path = "";
}

public RenvInstalledLibraryBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.RenvInstalledLibrary_CLASS ? m.get(Vocabulary.KIND) : null);
this.path = (String)m.get(Vocabulary.path_DP) ;
}

public static RenvInstalledLibrary createFromJson(LinkedHashMap m) {return RenvInstalledLibraryBase.fromJson(m);} 
public static RenvInstalledLibrary fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.RenvInstalledLibrary_CLASS :
return new RenvInstalledLibrary(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class RenvInstalledLibrary in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.RenvInstalledLibrary_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.RenvInstalledLibrary_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.path_DP, path);
return m;
}
}