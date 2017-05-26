package Ressources;

import Factories.EMF;
import beans.UvEntity;

import javax.persistence.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
public class UvService {
    @PersistenceContext
    private EntityManager em = EMF.createEntityManager();

    public List<UvEntity> findUvs() {
        List<UvEntity> listUv = (List<UvEntity>) em.createQuery("Select u From UvEntity u")
                .getResultList();

        Iterator it = listUv.iterator();
        while (it.hasNext()) {
            UvEntity uv = (UvEntity) it.next();
            uv.setCreneausByIdUv(null);
            uv.setProfesseurByResponsable(null);
        }
        return listUv;
    }

    public UvEntity findUv(Integer id) {
        Query jQuery = em.createQuery("Select u From UvEntity u where u.id = :id");
        jQuery.setParameter("id", id);

        UvEntity uv = (UvEntity)jQuery.getSingleResult();
        uv.setCreneausByIdUv(null);
        uv.setProfesseurByResponsable(null);

        return uv;
    }

    public UvEntity addUv(UvEntity uvEntity){
        em.getTransaction().begin();
        em.persist(uvEntity);
        em.getTransaction().commit();

        return uvEntity;
    }

    public void RemoveUvById(Integer id) {
        Query jQuery = em.createQuery("Select u From UvEntity u where u.idUv = :id");
        jQuery.setParameter("id", id);

        UvEntity uv = (UvEntity)jQuery.getSingleResult();
        em.getTransaction().begin();
        em.remove(uv);
        em.getTransaction().commit();
    }
}
