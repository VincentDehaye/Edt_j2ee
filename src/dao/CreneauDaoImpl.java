package dao;

import beans.CreneauEntity;
import dao.InterfaceDao.CreneauDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.DAOUtilitaire.fermeturesSilencieuses;
import static dao.DAOUtilitaire.initialisationRequetePreparee;

/**
 * Created by Sylvain on 24/04/2017.
 */
public class CreneauDaoImpl implements CreneauDao{
    private DAOFactory daoFactory;

    CreneauDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    public static CreneauEntity map(ResultSet resultSet ) throws SQLException {
        CreneauEntity creneau = new CreneauEntity();
        creneau.setIdCreneau( resultSet.getInt( "IdCreneau" ) );
        creneau.setUv( resultSet.getInt( "Uv" ) );
        creneau.setHoraire( resultSet.getInt( "Horaire" ) );
        creneau.setSalle( resultSet.getString( "Salle" ) );
        creneau.setType( resultSet.getString( "Type" ) );
        creneau.setGroupe( resultSet.getString( "Groupe" ) );
        creneau.setAlternance( resultSet.getString( "Alternance" ) );
        return creneau;
    }

    @Override
    public List<CreneauEntity> findAll() throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<CreneauEntity> listCreneau = new ArrayList<CreneauEntity>();
        String SQL_SELECT_ALL = "SELECT * FROM creneau";

        try {
        /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();
        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            while(resultSet.next()){
                listCreneau.add(map(resultSet));
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return listCreneau;
    }

    @Override
    public void create(CreneauEntity creneau) throws DAOException{
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
        String SQL_INSERT = "INSERT INTO professeur (Uv, Horaire, Salle, Type, Groupe, Alternance) VALUES (?, ?, ?, ?, ?, ?)";
        try {
        /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, creneau.getUv(), creneau.getHoraire(), creneau.getSalle(), creneau.getType(), creneau.getGroupe(), creneau.getAlternance());
            int statut = preparedStatement.executeUpdate();
        /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }
        /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
            /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                creneau.setIdCreneau( valeursAutoGenerees.getInt( 1 ) );
            } else {
                throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }
}
