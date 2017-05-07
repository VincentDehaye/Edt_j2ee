import beans.EtudiantEntity;
import dao.LigneEdt;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sylvain on 07/05/2017.
 */
@Path("/edt")
public class EmploiDuTemps {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LigneEdt> findAll(@QueryParam("id") Integer id) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        List<LigneEdt> listEdt = new ArrayList<LigneEdt>();
        String resultat = "Vide";

        if (id != null) {
            Query jQuery = em.createQuery("SELECT NEW dao.LigneEdt(u.identifiant, c.type, h.jourSemaine, h.heureDebut, h.heureFin, c.salle, c.groupe) from CreneauEntity c JOIN c.horaireByHoraire h JOIN c.uvByUv u\n" +
                    "        JOIN c.participationsByIdCreneau p JOIN p.etudiantByEtu e WHERE e.id = :id");
            jQuery.setParameter("id", id);
            listEdt = jQuery.getResultList();
        }

        return listEdt;
    }


}


