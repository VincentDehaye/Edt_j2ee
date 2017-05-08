package Services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
public class ScheduleService {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

    public List<LigneEdt> findSchedule( Integer id) {
        List<LigneEdt> listEdt = new ArrayList<>();

        if (id != null) {
            Query jQuery = em.createQuery("SELECT NEW Services.LigneEdt(u.identifiant, c.type, h.jourSemaine, h.heureDebut, h.heureFin, c.salle, c.groupe) from CreneauEntity c JOIN c.horaireByHoraire h JOIN c.uvByUv u\n" +
                    "        JOIN c.participationsByIdCreneau p JOIN p.etudiantByEtu e WHERE e.id = :id");
            jQuery.setParameter("id", id);
            listEdt = jQuery.getResultList();
        }
        return listEdt;
    }
}
