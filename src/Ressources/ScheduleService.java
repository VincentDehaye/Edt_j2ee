package Ressources;

import Factories.EMF;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
public class ScheduleService {
    @PersistenceContext
    private EntityManager em = EMF.createEntityManager();

    public List<LigneEdt> findSchedule( Integer id) {
        List<LigneEdt> listEdt = new ArrayList<>();

        if (id != null) {
            Query jQuery = em.createQuery("SELECT NEW Ressources.LigneEdt(u.identifiant, c.type, h.jourSemaine, h.heureDebut, h.heureFin, c.salle, c.groupe) from CreneauEntity c JOIN c.horaireByHoraire h JOIN c.uvByUv u\n" +
                    "        JOIN c.participationsByIdCreneau p JOIN p.etudiantByEtu e WHERE e.id = :id");
            jQuery.setParameter("id", id);
            listEdt = jQuery.getResultList();
        }
        return listEdt;
    }
}
