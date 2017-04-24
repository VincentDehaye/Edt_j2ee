package com.sdzee.beans;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

/**
 * Created by vincent on 24/04/17.
 */
@Entity
@Table(name = "Horaire", schema = "sr03_project", catalog = "")
public class HoraireEntity {
    private int idHoraire;
    private Time heureDébut;
    private Time heureFin;
    private String jourSemaine;
    private Collection<CreneauEntity> creneausByIdHoraire;

    @Id
    @Column(name = "IdHoraire")
    public int getIdHoraire() {
        return idHoraire;
    }

    public void setIdHoraire(int idHoraire) {
        this.idHoraire = idHoraire;
    }

    @Basic
    @Column(name = "Heure_début")
    public Time getHeureDébut() {
        return heureDébut;
    }

    public void setHeureDébut(Time heureDébut) {
        this.heureDébut = heureDébut;
    }

    @Basic
    @Column(name = "Heure_fin")
    public Time getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Time heureFin) {
        this.heureFin = heureFin;
    }

    @Basic
    @Column(name = "Jour_semaine")
    public String getJourSemaine() {
        return jourSemaine;
    }

    public void setJourSemaine(String jourSemaine) {
        this.jourSemaine = jourSemaine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HoraireEntity that = (HoraireEntity) o;

        if (idHoraire != that.idHoraire) return false;
        if (heureDébut != null ? !heureDébut.equals(that.heureDébut) : that.heureDébut != null) return false;
        if (heureFin != null ? !heureFin.equals(that.heureFin) : that.heureFin != null) return false;
        if (jourSemaine != null ? !jourSemaine.equals(that.jourSemaine) : that.jourSemaine != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHoraire;
        result = 31 * result + (heureDébut != null ? heureDébut.hashCode() : 0);
        result = 31 * result + (heureFin != null ? heureFin.hashCode() : 0);
        result = 31 * result + (jourSemaine != null ? jourSemaine.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "horaireByHoraire")
    public Collection<CreneauEntity> getCreneausByIdHoraire() {
        return creneausByIdHoraire;
    }

    public void setCreneausByIdHoraire(Collection<CreneauEntity> creneausByIdHoraire) {
        this.creneausByIdHoraire = creneausByIdHoraire;
    }
}
