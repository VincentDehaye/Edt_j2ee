package dao;

import beans.HoraireEntity;
import beans.ParticipationEntity;
import dao.InterfaceDao.ParticipationDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;


/**
 * Created by vincent on 24/04/17.
 */
public class ParticipationDaoImpl implements ParticipationDao {

    private DAOFactory daoFactory;

    ParticipationDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    private static ParticipationEntity map(ResultSet resultSet ) throws SQLException {
        ParticipationEntity participation = new ParticipationEntity();
        participation.setEtu( resultSet.getInt( "Etu" ) );
        participation.setCren( resultSet.getInt( "Cren" ) );
        return participation;
    }

    @Override
    public List<ParticipationEntity> findAll() throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<ParticipationEntity> listPart = new ArrayList<ParticipationEntity>();
        String SQL_SELECT_PAR_EMAIL = "SELECT * FROM participation";

        try {
        /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false);
            resultSet = preparedStatement.executeQuery();
        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            while(resultSet.next()){
                listPart.add(map(resultSet));
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return listPart;
    }

    @Override
    public void create(ParticipationEntity part) throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        String SQL_INSERT = "INSERT INTO participation (Etu, Cren) VALUES (?, ?)";
        try {
        /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, false, part.getEtu(), part.getCren());
            int statut = preparedStatement.executeUpdate();
        /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }
        /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

}
