package Ressources;

/**
 * Created by Sylvain on 05/05/2017.
 */

import Services.EtudiantService;
import beans.EtudiantEntity;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/etudiants")
public class EtudiantRessource {
    private EtudiantService etudiantService = new EtudiantService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EtudiantEntity> findAll() {
        return etudiantService.findEtudiants();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public EtudiantEntity findOne(@PathParam("id") Integer id) {
         return etudiantService.findEtudiant(id);
    }

}
