package be.walbertjossart.DAO;

import java.net.URI;
import java.sql.Connection;
import java.util.ArrayList;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.walbertjossart.JavaBeans.Present;

public class PresentDAO extends DAO<Present>{
	private static final String	baseUrl = "http://localhost:8080/Project_PresentList_API/api"; //final because it won't to be changed later
	private Client client;
	private WebResource ressource;
	private ObjectMapper mapper;
	
	public PresentDAO() {
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
	public boolean create(Present present) {
		 		
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("name", present.getName());
		paramsPost.add("description", present.getDescription());
		paramsPost.add("average_price", String.valueOf(present.getAverage_price()));
		paramsPost.add("priority", String.valueOf(present.getPriority()));
		paramsPost.add("state", String.valueOf(present.getState()));
		paramsPost.add("link", present.getLink());
		paramsPost.add("image", String.valueOf(present.getImage()));
		
		ClientResponse res = ressource
				.path("present")
				.post(ClientResponse.class, paramsPost);
	
		int HttpResponseCode = res.getStatus();
		if(HttpResponseCode == 201) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Present obj) {
 		return false;
	}

	@Override
	public boolean update(Present obj) {
 		return false;
	}

	@Override
	public Present find(int id) {
 		return null;
	}

	@Override
	public ArrayList<Present> findAll() {
 		return null;
	}

}
