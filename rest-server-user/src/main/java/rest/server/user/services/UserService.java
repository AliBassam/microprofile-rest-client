package rest.server.user.services;

import java.util.Arrays;

import javax.ws.rs.core.Response;

import rest.interfaces.UserInterface;

public class UserService implements UserInterface {

	@Override
	public Response findAll() {
		return Response.ok(Arrays.asList("Ali", "Bassam")).build();
	}

}
