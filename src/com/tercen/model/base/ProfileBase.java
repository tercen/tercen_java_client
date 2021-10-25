package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ProfileBase extends BaseObject {

public String name;

public ProfileBase(){
super();
this.name = "";
}

public ProfileBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.Profile_CLASS ? m.get(Vocabulary.KIND) : null);
this.name = (String)m.get(Vocabulary.name_DP) ;
}

public static Profile createFromJson(LinkedHashMap m) {return ProfileBase.fromJson(m);} 
public static Profile fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.Profile_CLASS :
return new Profile(m);
case Vocabulary.StorageProfile_CLASS :
return new StorageProfile(m);
case Vocabulary.RunProfile_CLASS :
return new RunProfile(m);
case Vocabulary.CpuTimeProfile_CLASS :
return new CpuTimeProfile(m);
case Vocabulary.TableProfile_CLASS :
return new TableProfile(m);
case Vocabulary.ApiCallProfile_CLASS :
return new ApiCallProfile(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class Profile in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.Profile_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.Profile_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.name_DP, name);
return m;
}
}