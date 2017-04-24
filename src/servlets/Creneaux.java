package servlets;

import beans.CreneauEntity;
import dao.DAOFactory;
import dao.InterfaceDao.CreneauDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sylvain on 24/04/2017.
 */
@WebServlet(name = "Creneaux")
public class Creneaux extends HttpServlet {
    public static final String CONF_DAO_FACTORY = "daofactory";

    private CreneauDao creneauDao;
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.creneauDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY )).getCreneauDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CreneauEntity> listCren = creneauDao.findAll();
        request.setAttribute("listeCren", listCren);
        request.getRequestDispatcher("creneau.jsp").forward(request, response);
    }
}
