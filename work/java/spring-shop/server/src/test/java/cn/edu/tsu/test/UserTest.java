package cn.edu.tsu.test;

import cn.edu.tsu.bean.User;
import cn.edu.tsu.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Gregorio
 * @date 2020/4/13 11:09
 */

public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void testLogin(){
        User u=new User();
        u.setUsername("T2om");
        u.setPassword("123456");
        u.setAge(15);
        int register = userService.register(u);
        System.out.println(register);
        System.out.println(userService.login("T2om","123456"));
    }

}
