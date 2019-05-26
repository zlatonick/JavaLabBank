package model;

import dao.DaoFactory;
import dao.DaoType;
import dao.instances.AbstractDao;
import model.accounts.Account;
import model.accounts.AccountNumbersGenerator;
import model.accounts.AccountType;
import model.accounts.CreditAccount;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Manager {

    private DaoFactory daoFactory;

    private int userId;

    public Manager(DaoFactory daoFactory, int userId) {
        this.daoFactory = daoFactory;
        this.userId = userId;
    }

    public ArrayList<AccountRequest> getAllRequests() {

        AbstractDao<AccountRequest> requestDao = daoFactory.getDao(DaoType.CREDIT_ACCOUNT_REQUEST);

        return requestDao.findAll();
    }

    public Account acceptRequest(AccountRequest request) {

        AbstractDao<AccountRequest> requestDao = daoFactory.getDao(DaoType.CREDIT_ACCOUNT_REQUEST);

        if (!requestDao.delete(request)) {
            return null;
        }

        AbstractDao<Account> accountDao = daoFactory.getDao(DaoType.ACCOUNT);

        Account newAccount = new CreditAccount(-1, AccountType.CREDIT,
                request.getUserId(), request.getAmount(), request.getTerm(),
                AccountNumbersGenerator.nextNumber(), request.getCreditRate(),
                new BigDecimal(0), new BigDecimal(0));

        int resId = accountDao.insert(newAccount);

        if (resId != -1) {
            newAccount.setAccountId(resId);
        }

        return newAccount;
    }

    public boolean declineRequest(AccountRequest request) {

        AbstractDao<AccountRequest> requestDao = daoFactory.getDao(DaoType.CREDIT_ACCOUNT_REQUEST);

        if (!requestDao.delete(request)) {
            return false;
        }

        return true;
    }

    public boolean addUser(UserInfo userInfo) {

        userInfo.setManager(false);

        AbstractDao<UserInfo> accountDao = daoFactory.getDao(DaoType.USER);

        int resId = accountDao.insert(userInfo);

        if (resId == -1) {
            return false;
        }

        userInfo.setUserId(resId);
        return true;
    }

    public boolean addManager(UserInfo info) {

        info.setManager(true);

        AbstractDao<UserInfo> accountDao = daoFactory.getDao(DaoType.USER);

        int resId = accountDao.insert(info);

        if (resId == -1) {
            return false;
        }

        info.setUserId(resId);
        return true;
    }

    public UserInfo getInfo() {

        AbstractDao<UserInfo> accountDao = daoFactory.getDao(DaoType.USER);

        return accountDao.findById(this.userId);
    }
}
