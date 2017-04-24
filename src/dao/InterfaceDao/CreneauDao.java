package dao.InterfaceDao;

import beans.CreneauEntity;
import dao.DAOException;

import java.util.List;

/**
 * Created by Sylvain on 24/04/2017.
 */
public interface CreneauDao {
    List<CreneauEntity> findAll() throws DAOException;

    void create(CreneauEntity etu) throws DAOException;
}
