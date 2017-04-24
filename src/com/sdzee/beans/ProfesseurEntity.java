package com.sdzee.beans;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by vincent on 24/04/17.
 */
@Entity
@Table(name = "Professeur", schema = "sr03_project", catalog = "")
public class ProfesseurEntity {
    private int idProfesseur;
    private String nom;
    private String prenom;
    private String mail;
    private byte[] photo;
    private Collection<UvEntity> uvsByIdProfesseur;

    @Id
    @Column(name = "IdProfesseur")
    public int getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(int idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    @Basic
    @Column(name = "Nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "Prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "Mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "Photo")
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfesseurEntity that = (ProfesseurEntity) o;

        if (idProfesseur != that.idProfesseur) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (!Arrays.equals(photo, that.photo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProfesseur;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @OneToMany(mappedBy = "professeurByResponsable")
    public Collection<UvEntity> getUvsByIdProfesseur() {
        return uvsByIdProfesseur;
    }

    public void setUvsByIdProfesseur(Collection<UvEntity> uvsByIdProfesseur) {
        this.uvsByIdProfesseur = uvsByIdProfesseur;
    }
}
