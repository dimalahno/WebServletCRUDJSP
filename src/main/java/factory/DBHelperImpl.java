package factory;

import entity.User;
import org.hibernate.cfg.Configuration;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelperImpl implements DBHelper{
    private static DBHelperImpl instance;

    private Connection connectionJdbc;
    private Configuration configurationHibernate;

    private static String PROPERTIES_DB = "D:\\MyJavaProject\\WebServer06\\src\\main\\resources\\db.properties";

    private DBHelperImpl(){}

    public static DBHelperImpl getInstance() {
        if (instance == null){
            instance = new DBHelperImpl();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        if (connectionJdbc != null){
            return connectionJdbc;
        }
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(PROPERTIES_DB);
            properties.load(fileInputStream);
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(driver).newInstance();
            connectionJdbc = DriverManager.getConnection(url, user, password);
            if(!connectionJdbc.isClosed()){
                System.out.println("Соединение с БД установленно через JDBC!");
            }
        } catch (IOException | IllegalAccessException | ClassNotFoundException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
        return connectionJdbc;
    }

    @Override
    public Configuration getConfiguration() {
        configurationHibernate = new Configuration();
        configurationHibernate.addAnnotatedClass(User.class);
        configurationHibernate.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configurationHibernate.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configurationHibernate.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydbtest");
        configurationHibernate.setProperty("hibernate.connection.username", "root");
        configurationHibernate.setProperty("hibernate.connection.password", "root");
        configurationHibernate.setProperty("hibernate.show_sql", "true");
        configurationHibernate.setProperty("hibernate.hbm2ddl.auto", "validate");
        System.out.println("Соединение с БД установленно через Hibernate!");
        return configurationHibernate;
    }
}
