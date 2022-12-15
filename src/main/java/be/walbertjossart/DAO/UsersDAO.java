package be.walbertjossart.DAO;

import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.json.JSONArray;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import be.walbertjossart.JavaBeans.Users;

public class UsersDAO {
	private static final String	baseUrl = "http://localhost:8080/Project_PresentList_API/api"; //final because it won't to be changed later
	private Client client;
	private WebResource ressource;
	private ObjectMapper mapper;
	
	public UsersDAO() {
		ClientConfig config = new DefaultClientConfig();
		client = Client.create(config);		 
		ressource = client.resource(getBaseURI());
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
	
	}
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri(baseUrl).build();	 
	}
	
	public ArrayList<Users> getAll() {
		/*Retrieve the list of users (in text string format)*/
		ArrayList<Users> users = new ArrayList<>();
		String APIresponse = ressource
				.path("user")
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		JSONArray array = new JSONArray(APIresponse);
		try {
			for (int i = 0; i < array.length(); i++) {
				Users user = mapper.readValue(array.get(i).toString(), Users.class);
				users.add(user);
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
 	
		return users;
	}
	
}
