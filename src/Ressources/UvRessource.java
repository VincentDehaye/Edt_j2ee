package Ressources;

import beans.UvEntity;
import Services.UvService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
@Path("/uvs")
public class UvRessource {
    UvService uvService = new UvService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UvEntity> findAll() {
        return uvService.findUvs();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public UvEntity findOne(@PathParam("id") Integer id) {
        return uvService.findUv(id);
    }

}
