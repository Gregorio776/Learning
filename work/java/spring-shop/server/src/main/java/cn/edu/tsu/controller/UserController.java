package cn.edu.tsu.controller;

import cn.edu.tsu.bean.User;
import cn.edu.tsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gregorio
 * @date 2020/4/13 10:46
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(String username, String password,Model model){
        return userService.login(username, password);
    }

    @PostMapping("/reg")
    public String register(User user){
        int register = userService.register(user);
        if(register>0){
            return "success";
        }
        return "fail";
    }

}
