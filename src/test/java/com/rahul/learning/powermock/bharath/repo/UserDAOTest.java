package com.rahul.learning.powermock.bharath.repo;

import com.rahul.learning.powermock.bharath.util.IdGeneratorUtil;
import com.rahul.learning.powermock.bharath.dto.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGeneratorUtil.class)
public class UserDAOTest {

    @Test
    public void testCreateUser_Should_Return_User_With_Unique_Id(){
        PowerMockito.mockStatic(IdGeneratorUtil.class);

        Integer generatedId = 112;

        //Stubbing Expectation
        PowerMockito.when(IdGeneratorUtil.generateId()).thenReturn(generatedId);

        UserDAO dao = new UserDAO();
        User user = dao.create(new User("Rahul", "rk@outlook.com"));
        System.out.println(user);

        PowerMockito.verifyStatic();
        Assert.assertEquals(generatedId,user.getId());
    }

}
