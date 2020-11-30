package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private SessionFactory factory;

    public UserDaoHibernateImpl() {
        factory = Util.getHibernateFactory();
    }


    @Override
    public void createUsersTable() {
    }

    @Override
    public void dropUsersTable() {
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
    }

    @Override
    public void removeUserById(long id) {
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {
    }
}
