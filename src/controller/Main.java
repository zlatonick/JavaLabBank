package controller;

import dao.DaoFactory;
import dao.DaoFactoryImpl;
import dao.DaoType;
import dao.instances.AbstractDao;
import model.Bill;

import java.math.BigDecimal;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        DaoFactory daoFactory = new DaoFactoryImpl();

        AbstractDao<Bill> billDao = daoFactory.getDao(DaoType.BILL);

        int result = billDao.insert(
                new Bill(-1, 1, new BigDecimal(2000), Date.valueOf("2019-05-27")));

        billDao.close();

        System.out.println("Inserted successfully. Insert id is " + result);
    }
}
