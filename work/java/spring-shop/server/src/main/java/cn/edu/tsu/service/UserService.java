package cn.edu.tsu.service;

import cn.edu.tsu.bean.User;

/**
 * @author Gregorio
 * @date 2020/4/13 11:04
 */
public interface UserService {
    User login(String username,String password);
    int register(User user);
}
