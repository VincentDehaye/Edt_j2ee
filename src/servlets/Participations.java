package servlets;

import beans.ParticipationEntity;
import beans.ProfesseurEntity;
import dao.DAOFactory;
import dao.InterfaceDao.ParticipationDao;
import dao.InterfaceDao.ProfesseurDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by vincent on 24/04/17.
 */
@WebServlet(name = "Participations")
public class Participations extends HttpServlet{
    public static final String CONF_DAO_FACTORY = "daofactory";

    private ParticipationDao partDao;
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.partDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY )).getParticipationDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<ParticipationEntity> listPart = partDao.findAll();
            request.setAttribute("listePart", listPart);
            request.getRequestDispatcher("participation.jsp").forward(request, response);

    }
}
