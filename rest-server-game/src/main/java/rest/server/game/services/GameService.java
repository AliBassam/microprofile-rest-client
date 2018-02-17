package rest.server.game.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.RestClientDefinitionException;

import rest.interfaces.GameInterface;
import rest.interfaces.UserInterface;

public class GameService implements GameInterface {

	@Override
	public Response findAll() {
		return Response.ok(Arrays.asList("Call of Duty", "Battlefield")).build();
	}

	@Override
	public Response findWhosPlaying() {
		//Retrieve List of Users
		String apiUrl = "http://localhost:8080/user";
		UserInterface userInterface;
		List<String> users;
		try {
			userInterface = RestClientBuilder.newBuilder()
			            .baseUrl(new URL(apiUrl))
			            .build(UserInterface.class);
			users = userInterface.findAll().readEntity(List.class);
		} catch (IllegalStateException | RestClientDefinitionException | MalformedURLException e) {
			users = new ArrayList<String>();
			e.printStackTrace();
		}
		
		//Prepare Dummy List
		List<GameUsers> result = new ArrayList<GameUsers>();
		result.add(new GameUsers("Call of Duty", users));
		result.add(new GameUsers("Battlefield", users));
		
		return Response.ok(result).build();
	}
	
	private class GameUsers {
		
		private String game;
		private List<String> users;
		
		public GameUsers() {
		}
		
		public GameUsers(String game, List<String> users) {
			super();
			this.game = game;
			this.users = users;
		}

		public String getGame() {
			return game;
		}
		
		public List<String> getUsers() {
			return users;
		}
		
		public void setGame(String game) {
			this.game = game;
		}
		
		public void setUsers(List<String> users) {
			this.users = users;
		}
	}

}
