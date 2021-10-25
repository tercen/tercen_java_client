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
public class ActivityServiceBase extends HttpClientService<Activity>{

public URI getBaseUri() { return URI.create("api/v1/activity");}
String getServiceName() {return "Activity";}

LinkedHashMap toJson(Activity object) { return object.toJson();}
public Activity fromJson(LinkedHashMap m,boolean useFactory) { if (m == null) return null; if (useFactory) return ActivityBase.fromJson(m); return new Activity(m);}

public List<Activity> findByUserAndDate(List startKey,List endKey, int limit , int skip , boolean descending , boolean useFactory) throws ServiceError{
return findStartKeys("findByUserAndDate",startKey ,endKey ,limit ,skip ,descending ,useFactory  );
}
public List<Activity> findByTeamAndDate(List startKey,List endKey, int limit , int skip , boolean descending , boolean useFactory) throws ServiceError{
return findStartKeys("findByTeamAndDate",startKey ,endKey ,limit ,skip ,descending ,useFactory  );
}
public List<Activity> findByProjectAndDate(List startKey,List endKey, int limit , int skip , boolean descending , boolean useFactory) throws ServiceError{
return findStartKeys("findByProjectAndDate",startKey ,endKey ,limit ,skip ,descending ,useFactory  );
}
public List<ActivityCount> getPublicActivityCount(String kind,int limit) throws ServiceError {
List<ActivityCount> answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/activity" + "/" + "getPublicActivityCount");
LinkedHashMap params = new LinkedHashMap();
params.put("kind", kind);
params.put("limit", limit);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = null ; // not impl
}
} catch (Exception e) {
      onError(e);
    } 
    finally {
      if (response != null){
        response.close();
      }
    }  
return  answer;
}

}