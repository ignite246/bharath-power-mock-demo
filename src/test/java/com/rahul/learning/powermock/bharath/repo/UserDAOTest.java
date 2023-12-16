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
    public void testCreateUser_Should_Return_User_With_Unique_Id() {
        try {
            PowerMockito.mockStatic(IdGeneratorUtil.class);

            Integer expectedId = 112;

            //Stubbing or mocking expectation
            PowerMockito.when(IdGeneratorUtil.generateId()).thenReturn(expectedId);

            UserDAO dao = new UserDAO();
            User user = dao.create(new User("Rahul", "rk@outlook.com"));
            System.out.println(user);

            //Verifying if stubbed static methods are really getting called
            PowerMockito.verifyStatic();
            Assert.assertEquals(expectedId, user.getId());
        } catch (Exception e) {
            Assert.fail("Unit test failed :: " + e.getMessage());
        }
    }

}
