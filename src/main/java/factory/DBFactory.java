package factory;

import dao.UserDao;

public interface DBFactory {
    UserDao getUserDao();
}
