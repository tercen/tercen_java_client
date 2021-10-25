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
public class TeamServiceBase extends HttpClientService<Team>{

public URI getBaseUri() { return URI.create("api/v1/team");}
String getServiceName() {return "Team";}

LinkedHashMap toJson(Team object) { return object.toJson();}
public Team fromJson(LinkedHashMap m,boolean useFactory) { if (m == null) return null; if (useFactory) return TeamBase.fromJson(m); return new Team(m);}

public List<Team> findTeamByNameByLastModifiedDate(List startKey,List endKey, int limit , int skip , boolean descending , boolean useFactory) throws ServiceError{
return findStartKeys("findTeamByNameByLastModifiedDate",startKey ,endKey ,limit ,skip ,descending ,useFactory  );
}
public List<Team> findTeamByOwner(List keys, boolean useFactory  ) throws ServiceError{
return findKeys("teamByOwner",keys ,useFactory );
}
public List<Team> findTeamByName(List keys, boolean useFactory  ) throws ServiceError{
return findKeys("teamByName",keys ,useFactory );
}
public Profiles profiles(String teamId) throws ServiceError {
Profiles answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/team" + "/" + "profiles");
LinkedHashMap params = new LinkedHashMap();
params.put("teamId", teamId);
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

public ResourceSummary resourceSummary(String teamId) throws ServiceError {
ResourceSummary answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/team" + "/" + "resourceSummary");
LinkedHashMap params = new LinkedHashMap();
params.put("teamId", teamId);
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

}