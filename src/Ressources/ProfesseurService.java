package Ressources;

import Factories.EMF;
import Sessions.Cryptage;
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
            prof.setPassword(null);
        }
        return listEtu;
    }

    public ProfesseurEntity findProfesseur(Integer id) {
        Query jQuery = em.createQuery("Select p From ProfesseurEntity p where p.id = :id");
        jQuery.setParameter("id", id);
        ProfesseurEntity prof = (ProfesseurEntity)jQuery.getSingleResult();
        prof.setUvsByIdProfesseur(null);
        prof.setPassword(null);
        return prof;
    }

    public ProfesseurEntity findProfesseurByLogin(String login) {
        Query jQuery = em.createQuery("Select p From ProfesseurEntity p where p.login = :login");
        jQuery.setParameter("login", login);
        ProfesseurEntity prof = (ProfesseurEntity)jQuery.getSingleResult();
        prof.setUvsByIdProfesseur(null);
        return prof;
    }


    public ProfesseurEntity addProfesseur (ProfesseurEntity professeurEntity){
        professeurEntity.setPassword(Cryptage.crypterMdp(professeurEntity.getPassword()));
        em.getTransaction().begin();
        em.persist(professeurEntity);
        em.getTransaction().commit();
        return professeurEntity;
    }

    public void RemoveProfesseurByLogin(String login) {
        Query jQuery = em.createQuery("Select p From ProfesseurEntity p where p.login = :login");
        jQuery.setParameter("login", login);

        ProfesseurEntity prof = (ProfesseurEntity)jQuery.getSingleResult();
        em.getTransaction().begin();
        em.remove(prof);
        em.getTransaction().commit();
    }
}
