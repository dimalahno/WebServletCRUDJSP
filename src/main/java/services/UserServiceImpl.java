package services;

import dao.UserDao;
import entity.User;
import factory.DBFactory;
import factory.DBFactoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private DBFactory dbFactory;

    private static UserServiceImpl instance;

    private UserServiceImpl() {
        dbFactory = new DBFactoryImpl();
        userDao = dbFactory.getUserDao();
    }

    public static UserServiceImpl getInstance(){
        if (instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public void addUserService(User user){
        userDao.addUser(user);
    }

    public void deleteUserService (int userId){
        userDao.deleteUser(userId);
    }

    public void updateUserService(User user){
        userDao.updateUser(user);
    }

    public List<User> getAllUsersService (){
        return userDao.getAllUsers();
    }

    public User getUserByIdService (int userId){
        return userDao.getUserById(userId);
    }

    @Override
    public User getUserByNameService(String userName) {
        return userDao.getUserByName(userName);
    }


}
