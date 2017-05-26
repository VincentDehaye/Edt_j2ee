package Services;

import Ressources.ProfesseurService;
import Sessions.AuthentificationFilter;
import beans.ProfesseurEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
@Path("/professeurs")
public class ProfesseurRessource {
    private ProfesseurService professeurService = new ProfesseurService();
    @HeaderParam("Authorization") String authorizationHeader;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception  {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            return Response.status(200)
                    .entity(professeurService.findProfesseurs())
                    .build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findOne(@PathParam("id") Integer id) throws Exception  {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            return Response.status(200)
                    .entity(professeurService.findProfesseur(id))
                    .build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOne(ProfesseurEntity professeurEntity) throws Exception  {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            return Response.status(200)
                    .entity(professeurService.addProfesseur(professeurEntity))
                    .build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteOne(ProfesseurEntity professeurEntity) throws Exception  {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            professeurService.RemoveProfesseurByLogin(professeurEntity.getLogin());
            return Response.status(200)
                    .entity("Deleted")
                    .build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}
