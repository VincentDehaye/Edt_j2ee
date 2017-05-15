package beans;

import java.util.Collection;

/**
 * Created by Sylvain on 15/05/2017.
 */
public class CreneauEntity {
    private int idCreneau;
    private String salle;
    private String type;
    private String groupe;
    private String alternance;
    private UvEntity uvByUv;
    private HoraireEntity horaireByHoraire;
    private Collection<ParticipationEntity> participationsByIdCreneau;

    public int getIdCreneau() {
        return idCreneau;
    }

    public void setIdCreneau(int idCreneau) {
        this.idCreneau = idCreneau;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

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
        if (salle != null ? !salle.equals(that.salle) : that.salle != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (groupe != null ? !groupe.equals(that.groupe) : that.groupe != null) return false;
        if (alternance != null ? !alternance.equals(that.alternance) : that.alternance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCreneau;
        result = 31 * result + (salle != null ? salle.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (groupe != null ? groupe.hashCode() : 0);
        result = 31 * result + (alternance != null ? alternance.hashCode() : 0);
        return result;
    }

    public UvEntity getUvByUv() {
        return uvByUv;
    }

    public void setUvByUv(UvEntity uvByUv) {
        this.uvByUv = uvByUv;
    }

    public HoraireEntity getHoraireByHoraire() {
        return horaireByHoraire;
    }

    public void setHoraireByHoraire(HoraireEntity horaireByHoraire) {
        this.horaireByHoraire = horaireByHoraire;
    }

    public Collection<ParticipationEntity> getParticipationsByIdCreneau() {
        return participationsByIdCreneau;
    }

    public void setParticipationsByIdCreneau(Collection<ParticipationEntity> participationsByIdCreneau) {
        this.participationsByIdCreneau = participationsByIdCreneau;
    }
}
