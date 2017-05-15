package Ressources;

import Factories.EMF;
import beans.EtudiantEntity;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
public class EtudiantService {
    @PersistenceContext
    private EntityManager em = EMF.createEntityManager();

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

    public EtudiantEntity addEtudiant(EtudiantEntity etudiantEntity){
        em.getTransaction().begin();
        em.persist(etudiantEntity);
        em.getTransaction().commit();

        return etudiantEntity;
    }
}
