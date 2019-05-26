package dao.instances;

import model.Bill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BillDao extends AbstractDao<Bill> {

    public BillDao(Connection connection) {
        super(connection);
    }

    @Override
    public Bill findById(int id) {

        Bill bill;

        try {
            Statement statement = this.connection.createStatement();

            ResultSet res = statement.executeQuery(
                    "SELECT * FROM Bills WHERE Bill_id = " + id);

            res.next();       // Going to the first line

            bill = new Bill(id, res.getInt("User_id"),
                    res.getBigDecimal("Amount"), res.getDate("Pay_until"));
        }
        catch (SQLException e) {
            return null;
        }

        return bill;
    }

    @Override
    public ArrayList<Bill> findAll() {
        return null;
    }

    @Override
    public int insert(Bill entity) {
        return 0;
    }

    @Override
    public boolean update(Bill entity) {
        return false;
    }

    @Override
    public boolean delete(Bill entity) {
        return false;
    }
}
