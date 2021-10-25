package com.tercen.model.base;
import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class CSVParserParamBase extends BaseObject {

public String separator;
public String encoding;
public String quote;
public boolean hasHeaders;
public boolean allowMalformed;
public String comment;

public CSVParserParamBase(){
super();
this.separator = "";
this.encoding = "";
this.quote = "";
this.hasHeaders = true;
this.allowMalformed = true;
this.comment = "";
}

public CSVParserParamBase(LinkedHashMap m){
super(m);
this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String)m.get(Vocabulary.SUBKIND)   : (String)(m.get(Vocabulary.KIND) != Vocabulary.CSVParserParam_CLASS ? m.get(Vocabulary.KIND) : null);
this.separator = (String)m.get(Vocabulary.separator_DP) ;
this.encoding = (String)m.get(Vocabulary.encoding_DP) ;
this.quote = (String)m.get(Vocabulary.quote_DP) ;
this.hasHeaders = (boolean)m.get(Vocabulary.hasHeaders_DP) ;
this.allowMalformed = (boolean)m.get(Vocabulary.allowMalformed_DP) ;
this.comment = (String)m.get(Vocabulary.comment_DP) ;
}

public static CSVParserParam createFromJson(LinkedHashMap m) {return CSVParserParamBase.fromJson(m);} 
public static CSVParserParam fromJson(LinkedHashMap m) {String kind = (String)m.get(Vocabulary.KIND);
switch (kind) {
case Vocabulary.CSVParserParam_CLASS :
return new CSVParserParam(m);
default : throw new IllegalArgumentException(  "bad kind : " + kind +" for class CSVParserParam in fromJson constructor");
}
}

public LinkedHashMap toJson() {
LinkedHashMap m = super.toJson();m.put(Vocabulary.KIND, Vocabulary.CSVParserParam_CLASS);
if (this.subKind != null && this.subKind != Vocabulary.CSVParserParam_CLASS) m.put(Vocabulary.SUBKIND, this.subKind);
else m.remove(Vocabulary.SUBKIND);
m.put(Vocabulary.separator_DP, separator);
m.put(Vocabulary.encoding_DP, encoding);
m.put(Vocabulary.quote_DP, quote);
m.put(Vocabulary.hasHeaders_DP, hasHeaders);
m.put(Vocabulary.allowMalformed_DP, allowMalformed);
m.put(Vocabulary.comment_DP, comment);
return m;
}
}