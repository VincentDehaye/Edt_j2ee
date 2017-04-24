package com.sdzee.beans;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by vincent on 24/04/17.
 */
@Entity
@Table(name = "Creneau", schema = "sr03_project", catalog = "")
public class CreneauEntity {
    private int idCreneau;
    private int uv;
    private int horaire;
    private String salle;
    private String type;
    private String groupe;
    private String alternance;
    private UvEntity uvByUv;
    private HoraireEntity horaireByHoraire;
    private Collection<ParticipationEntity> participationsByIdCreneau;

    @Id
    @Column(name = "IdCreneau")
    public int getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(int idCreneau) {
        this.idCreneau = idCreneau;
    }

    @Basic
    @Column(name = "Uv")
    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }

    @Basic
    @Column(name = "Horaire")
    public int getHoraire() {
        return horaire;
    }

    public void setHoraire(int horaire) {
        this.horaire = horaire;
    }

    @Basic
    @Column(name = "Salle")
    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    @Basic
    @Column(name = "Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Groupe")
    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    @Basic
    @Column(name = "Alternance")
    public String getAlternance() {
        return alternance;
    }

    public void setAlternance(String alternance) {
        this.alternance = alternance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreneauEntity that = (CreneauEntity) o;

        if (idCreneau != that.idCreneau) return false;
        if (uv != that.uv) return false;
        if (horaire != that.horaire) return false;
        if (salle != null ? !salle.equals(that.salle) : that.salle != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (groupe != null ? !groupe.equals(that.groupe) : that.groupe != null) return false;
        if (alternance != null ? !alternance.equals(that.alternance) : that.alternance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCreneau;
        result = 31 * result + uv;
        result = 31 * result + horaire;
        result = 31 * result + (salle != null ? salle.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (groupe != null ? groupe.hashCode() : 0);
        result = 31 * result + (alternance != null ? alternance.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Uv", referencedColumnName = "IdUv", nullable = false)
    public UvEntity getUvByUv() {
        return uvByUv;
    }

    public void setUvByUv(UvEntity uvByUv) {
        this.uvByUv = uvByUv;
    }

    @ManyToOne
    @JoinColumn(name = "Horaire", referencedColumnName = "IdHoraire", nullable = false)
    public HoraireEntity getHoraireByHoraire() {
        return horaireByHoraire;
    }

    public void setHoraireByHoraire(HoraireEntity horaireByHoraire) {
        this.horaireByHoraire = horaireByHoraire;
    }

    @OneToMany(mappedBy = "creneauByCren")
    public Collection<ParticipationEntity> getParticipationsByIdCreneau() {
        return participationsByIdCreneau;
    }

    public void setParticipationsByIdCreneau(Collection<ParticipationEntity> participationsByIdCreneau) {
        this.participationsByIdCreneau = participationsByIdCreneau;
    }
}
