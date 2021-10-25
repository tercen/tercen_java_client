package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class FileDocumentBase extends ProjectDocument {

public String dataUri;
public FileMetadata metadata;
public int size;

public FileDocumentBase(){
super();
this.dataUri = "";
this.size = 0;
this.metadata = new FileMetadata();
}

public FileDocumentBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.FileDocument_CLASS ? m.get(Vocabulary.KIND) : null);
this.dataUri = (String)m.get(Vocabulary.dataUri_DP) ;
this.size = (int)m.get(Vocabulary.size_DP) ;
if (m.get(Vocabulary.metadata_OP) == null) this.metadata = new FileMetadata();
else this.metadata = FileMetadataBase.fromJson((LinkedHashMap)m.get(Vocabulary.metadata_OP) );
}

public static FileDocument createFromJson(LinkedHashMap m) {return FileDocumentBase.fromJson(m);} 
public static FileDocument fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.FileDocument_CLASS :
return new FileDocument(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class FileDocument in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.FileDocument_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.FileDocument_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.dataUri_DP, dataUri);
m.put(Vocabulary.metadata_OP, metadata == null ? null : metadata.toJson()) ;
m.put(Vocabulary.size_DP, size);
return m;
}
}