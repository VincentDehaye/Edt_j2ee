package Services;

import beans.UvEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sylvain on 08/05/2017.
 */
public class UvService {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    private EntityManager em = factory.createEntityManager();

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

    public UvEntity addUv(){
        UvEntity uv = new UvEntity();
        return uv;
    }
}
