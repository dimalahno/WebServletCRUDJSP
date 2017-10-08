package dao;

import entity.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUser(int userId);
    void updateUser(User user);
    List<User> getAllUsers();
    User getUserById(int userId);
    User getUserByName(String userName);
}
