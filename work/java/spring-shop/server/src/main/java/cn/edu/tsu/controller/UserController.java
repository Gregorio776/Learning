package cn.edu.tsu.controller;

import cn.edu.tsu.bean.User;
import cn.edu.tsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gregorio
 * @date 2020/4/13 10:46
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(String username, String password,Model model){
        User user = userService.login(username, password);
        model.addAttribute("user",user);
        return "success";
    }

    @PostMapping("/reg")
    public String register(User user){
        int register = userService.register(user);
        if(register>0){
            return "success";
        }
        return "fail";
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String info(){
        return "login";
    }
}
