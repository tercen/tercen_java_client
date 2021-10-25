package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CreateGitOperatorTaskBase extends Task {

public Url url;
public String version;
public String operatorId;
public String gitToken;
public boolean testRequired;

public CreateGitOperatorTaskBase(){
super();
this.version = "";
this.operatorId = "";
this.gitToken = "";
this.testRequired = true;
this.url = new Url();
}

public CreateGitOperatorTaskBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.CreateGitOperatorTask_CLASS ? m.get(Vocabulary.KIND) : null);
this.version = (String)m.get(Vocabulary.version_DP) ;
this.operatorId = (String)m.get(Vocabulary.operatorId_DP) ;
this.gitToken = (String)m.get(Vocabulary.gitToken_DP) ;
this.testRequired = (boolean)m.get(Vocabulary.testRequired_DP) ;
if (m.get(Vocabulary.url_OP) == null) this.url = new Url();
else this.url = UrlBase.fromJson((LinkedHashMap)m.get(Vocabulary.url_OP) );
}

public static CreateGitOperatorTask createFromJson(LinkedHashMap m) {return CreateGitOperatorTaskBase.fromJson(m);} 
public static CreateGitOperatorTask fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.CreateGitOperatorTask_CLASS :
return new CreateGitOperatorTask(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class CreateGitOperatorTask in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.CreateGitOperatorTask_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.CreateGitOperatorTask_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.url_OP, url == null ? null : url.toJson()) ;
m.put(Vocabulary.version_DP, version);
m.put(Vocabulary.operatorId_DP, operatorId);
m.put(Vocabulary.gitToken_DP, gitToken);
m.put(Vocabulary.testRequired_DP, testRequired);
return m;
}
}