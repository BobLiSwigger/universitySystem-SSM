package DAO;

import POJOs.User;

public interface UserMapper {
    User getUserById(int id);
    void createUser(User user);
    void updateUser(User user);
    //void deleteUser(int id);
}
