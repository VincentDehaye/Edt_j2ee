package beans;

import java.util.Collection;

/**
 * Created by Sylvain on 15/05/2017.
 */
public class EtudiantEntity {
    private int idEtudiant;
    private String nom;
    private String prenom;
    private String mail;
    private String semestre;
    private String cursus;
    private String niveau;
    private String login;
    private String password;
    private Collection<ParticipationEntity> participationsByIdEtudiant;

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCursus() {
        return cursus;
    }

    public void setCursus(String cursus) {
        this.cursus = cursus;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EtudiantEntity that = (EtudiantEntity) o;

        if (idEtudiant != that.idEtudiant) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (semestre != null ? !semestre.equals(that.semestre) : that.semestre != null) return false;
        if (cursus != null ? !cursus.equals(that.cursus) : that.cursus != null) return false;
        if (niveau != null ? !niveau.equals(that.niveau) : that.niveau != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEtudiant;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (semestre != null ? semestre.hashCode() : 0);
        result = 31 * result + (cursus != null ? cursus.hashCode() : 0);
        result = 31 * result + (niveau != null ? niveau.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Collection<ParticipationEntity> getParticipationsByIdEtudiant() {
        return participationsByIdEtudiant;
    }

    public void setParticipationsByIdEtudiant(Collection<ParticipationEntity> participationsByIdEtudiant) {
        this.participationsByIdEtudiant = participationsByIdEtudiant;
    }
}
