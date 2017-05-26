package Services;

/**
 * Created by Sylvain on 05/05/2017.
 */

import Ressources.EtudiantService;
import Sessions.AuthentificationFilter;
import beans.EtudiantEntity;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/etudiants")
public class EtudiantRessource {
    private EtudiantService etudiantService = new EtudiantService();
    @HeaderParam("Authorization") String authorizationHeader;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception  {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            return Response.status(200)
                    .entity(etudiantService.findEtudiants())
                    .build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findOne(@PathParam("id") Integer id) throws Exception {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            return Response.status(200)
                    .entity(etudiantService.findEtudiant(id))
                    .build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOne(EtudiantEntity etudiantEntity) throws Exception  {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            return Response.status(200)
                    .entity(etudiantService.addEtudiant(etudiantEntity))
                    .build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteOne(EtudiantEntity etudiantEntity) throws Exception  {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            etudiantService.RemoveEtudiantByLogin(etudiantEntity.getLogin());
            return Response.status(200)
                    .entity("Deleted")
                    .build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}
