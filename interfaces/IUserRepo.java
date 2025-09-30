package interfaces;

import entities.User;

public interface IUserRepo {
    void insertUser(User u);
    User getUser(String email, String password);
    void updateUser(User u);
    User searchUser(String userId);
    User[] getAllUsers(); // Must match UserRepo
}
