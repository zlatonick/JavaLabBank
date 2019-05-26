package dao;

import dao.instances.AbstractDao;

public interface DaoFactory {

    AbstractDao getDao (DaoType daoType);

}
