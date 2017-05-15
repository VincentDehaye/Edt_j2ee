package beans;

/**
 * Created by Sylvain on 15/05/2017.
 */
public class ParticipationEntity {
    private int idParticipation;
    private EtudiantEntity etudiantByEtu;
    private CreneauEntity creneauByCren;

    public int getIdParticipation() {
        return idParticipation;
    }

    public void setIdParticipation(int idParticipation) {
        this.idParticipation = idParticipation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipationEntity that = (ParticipationEntity) o;

        if (idParticipation != that.idParticipation) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idParticipation;
    }

    public EtudiantEntity getEtudiantByEtu() {
        return etudiantByEtu;
    }

    public void setEtudiantByEtu(EtudiantEntity etudiantByEtu) {
        this.etudiantByEtu = etudiantByEtu;
    }

    public CreneauEntity getCreneauByCren() {
        return creneauByCren;
    }

    public void setCreneauByCren(CreneauEntity creneauByCren) {
        this.creneauByCren = creneauByCren;
    }
}
