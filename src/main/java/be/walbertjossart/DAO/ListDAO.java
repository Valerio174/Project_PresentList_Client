package be.walbertjossart.DAO;

import java.net.URI;
import java.time.format.DateTimeFormatter;
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

import be.walbertjossart.JavaBeans.List;

public class ListDAO extends DAO<List>{

	private static final String baseUrl = "http://localhost:8080/Project_PresentList_API/api"; //final because it won't to be changed later
    private Client client;
    private WebResource ressource;
    private ObjectMapper mapper;
    
    public ListDAO() {
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
	public boolean create(List list) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        
        MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
        paramsPost.add("occasion", list.getOccasion());
        paramsPost.add("limit_date", list.getLimit_date().format(formatter));
        paramsPost.add("state", list.GetState());
        
        ClientResponse res = ressource
                .path("list")
                .post(ClientResponse.class, paramsPost);
    
        int HttpResponseCode = res.getStatus();
        if(HttpResponseCode == 201) {
            return true;
        }
        return false;
	}

	@Override
	public boolean delete(List obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(List list) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        
        MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
        paramsPost.add("occasion", list.getOccasion());
        paramsPost.add("limit_date", list.getLimit_date().format(formatter));
        paramsPost.add("state", list.GetState());
        // gerer les inviter et les cadeaux
        ClientResponse res = ressource
                .path("list")
                .put(ClientResponse.class, paramsPost);
        
        int HttpResponseCode = res.getStatus();
        if(HttpResponseCode == 201) {
            return true;
        }
        return false;
	}

	@Override
	public List find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List> findAll() {
		ArrayList<List> lists = new ArrayList<>();
        String APIresponse = ressource
                .path("list")
                .accept(MediaType.APPLICATION_JSON)
                .get(String.class);
        
        JSONArray array = new JSONArray(APIresponse);
        try {
            for (int i = 0; i < array.length(); i++) {
                List list = mapper.readValue(array.get(i).toString(), List.class);
                lists.add(list);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
     
        return lists;
	}

}
