package com.rahul.learning.powermock.bharath.repo;

import com.rahul.learning.powermock.bharath.dto.User;
import com.rahul.learning.powermock.bharath.util.IdGeneratorUtil;

public class UserDAO {
    public User create(User user) {

        int generatedId = IdGeneratorUtil.generateId();
        System.out.println("ID generated ==> "+generatedId);
        user.setId(generatedId);

        //save user to database
        return user;

    }
}
