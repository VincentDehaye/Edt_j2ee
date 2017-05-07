package dao;

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
}
