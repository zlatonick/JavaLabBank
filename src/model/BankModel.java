package model;

import dao.DaoFactory;
import dao.DaoType;
import dao.instances.UserInfoDao;

public class BankModel {

    private DaoFactory daoFactory;

    public BankModel(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public User loginAsUser(String login, String password) {

        UserInfoDao userDao = (UserInfoDao) daoFactory.getDao(DaoType.USER);

        int resId = userDao.login(login, password);

        if (resId == -1) {
            return null;
        }

        return new User(this.daoFactory, resId);
    }

    public Manager loginAsManager(String login, String password) {

        UserInfoDao userDao = (UserInfoDao) daoFactory.getDao(DaoType.USER);

        int resId = userDao.login(login, password);

        if (resId == -1) {
            return null;
        }

        return new Manager(this.daoFactory, resId);
    }

    public void closeConnection() {

    }
}
