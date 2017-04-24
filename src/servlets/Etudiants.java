package servlets;

/**
 * Created by Sylvain on 19/04/2017.
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import beans.ProfesseurEntity;
import dao.DAOFactory;
import dao.InterfaceDao.EtudiantDao;
import beans.EtudiantEntity;
//import forms.InscriptionForm;

@WebServlet(name = "Etudiants")
public class Etudiants extends HttpServlet {
    public static final String CONF_DAO_FACTORY = "daofactory";

    private EtudiantDao etuDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.etuDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getEtudiantDao();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        EtudiantEntity etu = new EtudiantEntity();
        etu.setNom( "Vincon");
        etu.setPrenom( "Helene");
        etu.setMail( "hv@gmail.com");
        etu.setCursus( "GB");
        etu.setNiveau( "branche");
        etu.setSemestre("4");
        etuDao.create(etu);
        */

        String mail = request.getParameter("mail");
        String action = request.getParameter("action");
        if (mail == null) {
            List<EtudiantEntity> listEtu = etuDao.findAll();
            request.setAttribute("listeEtu", listEtu);
        } else {
            if (action != null && action.equals("create")) {
                EtudiantEntity newEtu = new EtudiantEntity();
                newEtu.setNom(request.getParameter("nom"));
                newEtu.setPrenom(request.getParameter("prenom"));
                newEtu.setMail(mail);
                newEtu.setSemestre(request.getParameter("semestre"));
                newEtu.setCursus(request.getParameter("cursus"));
                newEtu.setNiveau(request.getParameter("niveau"));
                etuDao.create(newEtu);
                request.setAttribute("created", "created");
            } else if (action != null && action.equals("delete")) {
                EtudiantEntity etu = etuDao.find(mail);
                etuDao.delete(etu);
                request.setAttribute("deleted", "deleted");
            } else {
                EtudiantEntity etu = etuDao.find(mail);
                request.setAttribute("etu", etu);
            }
        }
        request.getRequestDispatcher("etudiant.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}