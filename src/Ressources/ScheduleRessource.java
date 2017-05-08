package Ressources;

import Services.LigneEdt;
import Services.ScheduleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Sylvain on 07/05/2017.
 */
@Path("/edt")
public class ScheduleRessource {
    private ScheduleService scheduleService = new ScheduleService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public List<LigneEdt> findOne(@PathParam("id") Integer id) {
        return scheduleService.findSchedule(id);
    }


}


