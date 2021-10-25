package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class UserBase extends Document {

public String email;
public boolean isValidated;
public String domain;
public ArrayList<String> roles;
public Acl teamAcl;
public String invitedByUsername;
public int invitationCounts;
public int maxInvitation;
public BillingInfo billingInfo;

public UserBase(){
super();
this.email = "";
this.isValidated = true;
this.domain = "";
this.roles = new ArrayList<String>();
this.invitedByUsername = "";
this.invitationCounts = 0;
this.maxInvitation = 0;
this.teamAcl = new Acl();
this.billingInfo = new BillingInfo();
}

public UserBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.User_CLASS ? m.get(Vocabulary.KIND) : null);
this.email = (String)m.get(Vocabulary.email_DP) ;
this.isValidated = (boolean)m.get(Vocabulary.isValidated_DP) ;
this.domain = (String)m.get(Vocabulary.domain_DP) ;
this.roles = new ArrayList<String>( (Collection<? extends String>)(m.get(Vocabulary.roles_DP) ) );
this.invitedByUsername = (String)m.get(Vocabulary.invitedByUsername_DP) ;
this.invitationCounts = (int)m.get(Vocabulary.invitationCounts_DP) ;
this.maxInvitation = (int)m.get(Vocabulary.maxInvitation_DP) ;
if (m.get(Vocabulary.teamAcl_OP) == null) this.teamAcl = new Acl();
else this.teamAcl = AclBase.fromJson((LinkedHashMap)m.get(Vocabulary.teamAcl_OP) );
if (m.get(Vocabulary.billingInfo_OP) == null) this.billingInfo = new BillingInfo();
else this.billingInfo = BillingInfoBase.fromJson((LinkedHashMap)m.get(Vocabulary.billingInfo_OP) );
}

public static User createFromJson(LinkedHashMap m) {return UserBase.fromJson(m);} 
public static User fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.User_CLASS :
return new User(m);
case Vocabulary.Team_CLASS :
return new Team(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class User in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.User_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.User_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.email_DP, email);
m.put(Vocabulary.isValidated_DP, isValidated);
m.put(Vocabulary.domain_DP, domain);
m.put(Vocabulary.roles_DP, roles);
m.put(Vocabulary.teamAcl_OP, teamAcl == null ? null : teamAcl.toJson()) ;
m.put(Vocabulary.invitedByUsername_DP, invitedByUsername);
m.put(Vocabulary.invitationCounts_DP, invitationCounts);
m.put(Vocabulary.maxInvitation_DP, maxInvitation);
m.put(Vocabulary.billingInfo_OP, billingInfo == null ? null : billingInfo.toJson()) ;
return m;
}
}