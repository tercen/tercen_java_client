package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class BillingInfoBase extends BaseObject {

public String firstName;
public String lastName;
public String companyName;
public TaxId taxId;
public Address address;

public BillingInfoBase(){
super();
this.firstName = "";
this.lastName = "";
this.companyName = "";
this.taxId = new TaxId();
this.address = new Address();
}

public BillingInfoBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.BillingInfo_CLASS ? m.get(Vocabulary.KIND) : null);
this.firstName = (String)m.get(Vocabulary.firstName_DP) ;
this.lastName = (String)m.get(Vocabulary.lastName_DP) ;
this.companyName = (String)m.get(Vocabulary.companyName_DP) ;
if (m.get(Vocabulary.taxId_OP) == null) this.taxId = new TaxId();
else this.taxId = TaxIdBase.fromJson((LinkedHashMap)m.get(Vocabulary.taxId_OP) );
if (m.get(Vocabulary.address_OP) == null) this.address = new Address();
else this.address = AddressBase.fromJson((LinkedHashMap)m.get(Vocabulary.address_OP) );
}

public static BillingInfo createFromJson(LinkedHashMap m) {return BillingInfoBase.fromJson(m);} 
public static BillingInfo fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.BillingInfo_CLASS :
return new BillingInfo(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class BillingInfo in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.BillingInfo_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.BillingInfo_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.firstName_DP, firstName);
m.put(Vocabulary.lastName_DP, lastName);
m.put(Vocabulary.companyName_DP, companyName);
m.put(Vocabulary.taxId_OP, taxId == null ? null : taxId.toJson()) ;
m.put(Vocabulary.address_OP, address == null ? null : address.toJson()) ;
return m;
}
}