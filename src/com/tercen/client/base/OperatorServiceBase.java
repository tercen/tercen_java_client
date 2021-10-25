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
public class OperatorServiceBase extends HttpClientService<Operator>{

public URI getBaseUri() { return URI.create("api/v1/operator");}
String getServiceName() {return "Operator";}

LinkedHashMap toJson(Operator object) { return object.toJson();}
public Operator fromJson(LinkedHashMap m,boolean useFactory) { if (m == null) return null; if (useFactory) return OperatorBase.fromJson(m); return new Operator(m);}

}