package Services;

import java.util.Date;

/**
 * Created by Sylvain on 05/05/2017.
 */
public class LigneEdt {
    private String uv;
    private String type;
    private String jour;
    private Date debut;
    private Date fin;
    private String salle;
    private String groupe;

    public LigneEdt(String uv, String type, String jour, Date debut, Date fin, String salle, String groupe){
        this.uv = uv;
        this.type = type;
        this.jour = jour;
        this.debut = debut;
        this.fin = fin;
        this.salle = salle;
        this.groupe = groupe;
    }

    public String getUv() {
        return uv;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    public String getType() {
        return type;
    }

    public void setType(String uv) {
        this.type = type;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String uv) {
        this.jour = jour;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

}
