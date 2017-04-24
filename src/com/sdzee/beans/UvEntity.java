package com.sdzee.beans;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by vincent on 24/04/17.
 */
@Entity
@Table(name = "UV", schema = "sr03_project", catalog = "")
public class UvEntity {
    private int idUv;
    private String identifiant;
    private int responsable;
    private String description;
    private Collection<CreneauEntity> creneausByIdUv;
    private ProfesseurEntity professeurByResponsable;

    @Id
    @Column(name = "IdUv")
    public int getIdUv() {
        return idUv;
    }

    public void setIdUv(int idUv) {
        this.idUv = idUv;
    }

    @Basic
    @Column(name = "Identifiant")
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    @Basic
    @Column(name = "Responsable")
    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    @Basic
    @Column(name = "Description")
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
        if (responsable != uvEntity.responsable) return false;
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
        result = 31 * result + responsable;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "uvByUv")
    public Collection<CreneauEntity> getCreneausByIdUv() {
        return creneausByIdUv;
    }

    public void setCreneausByIdUv(Collection<CreneauEntity> creneausByIdUv) {
        this.creneausByIdUv = creneausByIdUv;
    }

    @ManyToOne
    @JoinColumn(name = "Responsable", referencedColumnName = "IdProfesseur", nullable = false)
    public ProfesseurEntity getProfesseurByResponsable() {
        return professeurByResponsable;
    }

    public void setProfesseurByResponsable(ProfesseurEntity professeurByResponsable) {
        this.professeurByResponsable = professeurByResponsable;
    }
}
