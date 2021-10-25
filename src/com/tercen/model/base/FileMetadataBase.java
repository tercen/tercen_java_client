package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class FileMetadataBase extends BaseObject {

public String contentType;
public String cacheControl;
public String contentEncoding;
public String contentLanguage;
public String md5Hash;

public FileMetadataBase(){
super();
this.contentType = "";
this.cacheControl = "";
this.contentEncoding = "";
this.contentLanguage = "";
this.md5Hash = "";
}

public FileMetadataBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.FileMetadata_CLASS ? m.get(Vocabulary.KIND) : null);
this.contentType = (String)m.get(Vocabulary.contentType_DP) ;
this.cacheControl = (String)m.get(Vocabulary.cacheControl_DP) ;
this.contentEncoding = (String)m.get(Vocabulary.contentEncoding_DP) ;
this.contentLanguage = (String)m.get(Vocabulary.contentLanguage_DP) ;
this.md5Hash = (String)m.get(Vocabulary.md5Hash_DP) ;
}

public static FileMetadata createFromJson(LinkedHashMap m) {return FileMetadataBase.fromJson(m);} 
public static FileMetadata fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.FileMetadata_CLASS :
return new FileMetadata(m);
case Vocabulary.CSVFileMetadata_CLASS :
return new CSVFileMetadata(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class FileMetadata in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.FileMetadata_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.FileMetadata_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.contentType_DP, contentType);
m.put(Vocabulary.cacheControl_DP, cacheControl);
m.put(Vocabulary.contentEncoding_DP, contentEncoding);
m.put(Vocabulary.contentLanguage_DP, contentLanguage);
m.put(Vocabulary.md5Hash_DP, md5Hash);
return m;
}
}