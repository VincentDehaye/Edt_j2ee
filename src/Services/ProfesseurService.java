package Services;

import beans.ProfesseurEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
public class ProfesseurService {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

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
