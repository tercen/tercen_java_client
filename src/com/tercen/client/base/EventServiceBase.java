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
public class EventServiceBase extends HttpClientService<Event>{

public URI getBaseUri() { return URI.create("api/v1/evt");}
String getServiceName() {return "Event";}

LinkedHashMap toJson(Event object) { return object.toJson();}
public Event fromJson(LinkedHashMap m,boolean useFactory) { if (m == null) return null; if (useFactory) return EventBase.fromJson(m); return new Event(m);}

public Object sendChannel(String channel,Event evt) throws ServiceError {
Object answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/evt" + "/" + "sendChannel");
LinkedHashMap params = new LinkedHashMap();
params.put("channel", channel);
params.put("evt", evt.toJson());
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = null;
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

public int taskListenerCount(String taskId) throws ServiceError {
int answer = 0;
Response response = null;
try {
URI uri = URI.create( "api/v1/evt" + "/" + "taskListenerCount");
LinkedHashMap params = new LinkedHashMap();
params.put("taskId", taskId);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = (int)((List)jtson.decodeTSON(response.body().bytes())).get(0);
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