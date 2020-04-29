package cn.edu.tsu.gengruiqiang.service;

import cn.edu.tsu.gengruiqiang.bean.User;

/**
 * @author Gregorio
 * @date 2020/4/22 10:41
 */
public interface UserService {
    User login(String username,String password);
    User info(int id);
    int reg(User user);
}
