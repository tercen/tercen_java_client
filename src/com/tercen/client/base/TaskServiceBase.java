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
public class TaskServiceBase extends HttpClientService<Task>{

public URI getBaseUri() { return URI.create("api/v1/task");}
String getServiceName() {return "Task";}

LinkedHashMap toJson(Task object) { return object.toJson();}
public Task fromJson(LinkedHashMap m,boolean useFactory) { if (m == null) return null; if (useFactory) return TaskBase.fromJson(m); return new Task(m);}

public List<Task> findByHash(List keys, boolean useFactory  ) throws ServiceError{
return findKeys("findByHash",keys ,useFactory );
}
public List<Task> findGCTaskByLastModifiedDate(List startKey,List endKey, int limit , int skip , boolean descending , boolean useFactory) throws ServiceError{
return findStartKeys("findGCTaskByLastModifiedDate",startKey ,endKey ,limit ,skip ,descending ,useFactory  );
}
public Object runTask(String taskId) throws ServiceError {
Object answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/task" + "/" + "runTask");
LinkedHashMap params = new LinkedHashMap();
params.put("taskId", taskId);
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

public Object cancelTask(String taskId) throws ServiceError {
Object answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/task" + "/" + "cancelTask");
LinkedHashMap params = new LinkedHashMap();
params.put("taskId", taskId);
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

public Task waitDone(String taskId) throws ServiceError {
Task answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/task" + "/" + "waitDone");
LinkedHashMap params = new LinkedHashMap();
params.put("taskId", taskId);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = TaskBase.fromJson((LinkedHashMap)jtson.decodeTSON(response.body().bytes()));
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

public Object updateWorker(Worker worker) throws ServiceError {
Object answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/task" + "/" + "updateWorker");
LinkedHashMap params = new LinkedHashMap();
params.put("worker", worker.toJson());
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

public double taskDurationByTeam(String teamId,int year,int month) throws ServiceError {
double answer = 0.0;
Response response = null;
try {
URI uri = URI.create( "api/v1/task" + "/" + "taskDurationByTeam");
LinkedHashMap params = new LinkedHashMap();
params.put("teamId", teamId);
params.put("year", year);
params.put("month", month);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = (double)((List)jtson.decodeTSON(response.body().bytes())).get(0);
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