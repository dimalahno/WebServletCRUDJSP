package dao;


import entity.User;
import factory.DBHelper;
import factory.DBHelperImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    private Connection connectionDB;
    private DBHelper dbHelper;

    public UserDaoJDBCImpl() {
        dbHelper = DBHelperImpl.getInstance();
        connectionDB = dbHelper.getConnection();
    }

    public void addUser(User user) {
        try {
            String query = "insert into users (name, age, email) values(?, ?, ?)";
            PreparedStatement preparedStatement = connectionDB.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void deleteUser(int userId) {
        try {
            String query = "delete from users where id=?";
            PreparedStatement preparedStatement = connectionDB.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void updateUser(User user) {
        try {
            String query = "update users set name=?, age=?, email=? where id=?";
            PreparedStatement preparedStatement = connectionDB.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String query = "select * from users";
        try(Statement statement = connectionDB.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                userList.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }


    public User getUserById(int userId) {
        User user = new User();
        String query = "select * from users where id=?";
        try {
            PreparedStatement preparedStatement = connectionDB.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public User getUserByName(String userName) {
        User user = new User();
        String query = "select * from users where name=?";
        try {
            PreparedStatement preparedStatement = connectionDB.prepareStatement(query);
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
