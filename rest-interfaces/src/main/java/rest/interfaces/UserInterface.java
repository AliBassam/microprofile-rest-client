package rest.interfaces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;


@Path("")
@RegisterProvider(JacksonJsonProvider.class)
public interface UserInterface {

	@GET
	@Path("/all")
	@Produces(value=MediaType.APPLICATION_JSON)
	Response findAll();
}
