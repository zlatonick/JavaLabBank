package model;

import dao.DaoFactory;
import dao.DaoType;
import dao.instances.AbstractDao;
import model.accountOperations.AccountOperation;
import model.accountOperations.TransferOperation;
import model.accounts.Account;

import java.util.ArrayList;

public class User {

    private DaoFactory daoFactory;

    private int userId;

    public User(DaoFactory daoFactory, int userId) {
        this.daoFactory = daoFactory;
        this.userId = userId;
    }

    public ArrayList<Bill> getAllBills() {

        AbstractDao<Bill> billDao = daoFactory.getDao(DaoType.BILL);

        ArrayList<Bill> bills = billDao.findAll();

        bills.removeIf(bill -> bill.getUserId() != this.userId);

        return bills;
    }

    public boolean payBill(Bill bill, Account account) {

        if (account.getCurrBalance().compareTo(bill.getAmount()) < 0) {
            // Not enough money
            return false;
        }

        // Subtracting the amount of money
        account.setCurrBalance(account.getCurrBalance().subtract(bill.getAmount()));

        // Getting the DAOs
        AbstractDao<Account> accountDao = daoFactory.getDao(DaoType.ACCOUNT);
        AbstractDao<Bill> billDao = daoFactory.getDao(DaoType.BILL);

        // Updating the information in database
        if (accountDao.update(account) || billDao.delete(bill)) {
            return true;
        }

        return false;
    }

    public boolean makeTransfer(TransferOperation transfer, Account accountFrom,
                                Account accountTo) {

        if (accountFrom.getCurrBalance().compareTo(transfer.getAmount()) < 0) {
            // Not enough money
            return false;
        }

        // Changing the amount of money
        accountFrom.setCurrBalance(accountFrom.getCurrBalance().subtract(transfer.getAmount()));
        accountTo.setCurrBalance(accountTo.getCurrBalance().add(transfer.getAmount()));

        // Getting the DAOs
        AbstractDao<Account> accountDao = daoFactory.getDao(DaoType.ACCOUNT);
        AbstractDao<AccountOperation> transferDao = daoFactory.getDao(DaoType.ACCOUNT_OPERATIONS);

        // Updating the information in database
        if (accountDao.update(accountFrom) || accountDao.update(accountTo)
                || transferDao.delete(transfer)) {
            return true;
        }

        return false;
    }

    public ArrayList<Account> getAccountsInfo() {

        AbstractDao<Account> accountDao = daoFactory.getDao(DaoType.ACCOUNT);

        ArrayList<Account> accounts = accountDao.findAll();

        accounts.removeIf(account -> account.getUserId() != this.userId);

        return accounts;

    }

    public boolean newAccountRequest(AccountRequest accountRequest) {

        AbstractDao<AccountRequest> accountDao = daoFactory.getDao(DaoType.CREDIT_ACCOUNT_REQUEST);

        int id = accountDao.insert(accountRequest);

        if (id == -1) {
            return false;
        }

        accountRequest.setRequestId(id);
        return true;
    }

    public UserInfo getInfo() {

        AbstractDao<UserInfo> accountDao = daoFactory.getDao(DaoType.USER);

        return accountDao.findById(this.userId);
    }
}
