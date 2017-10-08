package services;

import entity.User;

import java.util.List;

public interface UserService {
    void addUserService(User user);
    void deleteUserService(int userId);
    void updateUserService(User user);
    List<User> getAllUsersService();
    User getUserByIdService(int userId);
    User getUserByNameService(String userName);
}
