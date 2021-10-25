package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class UserSecretBase extends PersistentObject {

public String userId;
public String salt;
public String hashPassword;

public UserSecretBase(){
super();
this.userId = "";
this.salt = "";
this.hashPassword = "";
}

public UserSecretBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.UserSecret_CLASS ? m.get(Vocabulary.KIND) : null);
this.userId = (String)m.get(Vocabulary.userId_DP) ;
this.salt = (String)m.get(Vocabulary.salt_DP) ;
this.hashPassword = (String)m.get(Vocabulary.hashPassword_DP) ;
}

public static UserSecret createFromJson(LinkedHashMap m) {return UserSecretBase.fromJson(m);} 
public static UserSecret fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.UserSecret_CLASS :
return new UserSecret(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class UserSecret in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.UserSecret_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.UserSecret_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.userId_DP, userId);
m.put(Vocabulary.salt_DP, salt);
m.put(Vocabulary.hashPassword_DP, hashPassword);
return m;
}
}