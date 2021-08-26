package com.factories;

import com.models.User;
import com.tools.constants.EnvironmentConstants;
import net.bytebuddy.utility.RandomString;

public class UserFactory {

    public static User generateUser(){
        User user = new User();
        user.setFirstName(RandomString.make(10));
        user.setMiddleName(RandomString.make(10));
        user.setLastName(RandomString.make(10));
        user.setEmail(RandomString.make(10)+"@yahoo.com");
        user.setPassword(RandomString.make(10));
        return user;
    }
    public static User getUserCredentials(){
        User user = new User();
//        user.setFirstName(user.getFirstName());
//        user.setLastName(user.getLastName());
//        user.setMiddleName(user.getMiddleName());
        user.setEmail(EnvironmentConstants.EMAIL);
        user.setPassword(EnvironmentConstants.PASS);
        return user;
    }
}
