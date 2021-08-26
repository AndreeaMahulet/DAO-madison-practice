package com.dao.registration;

import com.google.inject.ImplementedBy;
import com.models.User;

import java.util.List;

@ImplementedBy(UserDao.class)
public interface UserAbstractDao {
    public void saveRegisteredUser(User user);
    public void saveLoggedInUser(User user);
    public List<User> getAllUsers();
    public void removeUser(User user);
    public User getUserByEmail(String email);
}
