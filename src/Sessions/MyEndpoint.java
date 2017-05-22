package Sessions;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Sylvain on 22/05/2017.
 */


@Path("/test")
public class MyEndpoint {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response myUnsecuredMethod(@PathParam("id") Long id) {
        // This method is not annotated with @Secured
        // The authentication filter won't be executed before invoking this method
        return Response.ok("ok").build();
    }

    @DELETE
    @Secured
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mySecuredMethod(@PathParam("id") Long id) {
        //AuthentificationFilter fil = new AuthentificationFilter();



        // This method is annotated with @Secured
        // The authentication filter will be executed before invoking this method
        // The HTTP request must be performed with a valid token
        return Response.ok("oook").build();
    }
}
