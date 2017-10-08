package util;

import factory.DBHelper;
import factory.DBHelperImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    private final SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;
    private DBHelper dbHelper;

    public HibernateUtil() {
        dbHelper = DBHelperImpl.getInstance();
        sessionFactory = buildSessionFactory();
    }

    // Создает сессию c БД
    private SessionFactory buildSessionFactory(){
        try {

            Configuration configuration = dbHelper.getConfiguration();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

            return configuration.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    // Чистит кеш и закрывает соединение с БД
    public void shutdown() {
        getSessionFactory().close();
    }
}
