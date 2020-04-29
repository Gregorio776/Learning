package cn.edu.tsu.gengruiqiang.controller;

import cn.edu.tsu.gengruiqiang.bean.User;
import cn.edu.tsu.gengruiqiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gregorio
 * @date 2020/4/22 10:21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(String username,String password){
        return userService.login(username,password);
    }

    @PostMapping("/reg")
    public String reg(User user){
        int reg = userService.reg(user);
        if(reg>0){
            return "success";
        }
        return "failed";
    }

    @GetMapping("/info/{id}")
    public User info(@PathVariable(name = "id") int id){
        return userService.info(id);
    }

}
