package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class RDescriptionBase extends BaseObject {

public String Package;
public String Version;
public String Depends;
public String Imports;
public String LinkingTo;
public String Suggests;
public String License;
public String MD5sum;
public String NeedsCompilation;

public RDescriptionBase(){
super();
this.Package = "";
this.Version = "";
this.Depends = "";
this.Imports = "";
this.LinkingTo = "";
this.Suggests = "";
this.License = "";
this.MD5sum = "";
this.NeedsCompilation = "";
}

public RDescriptionBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.RDescription_CLASS ? m.get(Vocabulary.KIND) : null);
this.Package = (String)m.get(Vocabulary.Package_DP) ;
this.Version = (String)m.get(Vocabulary.Version_DP) ;
this.Depends = (String)m.get(Vocabulary.Depends_DP) ;
this.Imports = (String)m.get(Vocabulary.Imports_DP) ;
this.LinkingTo = (String)m.get(Vocabulary.LinkingTo_DP) ;
this.Suggests = (String)m.get(Vocabulary.Suggests_DP) ;
this.License = (String)m.get(Vocabulary.License_DP) ;
this.MD5sum = (String)m.get(Vocabulary.MD5sum_DP) ;
this.NeedsCompilation = (String)m.get(Vocabulary.NeedsCompilation_DP) ;
}

public static RDescription createFromJson(LinkedHashMap m) {return RDescriptionBase.fromJson(m);} 
public static RDescription fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.RDescription_CLASS :
return new RDescription(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class RDescription in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.RDescription_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.RDescription_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.Package_DP, Package);
m.put(Vocabulary.Version_DP, Version);
m.put(Vocabulary.Depends_DP, Depends);
m.put(Vocabulary.Imports_DP, Imports);
m.put(Vocabulary.LinkingTo_DP, LinkingTo);
m.put(Vocabulary.Suggests_DP, Suggests);
m.put(Vocabulary.License_DP, License);
m.put(Vocabulary.MD5sum_DP, MD5sum);
m.put(Vocabulary.NeedsCompilation_DP, NeedsCompilation);
return m;
}
}