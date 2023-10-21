package com.gamingroom.gameauth.controller;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gamingroom.gameauth.representations.GameUserInfo;
 
@Produces(MediaType.TEXT_PLAIN)
@Path("/client/")
public class RESTClientController 
{
    private Client client;
 
    public RESTClientController(Client client) {
        this.client = client;
    }
     

//    @GET
//	@Path("/gameusers")
//    public String getGameUsers()
//    {
//        //Do not hard code in your application
//        WebTarget webTarget = client.target("http://localhost:8080/gameusers");
//        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
//        Response response = invocationBuilder.get();
//        @SuppressWarnings("rawtypes")
//        ArrayList gameusers = response.readEntity(ArrayList.class);
//        return gameusers.toString();
//    }
    
    @GET
    @Path("/gameusers")
    public String getGameUsers() {
      // Load the config file
      Properties properties = new Properties();
      try (FileInputStream in = new FileInputStream("config.properties")) {
        properties.load(in);
      } catch (IOException e) {
        // Handle exception
      }

      // Get the server address from the config file
      String serverAddress = properties.getProperty("server.address");

      // Create the web target
      WebTarget webTarget = client.target(serverAddress + "/gameusers");

      // Build the invocation
      Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

      // Get the response
      Response response = invocationBuilder.get();

      // Read the response entity as an ArrayList
      @SuppressWarnings("rawtypes")
      ArrayList gameusers = response.readEntity(ArrayList.class);

      // Return the gameusers
      return gameusers.toString();
    }

     
    @GET
    @Path("/gameusers/{id}")
    public String getGameUserById(@PathParam("id") int id)
    {
        //Do not hard code in your application
        WebTarget webTarget = client.target("http://localhost:8080/gameusers/"+id);
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        GameUserInfo gameUserInfo = response.readEntity(GameUserInfo.class);
        return gameUserInfo.toString();
    }
}