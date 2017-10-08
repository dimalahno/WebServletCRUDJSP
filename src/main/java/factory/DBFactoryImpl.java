package factory;

import dao.UserDao;
import dao.UserDaoHibernateImpl;
import dao.UserDaoJDBCImpl;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class DBFactoryImpl implements DBFactory {
    private UserDao userDao;
    private static String PROPERTIES_FACTORY = "D:\\MyJavaProject\\WebServer06\\src\\main\\resources\\factory.properties";

    @Override
    public UserDao getUserDao() {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(PROPERTIES_FACTORY);
            properties.load(fileInputStream);
            String factory = properties.getProperty("factory");
            if (factory.equals("jdbc")){
                userDao = new UserDaoJDBCImpl();
            }else if (factory.equals("hibernate")){
                userDao = new UserDaoHibernateImpl();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       return userDao;
    }
}
