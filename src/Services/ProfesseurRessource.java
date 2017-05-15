package Services;

import Ressources.ProfesseurService;
import beans.ProfesseurEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
@Path("/professeurs")
public class ProfesseurRessource {
    private ProfesseurService professeurService = new ProfesseurService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfesseurEntity> findAll() {
        return professeurService.findProfesseurs();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProfesseurEntity findOne(@PathParam("id") Integer id) {
        return professeurService.findProfesseur(id);
    }

}
