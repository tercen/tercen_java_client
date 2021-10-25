package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class ImportGitWorkflowTaskBase extends ProjectTask {

public Url url;
public String version;
public String workflowId;
public String gitToken;

public ImportGitWorkflowTaskBase(){
super();
this.version = "";
this.workflowId = "";
this.gitToken = "";
this.url = new Url();
}

public ImportGitWorkflowTaskBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.ImportGitWorkflowTask_CLASS ? m.get(Vocabulary.KIND) : null);
this.version = (String)m.get(Vocabulary.version_DP) ;
this.workflowId = (String)m.get(Vocabulary.workflowId_DP) ;
this.gitToken = (String)m.get(Vocabulary.gitToken_DP) ;
if (m.get(Vocabulary.url_OP) == null) this.url = new Url();
else this.url = UrlBase.fromJson((LinkedHashMap)m.get(Vocabulary.url_OP) );
}

public static ImportGitWorkflowTask createFromJson(LinkedHashMap m) {return ImportGitWorkflowTaskBase.fromJson(m);} 
public static ImportGitWorkflowTask fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.ImportGitWorkflowTask_CLASS :
return new ImportGitWorkflowTask(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class ImportGitWorkflowTask in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.ImportGitWorkflowTask_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.ImportGitWorkflowTask_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.url_OP, url == null ? null : url.toJson()) ;
m.put(Vocabulary.version_DP, version);
m.put(Vocabulary.workflowId_DP, workflowId);
m.put(Vocabulary.gitToken_DP, gitToken);
return m;
}
}