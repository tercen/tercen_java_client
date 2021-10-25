package com.tercen.client.base;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import com.tercen.service.ServiceError;
import tercen.tson.*;
import com.tercen.service.HttpClientService;
import com.tercen.model.base.*;
import com.tercen.model.impl.*;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
public class FileServiceBase extends HttpClientService<FileDocument>{

public URI getBaseUri() { return URI.create("api/v1/file");}
String getServiceName() {return "FileDocument";}

LinkedHashMap toJson(FileDocument object) { return object.toJson();}
public FileDocument fromJson(LinkedHashMap m,boolean useFactory) { if (m == null) return null; if (useFactory) return FileDocumentBase.fromJson(m); return new FileDocument(m);}

public List<FileDocument> findFileByWorkflowIdAndStepId(List startKey,List endKey, int limit , int skip , boolean descending , boolean useFactory) throws ServiceError{
return findStartKeys("findFileByWorkflowIdAndStepId",startKey ,endKey ,limit ,skip ,descending ,useFactory  );
}
public List<FileDocument> findFileByTaskId(List startKey,List endKey, int limit , int skip , boolean descending , boolean useFactory) throws ServiceError{
return findStartKeys("findFileByTaskId",startKey ,endKey ,limit ,skip ,descending ,useFactory  );
}
public List<FileDocument> findByDataUri(List startKey,List endKey, int limit , int skip , boolean descending , boolean useFactory) throws ServiceError{
return findStartKeys("findByDataUri",startKey ,endKey ,limit ,skip ,descending ,useFactory  );
}
}