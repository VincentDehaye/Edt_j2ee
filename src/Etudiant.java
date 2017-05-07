/**
 * Created by Sylvain on 05/05/2017.
 */

import beans.EtudiantEntity;
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
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


@Path("/etudiants")
public class Etudiant {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

    @GET
    @Produces("text/plain")
    public String findAll(@QueryParam("id") Integer id) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String resultat = "";

        if (id == null) {
            Query jQuery = em.createQuery("Select e From EtudiantEntity e");
            List<EtudiantEntity> listEtu = jQuery.getResultList();

            Iterator it = listEtu.iterator();
            while (it.hasNext()) {
                EtudiantEntity etu = (EtudiantEntity) it.next();
                etu.setParticipationsByIdEtudiant(null);
                try {
                    String json = ow.writeValueAsString(etu);
                    resultat += json;
                } catch (IOException io) {}
            }
        }
        else {
            Query jQuery = em.createQuery("Select e From EtudiantEntity e where e.id = :id");
            jQuery.setParameter("id", id);

            EtudiantEntity etu = (EtudiantEntity)jQuery.getSingleResult();
            etu.setParticipationsByIdEtudiant(null);
                try {
                    String json = ow.writeValueAsString(etu);
                    resultat += json;
                } catch (IOException io) {}
        }
        return resultat;
    }


}
