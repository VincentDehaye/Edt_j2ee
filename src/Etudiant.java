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
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Path("/etudiants")
public class Etudiant {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EtudiantEntity> findAll(@QueryParam("id") Integer id) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String resultat = "";
        List<EtudiantEntity> listEtu;

        if (id == null) {
            Query jQuery = em.createQuery("Select e From EtudiantEntity e");
            listEtu = (List<EtudiantEntity>) em.createQuery("Select e From EtudiantEntity e")
                    .getResultList();

            Iterator it = listEtu.iterator();
            while (it.hasNext()) {
                EtudiantEntity etu = (EtudiantEntity) it.next();
                etu.setParticipationsByIdEtudiant(null);
            }
            /*
                try {
                    String json = ow.writeValueAsString(listEtu);
                    resultat += json;
                } catch (IOException io) {}
            */
        }
        else {
            Query jQuery = em.createQuery("Select e From EtudiantEntity e where e.id = :id");
            jQuery.setParameter("id", id);

            EtudiantEntity etu = (EtudiantEntity)jQuery.getSingleResult();
            etu.setParticipationsByIdEtudiant(null);
            listEtu = new ArrayList<EtudiantEntity>();
            listEtu.add(etu);
        }
        return listEtu;
    }


}
