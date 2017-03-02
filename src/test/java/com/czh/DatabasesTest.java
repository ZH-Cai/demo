package com.czh;

import com.czh.dao.UserDAO;
import com.czh.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DatabasesTest {
    @Autowired
    UserDAO userDAO;

    @Test
    public void contextLoads(){
        for(int i=0;i<4;i++){
            User user=new User();
            user.setName("aa"+i);
            user.setPassword("password"+i);
            user.setSalt("salt"+i);
            user.setId(i);
            user.setHeadUrl("url"+i);
            userDAO.addUser(user);
        }
    }
}
