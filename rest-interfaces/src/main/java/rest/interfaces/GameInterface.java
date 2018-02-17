package rest.interfaces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public interface GameInterface {

	@GET
	@Path("/all")
	@Produces(value=MediaType.APPLICATION_JSON)
	Response findAll();
	
	@GET
	@Path("/users")
	@Produces(value=MediaType.APPLICATION_JSON)
	Response findWhosPlaying();
}
