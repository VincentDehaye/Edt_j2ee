package servlets;

import beans.HoraireEntity;
import dao.DAOFactory;
import dao.InterfaceDao.HoraireDao;

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
@WebServlet(name = "Horaires")
public class Horaires extends HttpServlet {
    public static final String CONF_DAO_FACTORY = "daofactory";

    private HoraireDao horaireDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.horaireDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY )).getHoraireDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jour = request.getParameter("jour");
        List<HoraireEntity> listHor;
        if(jour !=null){
            listHor = horaireDao.find(jour);
            request.setAttribute("listeHor", listHor);
            request.setAttribute("jour", jour);
        }else{
            listHor = horaireDao.findAll();
            request.setAttribute("listeHor", listHor);
        }

        request.getRequestDispatcher("horaire.jsp").forward(request, response);

    }
}
