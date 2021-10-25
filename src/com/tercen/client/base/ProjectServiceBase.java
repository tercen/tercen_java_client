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
public class ProjectServiceBase extends HttpClientService<Project>{

public URI getBaseUri() { return URI.create("api/v1/project");}
String getServiceName() {return "Project";}

LinkedHashMap toJson(Project object) { return object.toJson();}
public Project fromJson(LinkedHashMap m,boolean useFactory) { if (m == null) return null; if (useFactory) return ProjectBase.fromJson(m); return new Project(m);}

public List<Project> findByIsPublicAndLastModifiedDate(List startKey,List endKey, int limit , int skip , boolean descending , boolean useFactory) throws ServiceError{
return findStartKeys("findByIsPublicAndLastModifiedDate",startKey ,endKey ,limit ,skip ,descending ,useFactory  );
}
public List<Project> findByTeamAndIsPublicAndLastModifiedDate(List startKey,List endKey, int limit , int skip , boolean descending , boolean useFactory) throws ServiceError{
return findStartKeys("findByTeamAndIsPublicAndLastModifiedDate",startKey ,endKey ,limit ,skip ,descending ,useFactory  );
}
public Profiles profiles(String projectId) throws ServiceError {
Profiles answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/project" + "/" + "profiles");
LinkedHashMap params = new LinkedHashMap();
params.put("projectId", projectId);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = ProfilesBase.fromJson((LinkedHashMap)jtson.decodeTSON(response.body().bytes()));
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

public ResourceSummary resourceSummary(String projectId) throws ServiceError {
ResourceSummary answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/project" + "/" + "resourceSummary");
LinkedHashMap params = new LinkedHashMap();
params.put("projectId", projectId);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = ResourceSummaryBase.fromJson((LinkedHashMap)jtson.decodeTSON(response.body().bytes()));
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

public List<Project> explore(String category,int start,int limit) throws ServiceError {
List<Project> answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/project" + "/" + "explore");
LinkedHashMap params = new LinkedHashMap();
params.put("category", category);
params.put("start", start);
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

public List<Project> recentProjects(String userId) throws ServiceError {
List<Project> answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/project" + "/" + "recentProjects");
LinkedHashMap params = new LinkedHashMap();
params.put("userId", userId);
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

public Project cloneProject(String projectId,Project project) throws ServiceError {
Project answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/project" + "/" + "cloneProject");
LinkedHashMap params = new LinkedHashMap();
params.put("projectId", projectId);
params.put("project", project.toJson());
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = ProjectBase.fromJson((LinkedHashMap)jtson.decodeTSON(response.body().bytes()));
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