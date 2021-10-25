package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CSVFileMetadataBase extends FileMetadata {

public String separator;
public String quote;
public boolean headers;

public CSVFileMetadataBase(){
super();
this.separator = "";
this.quote = "";
this.headers = true;
}

public CSVFileMetadataBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.CSVFileMetadata_CLASS ? m.get(Vocabulary.KIND) : null);
this.separator = (String)m.get(Vocabulary.separator_DP) ;
this.quote = (String)m.get(Vocabulary.quote_DP) ;
this.headers = (boolean)m.get(Vocabulary.headers_DP) ;
}

public static CSVFileMetadata createFromJson(LinkedHashMap m) {return CSVFileMetadataBase.fromJson(m);} 
public static CSVFileMetadata fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.CSVFileMetadata_CLASS :
return new CSVFileMetadata(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class CSVFileMetadata in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.CSVFileMetadata_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.CSVFileMetadata_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.separator_DP, separator);
m.put(Vocabulary.quote_DP, quote);
m.put(Vocabulary.headers_DP, headers);
return m;
}
}