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
public class UserServiceBase extends HttpClientService<User>{

public URI getBaseUri() { return URI.create("api/v1/user");}
String getServiceName() {return "User";}

LinkedHashMap toJson(User object) { return object.toJson();}
public User fromJson(LinkedHashMap m,boolean useFactory) { if (m == null) return null; if (useFactory) return UserBase.fromJson(m); return new User(m);}

public List<User> findUserByCreatedDateAndName(List startKey,List endKey, int limit , int skip , boolean descending , boolean useFactory) throws ServiceError{
return findStartKeys("findUserByCreatedDateAndName",startKey ,endKey ,limit ,skip ,descending ,useFactory  );
}
public List<User> findUserByName(List keys, boolean useFactory  ) throws ServiceError{
return findKeys("userByName",keys ,useFactory );
}
public List<User> findUserByEmail(List keys, boolean useFactory  ) throws ServiceError{
return findKeys("userByEmail",keys ,useFactory );
}
public List<User> findTeamMembers(List keys, boolean useFactory  ) throws ServiceError{
return findKeys("teamMembers",keys ,useFactory );
}
public Object cookieConsent(String dummy) throws ServiceError {
Object answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "cookieConsent");
LinkedHashMap params = new LinkedHashMap();
params.put("dummy", dummy);
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

public UserSession connect(String usernameOrEmail,String password) throws ServiceError {
UserSession answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "connect");
LinkedHashMap params = new LinkedHashMap();
params.put("usernameOrEmail", usernameOrEmail);
params.put("password", password);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = UserSessionBase.fromJson((LinkedHashMap)jtson.decodeTSON(response.body().bytes()));
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

public UserSession connect2(String domain,String usernameOrEmail,String password) throws ServiceError {
UserSession answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "connect2");
LinkedHashMap params = new LinkedHashMap();
params.put("domain", domain);
params.put("usernameOrEmail", usernameOrEmail);
params.put("password", password);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = UserSessionBase.fromJson((LinkedHashMap)jtson.decodeTSON(response.body().bytes()));
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

public User createUser(User user,String password) throws ServiceError {
User answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "createUser");
LinkedHashMap params = new LinkedHashMap();
params.put("user", user.toJson());
params.put("password", password);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = UserBase.fromJson((LinkedHashMap)jtson.decodeTSON(response.body().bytes()));
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

public boolean hasUserName(String username) throws ServiceError {
boolean answer = true;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "hasUserName");
LinkedHashMap params = new LinkedHashMap();
params.put("username", username);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = (boolean)((List)jtson.decodeTSON(response.body().bytes())).get(0);
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

public Object updatePassword(String userId,String password) throws ServiceError {
Object answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "updatePassword");
LinkedHashMap params = new LinkedHashMap();
params.put("userId", userId);
params.put("password", password);
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

public BillingInfo updateBillingInfo(String userId,BillingInfo billingInfo) throws ServiceError {
BillingInfo answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "updateBillingInfo");
LinkedHashMap params = new LinkedHashMap();
params.put("userId", userId);
params.put("billingInfo", billingInfo.toJson());
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = BillingInfoBase.fromJson((LinkedHashMap)jtson.decodeTSON(response.body().bytes()));
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

public ViesInfo viesInfo(String country_code,String vatNumber) throws ServiceError {
ViesInfo answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "viesInfo");
LinkedHashMap params = new LinkedHashMap();
params.put("country_code", country_code);
params.put("vatNumber", vatNumber);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = ViesInfoBase.fromJson((LinkedHashMap)jtson.decodeTSON(response.body().bytes()));
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

public Summary summary(String userId) throws ServiceError {
Summary answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "summary");
LinkedHashMap params = new LinkedHashMap();
params.put("userId", userId);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = SummaryBase.fromJson((LinkedHashMap)jtson.decodeTSON(response.body().bytes()));
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

public ResourceSummary resourceSummary(String userId) throws ServiceError {
ResourceSummary answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "resourceSummary");
LinkedHashMap params = new LinkedHashMap();
params.put("userId", userId);
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

public Profiles profiles(String userId) throws ServiceError {
Profiles answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "profiles");
LinkedHashMap params = new LinkedHashMap();
params.put("userId", userId);
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

public String createToken(String userId,int validityInSeconds) throws ServiceError {
String answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "createToken");
LinkedHashMap params = new LinkedHashMap();
params.put("userId", userId);
params.put("validityInSeconds", validityInSeconds);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = (String)((List)jtson.decodeTSON(response.body().bytes())).get(0);
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

public boolean isTokenValid(String token) throws ServiceError {
boolean answer = true;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "isTokenValid");
LinkedHashMap params = new LinkedHashMap();
params.put("token", token);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = (boolean)((List)jtson.decodeTSON(response.body().bytes())).get(0);
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

public String setTeamPrivilege(String username,Principal principal,Privilege privilege) throws ServiceError {
String answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "setTeamPrivilege");
LinkedHashMap params = new LinkedHashMap();
params.put("username", username);
params.put("principal", principal.toJson());
params.put("privilege", privilege.toJson());
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = (String)((List)jtson.decodeTSON(response.body().bytes())).get(0);
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

public Version getServerVersion(String module) throws ServiceError {
Version answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "getServerVersion");
LinkedHashMap params = new LinkedHashMap();
params.put("module", module);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = VersionBase.fromJson((LinkedHashMap)jtson.decodeTSON(response.body().bytes()));
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

public Object getInvited(String email) throws ServiceError {
Object answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "getInvited");
LinkedHashMap params = new LinkedHashMap();
params.put("email", email);
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

public Object sendValidationMail(String email) throws ServiceError {
Object answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "sendValidationMail");
LinkedHashMap params = new LinkedHashMap();
params.put("email", email);
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

public Object sendResetPasswordEmail(String email) throws ServiceError {
Object answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "sendResetPasswordEmail");
LinkedHashMap params = new LinkedHashMap();
params.put("email", email);
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

public Object changeUserPassword(String token,String password) throws ServiceError {
Object answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "changeUserPassword");
LinkedHashMap params = new LinkedHashMap();
params.put("token", token);
params.put("password", password);
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

public Object validateUser(String token) throws ServiceError {
Object answer = null;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "validateUser");
LinkedHashMap params = new LinkedHashMap();
params.put("token", token);
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

public boolean canCreatePrivateProject(String teamOrUserId) throws ServiceError {
boolean answer = true;
Response response = null;
try {
URI uri = URI.create( "api/v1/user" + "/" + "canCreatePrivateProject");
LinkedHashMap params = new LinkedHashMap();
params.put("teamOrUserId", teamOrUserId);
response = tercenClient.httpClient.post(getServiceUri(uri).toString(), null,RequestBody.create(MediaType.parse("application/tson"), jtson.encodeTSON(params)) );
if (response.code() != 200) {
        onResponseError(response);
      } else {
     
answer = (boolean)((List)jtson.decodeTSON(response.body().bytes())).get(0);
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