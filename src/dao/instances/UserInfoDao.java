package dao.instances;

import model.User;
import model.UserInfo;

import java.sql.Connection;
import java.util.ArrayList;

public class UserInfoDao extends AbstractDao<UserInfo> {

    public UserInfoDao(Connection connection) {
        super(connection);
    }

    @Override
    public UserInfo findById(int id) {
        return null;
    }

    @Override
    public ArrayList<UserInfo> findAll() {
        return null;
    }

    @Override
    public int insert(UserInfo entity) {
        return 0;
    }

    @Override
    public boolean update(UserInfo entity) {
        return false;
    }

    @Override
    public boolean delete(UserInfo entity) {
        return false;
    }

    public int login(String login, String password) {
        return -1;
    }
}
