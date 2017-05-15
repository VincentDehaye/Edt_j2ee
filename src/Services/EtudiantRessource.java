package Services;

/**
 * Created by Sylvain on 05/05/2017.
 */

import Ressources.EtudiantService;
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

    /* TODO
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public EtudiantEntity addEtu(){
        EtudiantEntity etudiantEntity = new EtudiantEntity();
        etudiantEntity.setNom("Carre");
        etudiantEntity.setPrenom("Fabien");
        etudiantEntity.setSemestre("2");
        etudiantEntity.setMail("fabien.carre@etu.utc.fr");
        etudiantEntity.setCursus("GSM");
        etudiantEntity.setNiveau("branche");

        return etudiantService.addEtudiant(etudiantEntity);
    }
    */

}
