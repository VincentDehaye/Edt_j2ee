package Ressources;

import Factories.EMF;
import Sessions.Cryptage;
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
            etu.setPassword(null);
        }
        return listEtu;
    }

    public EtudiantEntity findEtudiant(Integer id) {
        Query jQuery = em.createQuery("Select e From EtudiantEntity e where e.id = :id");
        jQuery.setParameter("id", id);

        EtudiantEntity etu = (EtudiantEntity)jQuery.getSingleResult();
        if(etu != null) {
            etu.setParticipationsByIdEtudiant(null);
            etu.setPassword(null);
        }

        return etu;
    }

    public EtudiantEntity findEtudiantByLogin(String login) {
        Query jQuery = em.createQuery("Select e From EtudiantEntity e where e.login = :login");
        jQuery.setParameter("login", login);

        EtudiantEntity etu = (EtudiantEntity)jQuery.getSingleResult();
        if(etu!= null) {
            etu.setParticipationsByIdEtudiant(null);
        }
        return etu;
    }

    public EtudiantEntity addEtudiant(EtudiantEntity etudiantEntity){
        etudiantEntity.setPassword(Cryptage.crypterMdp(etudiantEntity.getPassword()));
        em.getTransaction().begin();
        em.persist(etudiantEntity);
        em.getTransaction().commit();
        return etudiantEntity;
    }

    public void RemoveEtudiantByLogin(String login) {
        Query jQuery = em.createQuery("Select e From EtudiantEntity e where e.login = :login");
        jQuery.setParameter("login", login);

        EtudiantEntity etu = (EtudiantEntity)jQuery.getSingleResult();
        em.getTransaction().begin();
        em.remove(etu);
        em.getTransaction().commit();
    }
}
