package Services;

import beans.EtudiantEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
public class EtudiantService {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

    public List<EtudiantEntity> findEtudiants() {
        List<EtudiantEntity> listEtu = (List<EtudiantEntity>) em.createQuery("Select e From EtudiantEntity e")
                .getResultList();

        Iterator it = listEtu.iterator();
        while (it.hasNext()) {
            EtudiantEntity etu = (EtudiantEntity) it.next();
            etu.setParticipationsByIdEtudiant(null);
        }
        return listEtu;
    }

    public EtudiantEntity findEtudiant(Integer id) {
        Query jQuery = em.createQuery("Select e From EtudiantEntity e where e.id = :id");
        jQuery.setParameter("id", id);

        EtudiantEntity etu = (EtudiantEntity)jQuery.getSingleResult();
        etu.setParticipationsByIdEtudiant(null);

        return etu;
    }
}
