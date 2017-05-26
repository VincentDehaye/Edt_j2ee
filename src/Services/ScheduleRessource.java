package Services;

import Ressources.LigneEdt;
import Ressources.ScheduleService;
import Sessions.AuthentificationFilter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Sylvain on 07/05/2017.
 */
@Path("/edt")
public class ScheduleRessource {
    private ScheduleService scheduleService = new ScheduleService();
    @HeaderParam("Authorization") String authorizationHeader;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findOne(@PathParam("id") Integer id) {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            return Response.status(200)
                    .entity(scheduleService.findSchedule(id))
                    .build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }


}


