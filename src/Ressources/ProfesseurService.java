package Ressources;

import Factories.EMF;
import beans.ProfesseurEntity;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
public class ProfesseurService {
    @PersistenceContext
    private EntityManager em = EMF.createEntityManager();

    public List<ProfesseurEntity> findProfesseurs() {
        List<ProfesseurEntity> listEtu = (List<ProfesseurEntity>) em.createQuery("Select p From ProfesseurEntity p")
                .getResultList();
        Iterator it = listEtu.iterator();
        while (it.hasNext()) {
            ProfesseurEntity prof = (ProfesseurEntity) it.next();
            prof.setUvsByIdProfesseur(null);
        }
        return listEtu;
    }

    public ProfesseurEntity findProfesseur(Integer id) {
        Query jQuery = em.createQuery("Select p From ProfesseurEntity p where p.id = :id");
        jQuery.setParameter("id", id);
        ProfesseurEntity prof = (ProfesseurEntity)jQuery.getSingleResult();
        prof.setUvsByIdProfesseur(null);
        return prof;
    }

}
