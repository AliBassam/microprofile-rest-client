package rest.interfaces.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.RestClientDefinitionException;
import org.junit.Test;

import rest.interfaces.UserInterface;

public class RestClientTest {

	@Test
	public void findAll() {
		String apiUrl = "http://localhost:8080/user";
		List<String> users;
		
		try {
			UserInterface userInterface = RestClientBuilder.newBuilder()
			            .baseUrl(new URL(apiUrl))
			            .build(UserInterface.class);
			users = (List<String>) userInterface.findAll().getEntity();
			System.out.println(users);
		} catch (IllegalStateException | RestClientDefinitionException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
