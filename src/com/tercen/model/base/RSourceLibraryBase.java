package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RSourceLibraryBase extends RLibrary {

public String fileId;

public RSourceLibraryBase(){
super();
this.fileId = "";
}

public RSourceLibraryBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.RSourceLibrary_CLASS ? m.get(Vocabulary.KIND) : null);
this.fileId = (String)m.get(Vocabulary.fileId_DP) ;
}

public static RSourceLibrary createFromJson(LinkedHashMap m) {return RSourceLibraryBase.fromJson(m);} 
public static RSourceLibrary fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.RSourceLibrary_CLASS :
return new RSourceLibrary(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class RSourceLibrary in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.RSourceLibrary_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.RSourceLibrary_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.fileId_DP, fileId);
return m;
}
}