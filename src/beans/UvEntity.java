package beans;

import java.util.Collection;

/**
 * Created by Sylvain on 07/05/2017.
 */
public class UvEntity {
    private int idUv;
    private String identifiant;
    private String description;
    private Collection<CreneauEntity> creneausByIdUv;
    private ProfesseurEntity professeurByResponsable;

    public int getIdUv() {
        return idUv;
    }

    public void setIdUv(int idUv) {
        this.idUv = idUv;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UvEntity uvEntity = (UvEntity) o;

        if (idUv != uvEntity.idUv) return false;
        if (identifiant != null ? !identifiant.equals(uvEntity.identifiant) : uvEntity.identifiant != null)
            return false;
        if (description != null ? !description.equals(uvEntity.description) : uvEntity.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUv;
        result = 31 * result + (identifiant != null ? identifiant.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<CreneauEntity> getCreneausByIdUv() {
        return creneausByIdUv;
    }

    public void setCreneausByIdUv(Collection<CreneauEntity> creneausByIdUv) {
        this.creneausByIdUv = creneausByIdUv;
    }

    public ProfesseurEntity getProfesseurByResponsable() {
        return professeurByResponsable;
    }

    public void setProfesseurByResponsable(ProfesseurEntity professeurByResponsable) {
        this.professeurByResponsable = professeurByResponsable;
    }
}
