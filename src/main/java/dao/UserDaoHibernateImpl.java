package dao;

import entity.User;
import org.hibernate.*;
import util.HibernateUtil;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private SessionFactory factory;
    private HibernateUtil hibernateUtil;

    public UserDaoHibernateImpl() {
        hibernateUtil = new HibernateUtil();
        factory = hibernateUtil.getSessionFactory();
    }

    public void addUser(User user) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }catch (HibernateException e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }

    public void deleteUser(int userId) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            User user = (User)session.get(User.class, userId);
            session.delete(user);
            transaction.commit();
        }catch (HibernateException e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }


    public void updateUser(User user) {
        Session session = factory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public List<User> getAllUsers() {
        Session session = factory.openSession();
        List<User> userList = session.createQuery("FROM User").list();
        session.close();
        return userList;
    }


    public User getUserById(int userId) {
        Session session = factory.openSession();
        Transaction transaction = null;
        User user = new User();
        try{
            transaction = session.beginTransaction();
            user = (User)session.get(User.class, userId);
        }catch (HibernateException e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return user;
    }

    public User getUserByName(String userName) {
        Session session = factory.openSession();
        Query query = session.createQuery("FROM User WHERE name = :nameParam");
        query.setParameter("nameParam", userName);
        List result = query.list();
        User user = (User)result.get(0);
        session.close();
        return user;
    }
}
