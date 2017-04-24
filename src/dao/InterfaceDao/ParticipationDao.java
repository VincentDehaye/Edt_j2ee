package dao.InterfaceDao;

import beans.ParticipationEntity;
import dao.DAOException;

import java.util.List;

/**
 * Created by vincent on 24/04/17.
 */
public interface ParticipationDao {

        List<ParticipationEntity> findAll() throws DAOException;

        void create(ParticipationEntity particip) throws DAOException;

}
