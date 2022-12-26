package be.walbertjossart.DAO;

import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.json.JSONArray;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.walbertjossart.JavaBeans.Users;
 
public class UsersDAO extends DAO<Users>{
	private static final String	baseUrl = "http://localhost:8080/Project_PresentList_API/api"; //final because it won't to be changed later
	private Client client;
	private WebResource ressource;
	private ObjectMapper mapper;
	
	public UsersDAO() {
		super();
		ClientConfig config = new DefaultClientConfig();
		client = Client.create(config);		 
		ressource = client.resource(getBaseURI());
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
	}
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri(baseUrl).build();	 
	}
	 

	@Override
	public boolean create(Users users) {
		
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("pseudo", users.getPseudo());
		paramsPost.add("password", users.getPassword());
		paramsPost.add("email", users.getEmail());
		
		ClientResponse res = ressource
				.path("user")
				.post(ClientResponse.class, paramsPost);
	
		int HttpResponseCode = res.getStatus();
		if(HttpResponseCode == 201) {
			return true;
		}
		return false;
		
	}

	@Override
	public boolean delete(Users obj) {
 		return false;
	}

	@Override
	public boolean update(Users obj) {
 		return false;
	}

	@Override
	public Users find(int id) {
		return null;
	}

	@Override
	public ArrayList<Users> findAll() {
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
	
	public Users GetUser(String pseudo, String password) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("pseudo", pseudo);
		paramsPost.add("password", password);
 
		Users users = new Users();
		String APIresponse = ressource
				.path("user/login")
				.accept(MediaType.APPLICATION_JSON)
				.post(String.class, paramsPost);
		
 		try { 
			users = mapper.readValue(APIresponse, Users.class);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
 	
		return users;
	}
	
}
