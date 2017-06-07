package Services;

import Sessions.AuthentificationFilter;
import beans.UvEntity;
import Ressources.UvService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
@Path("/uvs")
public class UvRessource {
    UvService uvService = new UvService();
    @HeaderParam("Authorization") String authorizationHeader;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws Exception  {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            return Response.status(200)
                    .entity(uvService.findUvs())
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
                    .entity(uvService.findUv(id))
                    .build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOne(UvEntity uvEntity) throws Exception  {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            return Response.status(200)
                    .entity(uvService.addUv(uvEntity))
                    .build();
        }
        catch (Exception e) {

            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteOne(UvEntity etudiantEntity) throws Exception  {
        try{
            AuthentificationFilter.filter(authorizationHeader);
            uvService.RemoveUvById(etudiantEntity.getIdUv());
            return Response.status(200)
                    .entity("Deleted")
                    .build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

}
