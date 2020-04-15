package cn.edu.tsu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Gregorio
 * @date 2020/4/13 13:31
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

}
