package dao;

import dao.instances.AbstractDao;
import dao.instances.BillDao;

public class DaoFactoryImpl implements DaoFactory {

    @Override
    public AbstractDao getDao(DaoType daoType) {
        switch (daoType) {
            case USER:
                break;
            case CREDIT_ACCOUNT_REQUEST:
                break;
            case ACCOUNT:
                break;
            case OPERATION_TYPES:
                break;
            case BILL:
                return new BillDao(ConnectionPool.getConnection());
            case ACCOUNT_TYPES:
                break;
            case ACCOUNT_OPERATIONS:
                break;
        }
        return null;
    }
}
